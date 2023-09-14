package com.alsaba.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ville {
    @Id
    private String id ;
    private String nom_ville ;
    private LocalDateTime dateCreation_ville ;
    private LocalDateTime dateModification_ville ;
    private String pays_id ;
    @JsonIgnore
    private boolean est_activer ;
    @JsonIgnore
    private boolean est_suspendue ;
}
