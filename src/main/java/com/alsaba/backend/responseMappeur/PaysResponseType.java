package com.alsaba.backend.responseMappeur;

import com.alsaba.backend.model.Pays;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@AllArgsConstructor
public class PaysResponseType  extends Pays {
    private String countryName;
    private String countryCode;
    private String countryDenomination;
    private String countryDevise ;
    private String countryCapital;
    private Date countryModificationDate ;
    private Date countryCreationDate ;
}
