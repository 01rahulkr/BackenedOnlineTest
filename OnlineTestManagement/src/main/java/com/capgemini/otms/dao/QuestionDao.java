package com.capgemini.otms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.otms.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

}
