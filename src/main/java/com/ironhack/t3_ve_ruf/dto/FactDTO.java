package com.ironhack.t3_ve_ruf.dto;

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
    private String source_url;
    private String language;
    private String permalink;

}
