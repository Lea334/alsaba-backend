package com.alsaba.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ville {
    @Id
    private String id ;
    private String nom_ville ;
    private boolean est_activer ;
    private boolean est_suspendue ;
}
