package com.capgemini.otms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Question")

/**
 * 
 * question pojo
 *
 */

public class Question {

	@Id

	private Integer questionId;

	private String questionTitle;

	private int questionAnswer;

	private int questionMarks;

	private int chosenAnswer;
	private int marksScored;
	@OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "qp_id", referencedColumnName = "questionId")
	private List<Answer> questionOptions;

	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public int getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}
	
	public List<Answer> getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(List<Answer> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public Question(Integer questionId, String questionTitle, int questionAnswer, int questionMarks, int chosenAnswer,
			int marksScored, List<Answer> questionOptions) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
		this.questionOptions = questionOptions;
	}

	public Question() {
		super();
	}

}
