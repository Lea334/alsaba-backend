package com.alsaba.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Pays")
public class Pays{
    @Id
    private String id;

    @Indexed(unique = true)
    private String nom;
    private String code;
    private String devise;
    private String capitale;
    private float frais;
    private float taux_echange;
    private String responsable;

    public Pays(String nom , String code, String devise, String capitale,float frais,float taux_echange){
        this.nom = nom;
        this.code = code;
        this.devise = devise;
        this.capitale = capitale;
        this.frais = frais;
        this.taux_echange = taux_echange;
        this.responsable = "";
    }

    // ------------------------Methods---------------------------------
    public String toString(){
        return "Nom_Pays: "+this.nom;
    }
}
