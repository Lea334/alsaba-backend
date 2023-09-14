package com.alsaba.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Pays")
public class Pays{
    @Id
    private String id;
    private String nom_pays;
    private String code_pays;
    private String devise_pays;
    private String designation_pays ;
    private String capitale_pays;
    private LocalDateTime dateCreation_pays ;
    private LocalDateTime dateModification_pays ;

    @JsonIgnore
    private boolean est_activer ;
    @JsonIgnore
    private boolean est_suspendue ;
    @JsonIgnore
    @DocumentReference
    private FraisOperation frais_pays;
    @DocumentReference(lazy = true)
    private List<Ville> villes ;

    public Pays(String nom , String code, String designation ,  String devise , String capitale , LocalDateTime dateCreation_pays , LocalDateTime dateModification_pays ){
        this.nom_pays = nom;
        this.code_pays = code;
        this.designation_pays = designation ;
        this.devise_pays = devise;
        this.capitale_pays = capitale;
        this.dateCreation_pays = dateCreation_pays ;
        this.dateModification_pays = dateModification_pays ;
    }

    // ------------------------Methods---------------------------------
    public String toString(){
        return "Nom_Pays: "+this.nom_pays;
    }
}