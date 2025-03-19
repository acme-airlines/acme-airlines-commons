package co.edu.uni.acme.aerolinea.commons.service.impl;

import co.edu.uni.acme.aerolinea.commons.dto.AuthResponseDTO;
import co.edu.uni.acme.aerolinea.commons.dto.PassengerSecurityDTO;
import co.edu.uni.acme.aerolinea.commons.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.*;


@Service
@Log4j2
@RequiredArgsConstructor
public class JwtService implements IJwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public String getToken(UserDetails userDetails) {
        Map<String, Object> additionalClaims = new HashMap<>();
        PassengerSecurityDTO passengerSecurityDTO = (PassengerSecurityDTO) userDetails;
        additionalClaims.put(CLAIM_CODE_PASSENGER, passengerSecurityDTO.getCodePassenger());
        return buildToken(additionalClaims, userDetails);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return getClaims(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public AuthResponseDTO generatedToken(UserDetails userDetails) {
        return AuthResponseDTO.builder().token(getToken(userDetails)).build();
    }

    public String getIdentifierFromToken(String token) {
        Claims claims = getAllClaims(token);

        if (claims.containsKey(CLAIM_CODE_PASSENGER)) {
            return claims.get(CLAIM_CODE_PASSENGER, String.class);
        }
        throw new IllegalArgumentException(ERROR_INVALID_IDENTIFIER);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails user) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        return Jwts.builder()
                .claims(extraClaims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MILLIS))
                .signWith(key)
                .compact();
    }

    private <T> T getClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

}
