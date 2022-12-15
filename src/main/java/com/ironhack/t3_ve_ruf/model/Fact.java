package com.ironhack.t3_ve_ruf.model;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String source;

    private String sourceUrl;

    private String language;

    private String permalink;

    @CreationTimestamp
    private Instant creationDate;

    @UpdateTimestamp
    private Instant lastUpdate;

    @Version //añade una columna a la tabla aumentando contador al realizar modificación
    private int version;

    public Fact(String text, String source, String sourceUrl, String language, String permalink) {
        this.text = text;
        this.source = source;
        this.sourceUrl = sourceUrl;
        this.language = language;
        this.permalink = permalink;
    }

//    public static Object fromDTO(FactDTO fact) {
//        var fact = new Fact();
//        fact.setText
//
//    }
}
