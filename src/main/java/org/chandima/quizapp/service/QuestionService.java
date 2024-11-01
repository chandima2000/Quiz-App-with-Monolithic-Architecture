package org.chandima.quizapp.service;

import org.chandima.quizapp.model.Question;
import org.chandima.quizapp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestionByCategory(String category){
        return questionRepo.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionRepo.save(question);
        return "Question Added Successfully";
    }
}
