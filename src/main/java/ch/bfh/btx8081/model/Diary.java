package ch.bfh.btx8081.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany (/*mappedBy = "diary", targetEntity=Activity.class,*/ cascade = CascadeType.ALL)
	@JoinColumn(name = "diary_id")
	private List<Activity> activities = new ArrayList<Activity>();

	@OneToMany (/*mappedBy = "diary",*/ cascade = CascadeType.ALL)
	@JoinColumn(name = "diary_id")
	private List<AvoidanceStrategy> avoidanceStrategies = new ArrayList<AvoidanceStrategy>();
	
	@Transient
	private ArrayList<QuestionForConsultation> unansweredQuestions = new ArrayList<QuestionForConsultation>();

	@OneToMany (/*mappedBy = "diary",*/ cascade = CascadeType.ALL)
	@JoinColumn(name = "diary_id")
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

	protected void newEntry(LocalDate date, long consumption, int pressureToConsume, int motivation, List<Activity> activities,
			String comment, String questionForConsultation) throws ShowAvoidanceStrategyException {
		QuestionForConsultation q = null;
		if (questionForConsultation != null && !questionForConsultation.equals("")) {
			q = new QuestionForConsultation(questionForConsultation);
			this.addQuestion(q);
		}
		this.addEntry(new Entry(date, consumption, pressureToConsume, motivation, activities, comment, q));

		if (pressureToConsume > 6) {
			throw new ShowAvoidanceStrategyException();
		}
//		TODO  show avoidance strategies & check automatic alarm
	}
	
	protected AvoidanceStrategy getRandomAvoidanceStrategy() {
		return this.avoidanceStrategies.get(ThreadLocalRandom.current().nextInt(0, avoidanceStrategies.size()));
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

	private ArrayList<AvoidanceStrategy> defaultAvoidanceStrategies() {
		ArrayList<AvoidanceStrategy> res = new ArrayList<AvoidanceStrategy>();
		res.add(new AvoidanceStrategy("Go for a walk!"));
		res.add(new AvoidanceStrategy("Get a chewing gum!"));
		res.add(new AvoidanceStrategy("Do sport!"));
		res.add(new AvoidanceStrategy("Call a friend!"));
		return res;
	}

	private ArrayList<Activity> defaultActivities() {
		ArrayList<Activity> res = new ArrayList<Activity>();
		res.add(new Activity("Eat healthy food", "1111"));
		res.add(new Activity("Sport", "1111"));
		res.add(new Activity("Work", "1111"));
		res.add(new Activity("Watch TV", "1111"));
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

	protected void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

	public List<AvoidanceStrategy> getAvoidanceStrategies() {
		return avoidanceStrategies;
	}

	protected void setAvoidanceStrategies(ArrayList<AvoidanceStrategy> avoidanceStrategies) {
		this.avoidanceStrategies = avoidanceStrategies;
	}

	public ArrayList<QuestionForConsultation> getUnansweredQuestions() {
		return unansweredQuestions;
	}

	protected void setUnansweredQuestions(ArrayList<QuestionForConsultation> unansweredQuestions) {
		this.unansweredQuestions = unansweredQuestions;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	protected void setEntries(ArrayList<Entry> entries) {
		this.entries = entries;
	}

	public Long getId() {
		return id;
	}
	
	

}
