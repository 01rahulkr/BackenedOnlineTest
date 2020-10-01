package com.capgemini.otms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.capgemini.otms.dao.TestDao;
import com.capgemini.otms.entity.Test;
import com.capgemini.otms.exception.EntityNotFoundException;

@Service
public class TestService implements TestServiceI {

	@Autowired
	TestDao dao;

	/*
	 * Add test with auto-generated test id
	 */

	@Override
	public Test addTest(@Validated Test test) {

		return dao.save(test);
	}

	/*
	 * Delete test by test id test id passed cannot be negative test must be present
	 * to be deleted
	 */

	@Override
	public String deleteTest(int testId) {

		Optional<Test> findById = dao.findById(testId);
		if (findById.isPresent()) {
			dao.deleteById(testId);
			return "Test deleted";
		} else {
			throw new EntityNotFoundException("No test found with test id " + testId);
		}

	}

	/*
	 * Update test by test id test id passed cannot be negative test must be present
	 * to be updated
	 */

	@Override
	public String updateTest(int testId, @Validated Test test) {
		// TODO Auto-generated method stub
		Optional<Test> tst = dao.findById(testId);
		if (tst.isPresent()) {
			Test t = tst.get();
			t.setStartTime(test.getStartTime());
			t.setEndTime(test.getEndTime());
			t.setTestDuration(test.getTestDuration());
			t.setTestTitle(test.getTestTitle());
			t.setTestTotalMarks(test.getTestTotalMarks());
			dao.save(t);
			return "Test Updated";
		} else {
			throw new EntityNotFoundException("No test found with test id " + testId);
		}

	}

	/*
	 * View all tests
	 */

	@Override
	public List<Test> viewAll() {
		
		return dao.findAll();
	}

	/*
	 * Find test by id test id passed cannot be negative test must be present
	 */

	@Override
	public Optional<Test> findById(int id) {

		Optional<Test> findById = dao.findById(id);
		if (findById.isPresent()) {
			return findById;
		} else {
			throw new EntityNotFoundException("No test found with test id " + id);
		}

	}

}
