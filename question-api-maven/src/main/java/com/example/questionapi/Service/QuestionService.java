package com.example.questionapi.Service;

import com.example.questionapi.Repository.QuestionRepository;
import com.example.questionapi.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Mono saveQuestion (Mono <Question> questionMono) {
        return questionMono.flatMap(question -> questionRepository.save(question));
    };
}
