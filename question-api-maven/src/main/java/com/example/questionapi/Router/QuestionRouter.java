package com.example.questionapi.Router;

import com.example.questionapi.Handler.QuestionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QuestionRouter {

    @Bean
    public RouterFunction<ServerResponse> routeSample(QuestionHandler handler) {
        return
                route().
                        GET("/questions", accept(MediaType.APPLICATION_JSON), handler::getALLQuestions)
                .POST("/question", handler::createQuestion)
                .build();
    }
}
