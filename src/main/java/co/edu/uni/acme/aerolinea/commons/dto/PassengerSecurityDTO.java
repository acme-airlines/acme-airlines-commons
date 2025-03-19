package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class PassengerSecurityDTO extends PassengerDTO implements UserDetails {

    public PassengerSecurityDTO(PassengerDTO passengerDTO) {
        super(passengerDTO.getCodePassenger(),
                passengerDTO.getNamePassenger(),
                passengerDTO.getLastNamePassenger(),
                passengerDTO.getPhonePassenger(),
                passengerDTO.getDocumentTypePassengerFk(),
                passengerDTO.getNumberDocumentPassenger(),
                passengerDTO.getEmailPassenger(),
                passengerDTO.getBirthDate(),
                passengerDTO.getCreationDate(),
                passengerDTO.getGenderPassenger(),
                passengerDTO.getHashPassword());
    }

    @Override
    public String getPassword() {
        return getHashPassword();
    }

    @Override
    public String getUsername() {
        return getEmailPassenger();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}
