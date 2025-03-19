package co.edu.uni.acme.aerolinea.commons.utils.helper;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Optional;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.*;

public class Utils {

    public static <T> Optional<T> checkType(Object obj, Class<T> clazz) {
        if (Objects.isNull(obj)) {
            return Optional.empty();
        }

        try {
            return switch (clazz.getSimpleName()) {
                case "Long" -> Optional.of(clazz.cast(Long.valueOf(obj.toString())));
                case "String" -> Optional.of(clazz.cast(String.valueOf(obj)));
                case "Integer" -> Optional.of(clazz.cast(Integer.valueOf(obj.toString())));
                case "Double" -> Optional.of(clazz.cast(Double.valueOf(obj.toString())));
                case "Date" -> {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                    dateFormat.setLenient(false);
                    yield Optional.of(clazz.cast(dateFormat.parse(obj.toString())));
                }
                case "BigDecimal" -> Optional.of(clazz.cast(BigDecimal.valueOf(Double.parseDouble(obj.toString()))));
                default -> Optional.empty();
            };
        } catch (Exception e) {
            throw new IllegalArgumentException(TYPE_CONVERSION_ERROR + e.getMessage(), e);
        }
    }



}
