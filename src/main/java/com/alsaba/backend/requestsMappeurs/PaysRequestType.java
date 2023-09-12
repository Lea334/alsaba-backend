package com.alsaba.backend.requestsMappeurs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class PaysRequestType {
    private String countryName;
    private String countryCode;
    private String countryDenomination;
    private String countryDevise ;
    private String countryCapital;
    private Date countryModificationDate ;
    private Date countryCreationDate ;
}
