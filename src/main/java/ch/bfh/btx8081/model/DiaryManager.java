package ch.bfh.btx8081.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.exceptions.AutomaticAlarmException;
import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.interfaces.DoctorInterface;
import ch.bfh.btx8081.interfaces.PatientInterface;
import ch.bfh.btx8081.persistence.PersistenceManager;




/**
 * Class that manages model data in and output.
 *
 */

public class DiaryManager implements PatientInterface, DoctorInterface {

	private static DiaryManager instance = null;
	private long id = 1000;

	private PersistenceManager persistenceManager = null;
//	Solution until persistence is implemented

	private List<Doctor> doctors = new ArrayList<Doctor>();



//	Singleton
	private DiaryManager() {
		this.id = 1000;
		this.persistenceManager = new PersistenceManager();
//		this.setUp();
		this.doctors = getDoctorsFromDb();

	}

	public static DiaryManager getInstance() {
		if (instance == null) {
			instance = new DiaryManager();
		}
		return instance;
	}

	// get data from database
	public List<Doctor> getDoctorsFromDb() {
		return this.doctors = persistenceManager.getDoctors();
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
	public ArrayList<Patient> searchPatientOfDoctor(Doctor doctor, String searchQuery) throws PatientNotFoundException {
		ArrayList<Patient> res = new ArrayList<Patient>();
		for (Patient a : doctor.getPatients()) {
			if (a.searchString().toLowerCase().contains(searchQuery.toLowerCase())) {
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
	public List<Patient> getAllPatientsOfDoctor(Doctor doctor) {
		return doctor.getPatients();
//		return persistenceManager.getPatientsOfDoctor(doctor);
	}

	@Override
	public List<Entry> getDiaryEntries(Patient patient) {
		return patient.getDiary().getEntries();
//		return persistenceManager.getDiaryEntries(patient);
	}

//	User management

	public User authenticate(String userName, String password) throws WrongPasswordException, UserNotFoundException {
		return this.searchUserByUsername(userName).authenticate(userName, password);
	}

	@Override
	public void newDoctor(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password) throws UsernameIsAlreadyTakenException {
		try {
			this.searchUserByUsername(userName);
			throw new UsernameIsAlreadyTakenException();
		} catch (UserNotFoundException e) {
			this.addDoctor(new Doctor(this.nextID(), firstName, lastName, phoneNumber, eMail, userName, password));
		}

	}

	@Override
	public void newPatient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, String consumedSubstance,
			String consumptionMetric) throws UsernameIsAlreadyTakenException {
		try {
			this.searchUserByUsername(userName);
			throw new UsernameIsAlreadyTakenException();
		} catch (UserNotFoundException e) {
			new Patient(this.nextID(), firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo,
					doctor, consumedSubstance, consumptionMetric);
		}
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
	public void createNewQuestionForConsultation(Patient patient, String questionForConsultation) {
		patient.getDiary().addQuestion(new QuestionForConsultation(questionForConsultation));

	}

	@Override
	public void removeNewQuestionForConsultation(Patient patient, QuestionForConsultation questionForConsultation) {
		patient.getDiary().questionAnswered(questionForConsultation);
	}

	@Override
	public void setConditionAutomaticAlarm(Patient patient, Condition conditionAutomaticAlarm) {
		patient.getDiary().setConditionAutomaticAlarm(conditionAutomaticAlarm);
	}
	
	@Override
	public void removeConditionAutomaticAlarm(Patient patient) {
		patient.getDiary().removeConditionAutomaticAlarm(patient);
	}
	
	@Override
	public void sendUrgentCaseAlarm(Patient patient, String message) {
		patient.sendUrgentCaseAlarm(message);
	}

	@Override
	public void sendAppontmentAlarm(Patient patient, String message) {
		patient.sendAppontmentAlarm(message);
	}
	
	@Override
	public void removeAlarm(Doctor doctor, Alarm alarm) {
		doctor.removeAlarm(alarm);
	}

	@Override
	public void newEntry(LocalDate date, Patient patient, long consumption, int pressureToConsume, int motivation,
			List<Activity> activities, String comment, String questionForConsultation)
			throws ShowAvoidanceStrategyException {
		try {
			patient.getDiary().newEntry(date, consumption, pressureToConsume, motivation, activities, comment,
					questionForConsultation);
		} catch (AutomaticAlarmException e) {
			new AutomaticAlarm(patient);
		}
	}

//	ID management

	private long nextID() {
		return this.id++;
	}

//	persistence

	public void save(Doctor doctor) {
		persistenceManager.saveDoctor(doctor);
	}

	public void save(Patient patient) {
		persistenceManager.savePatient(patient);
	}
	
	public void saveEntry(Entry entry) {
		persistenceManager.saveEntry(entry);
	}

//	adder & remover

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
		save(doctor);
	}

	public void removeDoctor(Doctor doctor) {
		this.doctors.remove(doctor);
		persistenceManager.removeDoctorFromDb(doctor);
	}

//	getters & setters

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

//	Testing
	public void setUp() {
//		this.newDoctor(firstName, lastName, phoneNumber, eMail, userName, password);
		try {
			this.newDoctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "doctor1", "123");
			System.out.println("hmeier - created");
			this.newDoctor("Heidi", "Müller", "0700000000", "heidi.mueller@mail.ch", "doctor2", "123");
			System.out.println("hmueller - created");
//		this.newPatient(firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
			this.newPatient("Remo", "Meyer", "0700000001", "hans.meier@mail.ch", "remo", "123", "Hero", "Kommentar",
					(Doctor) this.searchUserByUsername("doctor1"), "Hero", "mg");
			System.out.println("remo - created");
			this.newPatient("Kaurisanker", "Kirupananthan", "0700000002", "hans.meier@mail.ch", "kausi", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("doctor1"), "Hero", "mg");
			System.out.println("kausi - created");
			this.newPatient("Natalya", "Dénervaud", "0700000003", "hans.meier@mail.ch", "natalya", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("doctor1"), "Hero", "mg");
			System.out.println("natalya - created");
			this.newPatient("Dmytriy", "Pelts", "0700000004", "hans.meier@mail.ch", "dmytriy", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("doctor2"), "Hero", "mg");
			System.out.println("dmytriy - created");
			this.newPatient("Julian", "Rodriguez", "0700000005", "hans.meier@mail.ch", "julian", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("doctor2"), "Hero", "mg");
			System.out.println("julian - created");

			Patient julian = (Patient) this.searchUserByUsername("julian");
			this.newEntry(LocalDate.of(2020, 04, 26), julian, Integer.toUnsignedLong(23), 3, 3,
					julian.getDiary().getActivities(), "Test1", "Question1");
			this.newEntry(LocalDate.of(2020, 04, 25), julian, Integer.toUnsignedLong(23), 3, 3,
					julian.getDiary().getActivities(), "Test2", "Question2");
			this.newEntry(LocalDate.of(2020, 04, 24), julian, Integer.toUnsignedLong(23), 3, 3,
					julian.getDiary().getActivities(), "Test3", "Question3");

//			persist set up in database
			List<Doctor> docs = this.getDoctors();
			List<Patient> pats = null;
			for (Doctor d : docs) {
				save(d);
				pats = d.getPatients();
				for (Patient p : pats) {
					save(p);
				}
			}

		} catch (UsernameIsAlreadyTakenException | UserNotFoundException | ShowAvoidanceStrategyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public AvoidanceStrategy getRandomAvoidanceStrategy(Patient patient) {
		return patient.getDiary().getRandomAvoidanceStrategy();
	}

}
