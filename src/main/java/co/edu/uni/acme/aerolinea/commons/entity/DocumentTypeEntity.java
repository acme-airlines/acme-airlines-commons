package co.edu.uni.acme.aerolinea.commons.entity;

import co.edu.uni.acme.aerolinea.commons.utils.enums.DocumentTypeEnum;
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
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum nameDocumentType;
}
