package com.capgemini.otms.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.otms.entity.Test;

public interface TestServiceI {

	public Test addTest(Test test);
	public String deleteTest(int testId);
	public String updateTest(int testId,Test test);
	public List<Test> viewAll();
	public Optional<Test> findById(int id);
}
