package com.alsaba.backend.model;

import com.alsaba.backend.model.types.Quote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("Taux")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Taux {
    @Id
    private String id ;
    private String base ;
    private List<Quote> quotes ;
}

