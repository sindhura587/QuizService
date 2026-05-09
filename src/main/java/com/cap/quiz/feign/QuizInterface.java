package com.cap.quiz.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cap.quiz.model.QuestionWrapper;
import com.cap.quiz.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

     @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numOfQues);
    

     @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionIds);
       
 @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

    
} 
