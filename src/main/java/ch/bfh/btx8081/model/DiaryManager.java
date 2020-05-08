package ch.bfh.btx8081.model;

import java.util.ArrayList;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.interfaces.DoctorInterface;
import ch.bfh.btx8081.interfaces.PatientInterface;

public class DiaryManager implements PatientInterface, DoctorInterface {

	private static DiaryManager instance = null;
	private long id = 1000;

//	Solution until persistence is implemented
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();

//	Singleton
	private DiaryManager() {
		this.id = 1000;
	}

	public static DiaryManager getInstance() {
		if (instance == null) {
			instance = new DiaryManager();
		}
		return instance;
	}

//	Search

	public User searchUserByUsername(String userName) throws UserNotFoundException {
		for (Doctor a : doctors) {
			if (a.getUserName().equals(userName)) {
				return a;
			}
			for (Patient e : a.getPatients()) {
				if (e.getUserName().equals(userName)) {
					return e;
				}
			}
		}
		throw new UserNotFoundException();
	}

	@Override
	public ArrayList<Patient> searchPatientOfDoctor(Doctor doctor, String SearchQuery) throws PatientNotFoundException {
		ArrayList<Patient> res = new ArrayList<Patient>();
		for (Patient a : doctor.getPatients()) {
			if (a.toString().contains(SearchQuery)) {
				res.add(a);
			}
		}
		if (res.size() < 1) {
			throw new PatientNotFoundException();
		}
		return res;
	}

//	get lists

	@Override
	public ArrayList<Patient> getAllPatientsOfDoctor(Doctor doctor) {
		return doctor.getPatients();
	}

	@Override
	public ArrayList<Entry> getDiaryEntries(Patient patient) {
		return patient.getDiary().getEntries();
	}

//	User management

	@Override
	public void authenticate(String userName, String password) throws WrongPasswordException, UserNotFoundException {
		this.searchUserByUsername(userName).authenticate(userName, password);
	}

	@Override
	public void newDoctor(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password) throws UsernameIsAlreadyTakenException {
		try {
			this.searchUserByUsername(userName);
		} catch (UserNotFoundException e) {
			this.addDoctor(new Doctor(this.nextID(), firstName, lastName, phoneNumber, eMail, userName, password));
		}
		throw new UsernameIsAlreadyTakenException();

	}

	@Override
	public void newPatient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, String consumedSubstance,
			String consumptionMetric, String conditionAutomaticAlarm) throws UsernameIsAlreadyTakenException {
		try {
			this.searchUserByUsername(userName);
		} catch (UserNotFoundException e) {
			new Patient(this.nextID(), firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo,
					doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
		}
		throw new UsernameIsAlreadyTakenException();

	}

//	Patient management

	@Override
	public void changeContactInfo(Patient patient, String firstName, String lastName, String phoneNumber,
			String eMail) {
		patient.changeContactInfo(firstName, lastName, phoneNumber, eMail);
	}

	@Override
	public void changeMainInfo(Patient patient, String newMainInfo) {
		patient.setMainInfo(newMainInfo);
	}

	@Override
	public void createNewActivity(Patient patient, String activity, String iconID) {
		patient.getDiary().addActivity(new Activity(activity, iconID));
	}

	@Override
	public void removeNewActivity(Patient patient, Activity activity) {
		patient.getDiary().removeActivity(activity);
	}

	@Override
	public void createNewAvoidanceStrategy(Patient patient, String avoidanceStrategy) {
		patient.getDiary().addAvoidanceStrategy(new AvoidanceStrategy(avoidanceStrategy));
	}

	@Override
	public void removeNewAvoidanceStrategy(Patient patient, AvoidanceStrategy avoidanceStrategy) {
		patient.getDiary().removeAvoidanceStrategy(avoidanceStrategy);
	}

	@Override
	public void setConditionAutomaticAlarm(Patient patient, String conditionAutomaticAlarm) {
		patient.getDiary().setConditionAutomaticAlarm(conditionAutomaticAlarm);
	}

	@Override
	public void newEntry(Patient patient, int mood, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, String questionForConsultation)
			throws ShowAvoidanceStrategyException {
		patient.getDiary().newEntry(mood, consumption, pressureToConsume, motivation, activities, comment,
				questionForConsultation);
	}

//	ID management

	private long nextID() {
		return this.id++;
	}

//	persistence

	public void save(Doctor doctor) {
//		TODO
	}

	public void save(Patient patient) {
//		TODO
	}

//	adder & remover

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
	}

	public void removeDoctor(Doctor doctor) {
		this.doctors.remove(doctor);
	}

//	getters & setters

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

}
