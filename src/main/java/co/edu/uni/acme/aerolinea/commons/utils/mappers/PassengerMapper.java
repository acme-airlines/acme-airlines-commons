package co.edu.uni.acme.aerolinea.commons.utils.mappers;

import co.edu.uni.acme.aerolinea.commons.dto.PassengerDTO;
import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerDTO entityToDto(PassengerEntity entity);

    PassengerEntity dtoToEntity(PassengerDTO dto);

    List<PassengerDTO> listEntityToListDto(List<PassengerEntity> entity);

    List<PassengerEntity>listDtoToListEntity(List<PassengerDTO> dto);
}
