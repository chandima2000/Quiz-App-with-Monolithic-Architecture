package org.chandima.quizapp.service;

import org.chandima.quizapp.model.Question;
import org.chandima.quizapp.model.Quiz;
import org.chandima.quizapp.repository.QuestionRepo;
import org.chandima.quizapp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        Quiz quiz = new Quiz();

        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category,numQ);

        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }
}
