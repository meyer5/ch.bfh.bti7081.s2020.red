package ch.bfh.btx8081.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;

@Entity // (name = "Diary")
//@Table(name = "diary")
public class Diary {

	@Id
	@GeneratedValue
	private Long id;

	private String consumedSubstance = "";
	private String consumptionMeric = "";
	private String conditionAutomaticAlarm = "";

	@OneToMany(mappedBy = "diary", targetEntity=Activity.class)
	private List<Activity> activities = new ArrayList<Activity>();

	@OneToMany(mappedBy = "diary")
	private List<AvoidanceStrategy> avoidanceStrategies = new ArrayList<AvoidanceStrategy>();
	
	@Transient
	private List<QuestionForConsultation> unansweredQuestions = new ArrayList<QuestionForConsultation>();

	@OneToMany(mappedBy = "diary")
	private List<Entry> entries = new ArrayList<Entry>();

//	Constructor for JPA
	public Diary() {

	}

	public Diary(String consumedSubstance, String consumptionMeric, String conditionAutomaticAlarm,
			ArrayList<Activity> activities, ArrayList<AvoidanceStrategy> avoidanceStrategies,
			ArrayList<QuestionForConsultation> unansweredQuestions, ArrayList<Entry> entries) {
		super();
		this.consumedSubstance = consumedSubstance;
		this.consumptionMeric = consumptionMeric;
		this.conditionAutomaticAlarm = conditionAutomaticAlarm;
		this.activities = activities;
		this.avoidanceStrategies = avoidanceStrategies;
		this.unansweredQuestions = unansweredQuestions;
		this.entries = entries;
	}

//	Constructor for new diary in patient constructor

	protected Diary(String consumedSubstance, String consumptionMeric, String conditionAutomaticAlarm) {
		super();
		this.consumptionMeric = consumptionMeric;
		this.consumedSubstance = consumedSubstance;
		this.conditionAutomaticAlarm = conditionAutomaticAlarm;
		this.activities = defaultActivities();
		this.avoidanceStrategies = defaultAvoidanceStrategies();
	}

	protected void newEntry(long consumption, int pressureToConsume, int motivation, ArrayList<Activity> activities,
			String comment, String questionForConsultation) throws ShowAvoidanceStrategyException {
		QuestionForConsultation q = null;
		if (questionForConsultation != null && !questionForConsultation.equals("")) {
			q = new QuestionForConsultation(questionForConsultation);
			this.addQuestion(q);
		}
		this.addEntry(new Entry(consumption, pressureToConsume, motivation, activities, comment, q));

		if (pressureToConsume > 6) {
			throw new ShowAvoidanceStrategyException();
		}
//		TODO  show avoidance strategies & check automatic alarm
	}

//	adder & remover

	protected void addAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy) {
		this.avoidanceStrategies.add(avoidanceStrategy);
	}

	protected void removeAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy) {
		this.avoidanceStrategies.remove(avoidanceStrategy);
	}

	protected void addQuestion(QuestionForConsultation questionForConsultation) {
		this.unansweredQuestions.add(questionForConsultation);
	}

	protected void questionAnswered(QuestionForConsultation questionForConsultation) {
		this.unansweredQuestions.remove(questionForConsultation);
	}

	protected void addActivity(Activity activity) {
		this.activities.add(activity);
	}

	protected void removeActivity(Activity activity) {
		this.activities.remove(activity);
	}

	protected void addEntry(Entry entry) {
		this.entries.add(entry);
	}

	protected void removeEntry(Entry entry) {
		this.entries.remove(entry);
	}

//	Default Diary

	private List<AvoidanceStrategy> defaultAvoidanceStrategies() {
		List<AvoidanceStrategy> res = new ArrayList<AvoidanceStrategy>();
		res.add(new AvoidanceStrategy("1"));
		res.add(new AvoidanceStrategy("2"));
		res.add(new AvoidanceStrategy("3"));
		res.add(new AvoidanceStrategy("4"));
		return res;
	}

	private List<Activity> defaultActivities() {
		List<Activity> res = new ArrayList<Activity>();
		res.add(new Activity("1", "1111"));
		res.add(new Activity("2", "1111"));
		res.add(new Activity("3", "1111"));
		res.add(new Activity("4", "1111"));
		return res;
	}

//	getters & setters

	public String getConsumedSubstance() {
		return consumedSubstance;
	}

	protected void setConsumedSubstance(String consumedSubstance) {
		this.consumedSubstance = consumedSubstance;
	}

	public String getConsumptionMeric() {
		return consumptionMeric;
	}

	protected void setConsumptionMeric(String consumptionMeric) {
		this.consumptionMeric = consumptionMeric;
	}

	public String getConditionAutomaticAlarm() {
		return conditionAutomaticAlarm;
	}

	protected void setConditionAutomaticAlarm(String conditionAutomaticAlarm) {
		this.conditionAutomaticAlarm = conditionAutomaticAlarm;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	protected void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<AvoidanceStrategy> getAvoidanceStrategies() {
		return avoidanceStrategies;
	}

	protected void setAvoidanceStrategies(List<AvoidanceStrategy> avoidanceStrategies) {
		this.avoidanceStrategies = avoidanceStrategies;
	}

	public List<QuestionForConsultation> getUnansweredQuestions() {
		return unansweredQuestions;
	}

	protected void setUnansweredQuestions(List<QuestionForConsultation> unansweredQuestions) {
		this.unansweredQuestions = unansweredQuestions;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	protected void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

}
