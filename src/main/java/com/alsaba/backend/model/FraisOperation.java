package com.alsaba.backend.model;

import com.alsaba.backend.model.types.enums.TypeFrais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FraisOperation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraisOperation {

    private double valeur_inf ;
    private double valeur_sup ;
    private TypeFrais type_frais;
    private double valeur_taux ;

}

