package com.militao.certification_nlw.modules.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlternativesResultDto {

    private UUID id;
    private String description;
}
