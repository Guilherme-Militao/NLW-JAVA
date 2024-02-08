package com.militao.certification_nlw.modules.questions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.militao.certification_nlw.modules.questions.dto.QuestionResultDto;
import com.militao.certification_nlw.modules.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDto> findByTecnology(@PathVariable("technology") String technology){
        return this.questionRepository.findByTechnology(technology)
                .stream()
                .map(x -> this.objectMapper.convertValue(x, QuestionResultDto.class))
                .collect(Collectors.toList());

    }
}
