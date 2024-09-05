package com.ff.quizservice.service;


import com.ff.quizservice.dao.QuizDao;
import com.ff.quizservice.dto.QuestionWrapper;
import com.ff.quizservice.dto.Response;
import com.ff.quizservice.dto.ResponseStructure;
import com.ff.quizservice.entity.Quiz;
import com.ff.quizservice.feignCllient.QuizInterface;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

//quizDao
//    @Autowired
//    QuestionDao questionDao;

    public List<QuestionWrapper> getQuizById(String quizId) {
        Quiz quiz = quizDao.findById(quizId).get();
        List<Long> questionIds = quiz.getQuestions();
        List<QuestionWrapper> wrapper = new ArrayList<>();
        questionIds.stream().forEach((id)->wrapper.add(quizInterface.getQuestionById(id)));

//        for(Long id: questionIds)
//        {
//            QuestionWrapper questionId = quizInterface.getQuestionById(id);
//            System.out.println(questionId);
//            wrapper.add(questionId);
//        }
        return wrapper;

    }

    public Quiz saveQuiz(Quiz quiz) {
        List<Long> questionIds = quizInterface.getAllQuestionIds();  //generate question Id
        quiz.setQuestions(questionIds);
        return quizDao.save(quiz);
    }

//    public int getScore(List<Response> response, String id) {
//        Quiz quiz = quizDao.findById(id).get();
//
//        int score = 0;
//
//        for(Long value : quizInterface.getAllQuestionIds())
//        {
//            for(Response responses: response)
//            {
////                System.err.println(question.getQuestion()+" = = "+responses.getQuestion());
////                System.err.println(question.getRightAnswer()+" = = "+responses.getAnswer());
//                if(value.equals(responses.getQuestionId())&& quizInterface.getQuestionById(value).get)
//                    ++score;
//            }
//        }
//        return score;
//    }
}
