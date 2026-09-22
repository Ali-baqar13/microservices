package com.microservices.microservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservice.model.Question;
import com.microservices.microservice.service.QuestionService;



@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    public QuestionService questionService;

    @GetMapping("get")
    public ResponseEntity<List<Question>> getQuestions() {

        List<Question> questions = questionService.getQuestions();

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCatgory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }
    

    @PostMapping("create-question")
    public ResponseEntity<String> postQuestions(@RequestBody Question question) {

        questionService.addQuestion(question);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }
   
}
