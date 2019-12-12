package com.example.questionapi.Repository;

import com.example.questionapi.model.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface QuestionRepository extends ReactiveCrudRepository<Question, Long> {
}
