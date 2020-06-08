package ch.bfh.btx8081.gui.patient.newEntry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.model.Activity;

/**
 * This class collects the data entered in the different entry views by the
 * patient
 * 
 * @author Remo
 */

public class NewEntryPresenter implements NewEntryInterface.NewEntryListener {

	private NewEntryInterface currentView;
	private MainView main;
	private PatientService service;

	private LocalDate date;
	private long consumption;
	private int pressure;
	private int motivation;
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private String comment;
	private String question;

	public NewEntryPresenter(PatientService service, MainView main) {
		this.main = main;
		this.service = service;
	}

	@Override
	public void handleConfirmDate(LocalDate date) {
		this.date = date;
		main.openNewEntryConsumptionView(this);
	}

	@Override
	public void handleConfirmConsumption(long consumption) {
		this.consumption = consumption;
		main.openNewEntryPressureView(this);
	}

	@Override
	public void handleConfirmPressure(int pressure) {
		this.pressure = pressure;
		main.openNewEntryMotivationView(this);
	}

	@Override
	public void handleConfirmMotivation(int motivation) {
		this.motivation = motivation;
		main.openNewEntryActivityView(this);
	}

	@Override
	public void handleConfirmActivities(ArrayList<Activity> activities) {
		this.activities = activities;
		main.openNewEntryCommentView(this);
	}

	@Override
	public void handleConfirmComment(String comment) {
		this.comment = comment;
		main.openNewEntryQuestionView(this);
	}
	
	@Override
	public void handleConfirmQuestion(String question) {
		this.question = question;
		main.openNewEntryConfirmView(this);
	}

	@Override
	public void handleConfirmEntry() {
		try {
			this.service.newEntry(date, consumption, pressure, motivation, activities, comment, question);
		} catch (ShowAvoidanceStrategyException e) {
			this.currentView.showAvoidanceSrategy(this.service.getRandomAvoidanceStrategy().getStrategy());
		}
		main.openMainPatientView(this.service);
	}

	@Override
	public void setView(NewEntryInterface view) {
		this.currentView = view;
		view.setListener(this);
	}

	@Override
	public List<Activity> getActivities() {
		return service.getPatient().getDiary().getActivities();
	}

}
