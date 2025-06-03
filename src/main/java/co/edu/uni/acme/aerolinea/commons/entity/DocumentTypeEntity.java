package co.edu.uni.acme.aerolinea.commons.entity;

import co.edu.uni.acme.aerolinea.commons.utils.enums.DocumentTypeEnum;
import co.edu.uni.acme.aerolinea.commons.utils.helper.DocumentTypeConverter;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "document_type")
public class DocumentTypeEntity {

    @Id
    @Column(name = "code_document_type")
    private String codeTypeDocument;

    @Column(name = "name_document_type")
    @Convert(converter = DocumentTypeConverter.class)
    private DocumentTypeEnum nameDocumentType;
}
