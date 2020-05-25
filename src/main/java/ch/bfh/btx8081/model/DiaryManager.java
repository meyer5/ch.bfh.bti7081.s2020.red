package ch.bfh.btx8081.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.interfaces.DoctorInterface;
import ch.bfh.btx8081.interfaces.PatientInterface;
import ch.bfh.btx8081.persistence.PersistenceManager;

public class DiaryManager implements PatientInterface, DoctorInterface {

	private static DiaryManager instance = null;
	private long id = 1000;

	private PersistenceManager persistenceManager;
//	Solution until persistence is implemented
//	private List<Doctor> doctors = new ArrayList<Doctor>();

	private List<Doctor> doctors;

//	Singleton
	private DiaryManager() {
		this.id = 1000;
		this.persistenceManager = new PersistenceManager();
		this.setUp();
		this.doctors = getDoctorsFromDb();
		testDB();
	}

	private void testDB() {
		for (Doctor d : doctors) {
			System.out.println(d.getUserName());
		}

	}

	public static DiaryManager getInstance() {
		if (instance == null) {
			instance = new DiaryManager();
		}
		return instance;
	}

	// get data from database
	private List<Doctor> getDoctorsFromDb() {
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
			if (a.toString().contains(searchQuery)) {
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
	}

	@Override
	public List<Entry> getDiaryEntries(Patient patient) {
		return patient.getDiary().getEntries();
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
			String consumptionMetric, String conditionAutomaticAlarm) throws UsernameIsAlreadyTakenException {
		try {
			this.searchUserByUsername(userName);
			throw new UsernameIsAlreadyTakenException();
		} catch (UserNotFoundException e) {
			new Patient(this.nextID(), firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo,
					doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
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
	public void setConditionAutomaticAlarm(Patient patient, String conditionAutomaticAlarm) {
		patient.getDiary().setConditionAutomaticAlarm(conditionAutomaticAlarm);
	}

	@Override
	public void newEntry(Patient patient, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, String questionForConsultation)
			throws ShowAvoidanceStrategyException {
		patient.getDiary().newEntry(consumption, pressureToConsume, motivation, activities, comment,
				questionForConsultation);
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

//	adder & remover

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
	}

	public void removeDoctor(Doctor doctor) {
		this.doctors.remove(doctor);
	}

//	getters & setters

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

//	Testing
	private void setUp() {
//		this.newDoctor(firstName, lastName, phoneNumber, eMail, userName, password);
		try {
			this.newDoctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
			System.out.println("hmeier - created");
			this.newDoctor("Heidi", "Müller", "0700000000", "heidi.mueller@mail.ch", "hmueller", "asdf");
			System.out.println("hmueller - created");
//		this.newPatient(firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
			this.newPatient("Remo", "Meyer", "0700000001", "hans.meier@mail.ch", "remo", "123", "Hero", "Kommentar",
					(Doctor) this.searchUserByUsername("hmeier"), "Hero", "mg", "Nicht implementiert");
			System.out.println("remo - created");
			this.newPatient("Kaurisanker", "Kirupananthan", "0700000002", "hans.meier@mail.ch", "kausi", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("hmeier"), "Hero", "mg", "Nicht implementiert");
			System.out.println("kausi - created");
			this.newPatient("Natalya", "Dénervaud", "0700000003", "hans.meier@mail.ch", "natalya", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("hmeier"), "Hero", "mg", "Nicht implementiert");
			System.out.println("natalya - created");
			this.newPatient("Dmytriy", "Pelts", "0700000004", "hans.meier@mail.ch", "dmytriy", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("hmueller"), "Hero", "mg", "Nicht implementiert");
			System.out.println("dmytriy - created");
			this.newPatient("Julian", "Rodriguez", "0700000005", "hans.meier@mail.ch", "julian", "123", "Hero",
					"Kommentar", (Doctor) this.searchUserByUsername("hmueller"), "Hero", "mg", "Nicht implementiert");
			System.out.println("julian - created");
		} catch (UsernameIsAlreadyTakenException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
