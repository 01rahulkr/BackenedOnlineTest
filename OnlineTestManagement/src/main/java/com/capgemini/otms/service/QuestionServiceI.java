package com.capgemini.otms.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.otms.entity.Question;

public interface QuestionServiceI {
public String addQuestion(int testId,Question question);
public String deleteQuestion(int questionId);
public String updateQuestion(int questionId,Question question);
public List<Question> viewAll();
public Optional<Question> findById(int id);
}
