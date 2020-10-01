package com.capgemini.otms.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.otms.entity.Question;
import com.capgemini.otms.entity.Test;
import com.capgemini.otms.entity.User;
import com.capgemini.otms.exception.EntityAlreadyExists;
import com.capgemini.otms.service.CalculateMarks;
import com.capgemini.otms.service.QuestionService;
import com.capgemini.otms.service.TestService;
import com.capgemini.otms.service.UserService;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	QuestionService quesService;

	@Autowired
	UserService userService;
	@Autowired
	TestService testService;
	@Autowired
	CalculateMarks calculate;

	Logger logger = LoggerFactory.getLogger(Controller.class);

	@ExceptionHandler(EntityAlreadyExists.class)
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Validated @RequestBody User usr) {
		try {
			userService.addUser(usr);
			return new ResponseEntity<String>("User Added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/updateUser/{email}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "email") String email,
			@Validated @RequestBody User user) {
		try {
			userService.updateUser(email, user);
			return new ResponseEntity<String>("User updated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/viewUser/{email}")
	public User viewUserByEmail(@PathVariable(value = "email") String email) {
		return userService.findUserByEmail(email);
	}

	@GetMapping("/viewUsers")
	public List<User> viewAllUser() {
		return userService.viewAll();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		String s = userService.login(user.getEmail(), user.getUserPassword());
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}

	@PostMapping("/addQuestion/{id}")
	public ResponseEntity<?> addQuestion(@PathVariable(value = "id") int testId,
			@Validated @RequestBody Question question) {
		try {
			quesService.addQuestion(testId, question);
			return new ResponseEntity<String>("Question Added", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/updateQuestion/{id}")
	public ResponseEntity<?> updateQuestion(@PathVariable(value = "id") int qId,
			@Validated @RequestBody Question question) {
		try {
			quesService.updateQuestion(qId, question);
			return new ResponseEntity<String>("Question updated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable(value = "id") int qId) {
		try {
			quesService.deleteQuestion(qId);
			return new ResponseEntity<String>("Question deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getQuestion/{id}")
	public Question getQuestion(@PathVariable(value = "id") int qId) {
		Optional<Question> question = quesService.findById(qId);
		return question.get();
	}

	@GetMapping("/viewQuestions")
	public List<Question> viewAll() {
		return quesService.viewAll();
	}

	@PostMapping("/addTest")
	public ResponseEntity<?> addTest(@RequestBody Test test) {
		try {
			testService.addTest(test);
			return new ResponseEntity<String>("Test Added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/viewTests")
	public List<Test> viewAllTest() {
		return testService.viewAll();
	}

	@DeleteMapping("/deleteTest/{id}")
	public ResponseEntity<?> deleteTest(@PathVariable(value = "id") int testId) {
		try {
			testService.deleteTest(testId);
			return new ResponseEntity<String>("Test deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/updateTest/{id}")
	public ResponseEntity<?> updateTest(@PathVariable(value = "id") int testId, @RequestBody Test test) {
		try {
			testService.updateTest(testId, test);
			return new ResponseEntity<String>("Question updated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/viewTestById/{id}")
	Optional<Test> findById(@PathVariable(value = "id") int testId) {
		return testService.findById(testId);
	}

	@PostMapping("/getResult")
	public int getResult(@RequestBody Test test) {
		return calculate.getResults(test);
	}

	@PostMapping("/assignTest/{email}/{id}")
	public ResponseEntity<?> assignTest(@PathVariable(value = "email") String email,
			@PathVariable(value = "id") int testId) {
		try {
			userService.assignTest(email, testId);
			return new ResponseEntity<String>("Test Assigned", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
