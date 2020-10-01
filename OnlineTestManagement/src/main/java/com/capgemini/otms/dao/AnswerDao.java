package com.capgemini.otms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.otms.entity.Answer;
@Repository
public interface AnswerDao extends JpaRepository<Answer, Integer> {

}
