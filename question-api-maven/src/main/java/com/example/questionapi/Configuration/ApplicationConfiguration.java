package com.example.questionapi.Configuration;

import com.example.questionapi.Repository.QuestionRepository;
import com.example.questionapi.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Component
public class ApplicationConfiguration implements ApplicationRunner {

    @Autowired
    DatabaseClient databaseClient;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // create a stream of Questions to intialize to database
        Stream<Question> streamQuestions = Stream.of(
                new Question("What is the real name of SpiderMan?", "peter piper | Peter Park | Peter Parker", 3),
                new Question("What is the real name of IronMan?", "Tony Shark | Tony Shank | Tony Stark", 3)
        );

        // create new table in H2 database and load the table with initial data
        databaseClient.execute("CREATE TABLE question (" +
                "id Long Primary Key  AUTO_INCREMENT," +
                "question VARCHAR(255)," +
                "choices VARCHAR(255)," +
                "answer INT)")
                .then()
                .thenMany(questionRepository.saveAll(Flux.fromStream(
                       streamQuestions

                )))
                .subscribe();

    }
}
