package ch.bfh.btx8081.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
//@Table(name = "entry")
public class Entry {
	
	@Id
    @GeneratedValue 	//artificial ID
    private Long id;
	
	private LocalDate date = null;
	private long consumption = 0;
	private int pressureToConsume = 0;
	private int motivation = 0;
	
	@ManyToOne
	@JoinColumn(name = "diary_id")
	private Diary diary;
	
	@Transient		//
	private List<Activity> activities =  new ArrayList<Activity>();
	
	private String comment = "";
	
	@OneToOne(mappedBy = "entry")
	private QuestionForConsultation questionForConsultation = null;
	
	
	// public constructor with no arguments for JPA
		public Entry() {
		
		}
	

//	Constructor for diary

	protected Entry(long consumption, int pressureToConsume, int motivation, ArrayList<Activity> activities,
			String comment, QuestionForConsultation questionForConsultation) {
		super();
		this.setDate(LocalDate.now());
		this.consumption = consumption;
		this.pressureToConsume = pressureToConsume;
		this.motivation = motivation;
		this.activities = activities;
		this.comment = comment;
		this.questionForConsultation = questionForConsultation;
	}
	
//	Constructor for persistence
	
	public Entry(LocalDate date, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, QuestionForConsultation questionForConsultation) {
		super();
		this.date = date;
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

	protected void setDate(LocalDate date) {
		this.date = date;
	}

	public long getConsumption() {
		return consumption;
	}

	protected void setConsumption(long consumption) {
		this.consumption = consumption;
	}

	public int getPressureToConsume() {
		return pressureToConsume;
	}

	protected void setPressureToConsume(int pressureToConsume) {
		this.pressureToConsume = pressureToConsume;
	}

	public int getMotivation() {
		return motivation;
	}

	protected void setMotivation(int motivation) {
		this.motivation = motivation;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	protected void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

	public String getComment() {
		return comment;
	}

	protected void setComment(String comment) {
		this.comment = comment;
	}

	public QuestionForConsultation getQuestionsForConsultation() {
		return questionForConsultation;
	}

	protected void setQuestionsForConsultation(QuestionForConsultation questionsForConsultation) {
		this.questionForConsultation = questionsForConsultation;
	}
	
}
