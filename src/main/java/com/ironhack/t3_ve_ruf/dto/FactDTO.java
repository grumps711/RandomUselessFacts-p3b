package com.ironhack.t3_ve_ruf.dto;

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

}
