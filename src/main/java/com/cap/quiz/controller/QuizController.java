package com.cap.quiz.controller;


import com.cap.quiz.model.QuestionWrapper;
import com.cap.quiz.model.QuizDTO;
import com.cap.quiz.model.Response;
import com.cap.quiz.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// controller for quiz
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizdto){
        return quizService.createQuiz(quizdto.getCategoryName(),quizdto.getNumQuestions(),quizdto.getTitle());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }


}
