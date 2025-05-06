package co.edu.uni.acme.aerolinea.commons.utils.mappers;

import co.edu.uni.acme.aerolinea.commons.dto.UserDTO;
import co.edu.uni.acme.aerolinea.commons.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO entityToDto(UserEntity entity);

    UserEntity dtoToEntity(UserDTO dto);

    List<UserDTO> listEntityToListDto(List<UserEntity> entity);

    List<UserEntity>listDtoToListEntity(List<UserDTO> dto);
}
