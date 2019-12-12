package com.example.questionapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    private Long id;
    private String question;
    private String choices;
    private int answer;

    // constructor without id
    public Question(String question, String choices, int answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }
}
