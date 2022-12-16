package com.ironhack.t3_ve_ruf.dto;

import com.ironhack.t3_ve_ruf.model.Fact;
import jakarta.persistence.Version;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
public class FactDTO {

    private String text;
    private String source;
    private String source_url;
    private String language;
    private String permalink;

    public static FactDTO fromFact(Fact fact){
        var factDTO = new FactDTO();
        factDTO.setText(fact.getText());
        factDTO.setSource(fact.getSource());
        factDTO.setSource_url(fact.getSourceUrl());
        factDTO.setLanguage(fact.getLanguage());
        factDTO.setPermalink(fact.getPermalink());
        return factDTO;
    }
}
