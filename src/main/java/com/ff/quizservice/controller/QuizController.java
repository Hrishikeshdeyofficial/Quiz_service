package com.ff.quizservice.controller;


import com.ff.quizservice.dto.QuestionWrapper;
import com.ff.quizservice.dto.Response;
import com.ff.quizservice.dto.ResponseStructure;
import com.ff.quizservice.entity.Quiz;
import com.ff.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("{id}")
    public List<QuestionWrapper> getQuizById(@PathVariable String id) {
        return quizService.getQuizById(id);
    }

    @PostMapping
    public Quiz saveQuiz(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

//    @GetMapping("/submit/{id}")
//    public int getQuizScore(@RequestBody List<Response> responses, @PathVariable String id) {
//        return quizService.getScore(responses, id);
//    }
}
