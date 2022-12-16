package com.ironhack.t3_ve_ruf.dto;

import com.ironhack.t3_ve_ruf.model.Fact;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactDTO {

    private String text;
    private String source;
    private String sourceUrl;
    private String language;
    private String permalink;

    public static FactDTO fromFact(Fact fact){
        var factDTO = new FactDTO();
        factDTO.setText(fact.getText());
        factDTO.setSource(fact.getSource());
        factDTO.setSourceUrl(fact.getSourceUrl());
        factDTO.setLanguage(fact.getLanguage());
        factDTO.setPermalink(fact.getPermalink());
        return factDTO;
    }
}
