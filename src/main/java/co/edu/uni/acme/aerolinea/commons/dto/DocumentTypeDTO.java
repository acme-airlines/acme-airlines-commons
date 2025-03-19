package co.edu.uni.acme.aerolinea.commons.dto;

import co.edu.uni.acme.aerolinea.commons.utils.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentTypeDTO {

    private String codeTypeDocument;

    private DocumentTypeEnum nameDocumentType;

}
