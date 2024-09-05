package com.ff.quizservice.feignCllient;

import com.ff.quizservice.dto.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("questionservice")
public interface QuizInterface {

    @GetMapping("question/Id")
    public List<Long> getAllQuestionIds();

    @GetMapping("/question/{id}")
    public QuestionWrapper getQuestionById(@PathVariable long id);


}
