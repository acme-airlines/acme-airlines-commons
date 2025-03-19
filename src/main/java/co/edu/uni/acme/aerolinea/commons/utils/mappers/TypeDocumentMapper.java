package co.edu.uni.acme.aerolinea.commons.utils.mappers;

import co.edu.uni.acme.aerolinea.commons.dto.DocumentTypeDTO;
import co.edu.uni.acme.aerolinea.commons.entity.DocumentTypeEntity;
import org.mapstruct.Mapper;
import org.w3c.dom.DocumentType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeDocumentMapper {

    DocumentTypeDTO entityToDto(DocumentTypeEntity entity);

    DocumentTypeEntity dtoToEntity(DocumentTypeDTO dto);

    List<DocumentTypeDTO> listEntityToListDto(List<DocumentTypeEntity> entity);

    List<DocumentTypeEntity> listDtoToEntity(List<DocumentTypeDTO> dto);
}
