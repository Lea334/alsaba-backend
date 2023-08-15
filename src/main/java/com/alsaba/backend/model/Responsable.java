package com.alsaba.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document
public class Responsable {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adress;
    private String documents;

}
