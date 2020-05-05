package ch.bfh.btx8081.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Entry {

	private LocalDate date;
	private int mood;
	private long consumption;
	private int pressureToConsume;
	private int motivation;
	private ArrayList<Activity> activities =  new ArrayList<Activity>();
	private String comment;
	private QuestionForConsultation questionForConsultation;
	
	public Entry(int mood, long consumption, int pressureToConsume, int motivation, ArrayList<Activity> activities,
			String comment, QuestionForConsultation questionForConsultation) {
		super();
		this.setDate(LocalDate.now());
		this.mood = mood;
		this.consumption = consumption;
		this.pressureToConsume = pressureToConsume;
		this.motivation = motivation;
		this.activities = activities;
		this.comment = comment;
		this.questionForConsultation = questionForConsultation;
	}
	
//	getters & setters

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMood() {
		return mood;
	}

	public void setMood(int mood) {
		this.mood = mood;
	}

	public long getConsumption() {
		return consumption;
	}

	public void setConsumption(long consumption) {
		this.consumption = consumption;
	}

	public int getPressureToConsume() {
		return pressureToConsume;
	}

	public void setPressureToConsume(int pressureToConsume) {
		this.pressureToConsume = pressureToConsume;
	}

	public int getMotivation() {
		return motivation;
	}

	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public QuestionForConsultation getQuestionsForConsultation() {
		return questionForConsultation;
	}

	public void setQuestionsForConsultation(QuestionForConsultation questionsForConsultation) {
		this.questionForConsultation = questionsForConsultation;
	}
	
}
