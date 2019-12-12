package com.example.questionapi.Handler;

import com.example.questionapi.Repository.QuestionRepository;
import com.example.questionapi.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class QuestionHandler {

    @Autowired
    QuestionRepository questionRepository;

    // get all questions from h2 database
    public Mono<ServerResponse> getALLQuestions(ServerRequest serverRequest){
        Flux<Question> questions = questionRepository.findAll();
        return ok().contentType(MediaType.APPLICATION_JSON).body(questions, Question.class);
    }


}
