package ch.bfh.btx8081.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Patient extends User {
	
	private String addiction = "";
	private String mainInfo = "";
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name="DOCTOR_ID")
	private Doctor doctor = null;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Diary diary = null;

	// public constructor with no arguments for JPA
	public Patient() {
	
	}
	
//	Constructor for persistence
	public Patient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, Diary diary) {
		super(firstName, lastName, phoneNumber, eMail, userName, password);
		this.addiction = addiction;
		this.mainInfo = mainInfo;
		this.doctor = doctor;
		doctor.addPatient(this);
		this.diary = diary;
	}

//	Constructor for new patient in Manager
	protected Patient(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName,
               String password, String addiction, String mainInfo, Doctor doctor, String consumedSubstance, String consumptionMetric) {
		super(id, firstName, lastName, phoneNumber, eMail, userName, password);
		this.addiction = addiction;
		this.mainInfo = mainInfo;
		this.doctor = doctor;
		doctor.addPatient(this);
		this.diary = new Diary(consumedSubstance, consumptionMetric);
	}
	
//	Alarm
	
	protected void sendUrgentCaseAlarm(String message) {
		new UrgentCaseAlarm(this, message);
	}
	
	protected void sendAppontmentAlarm(String message) {
		new AppointmentAlarm(this, message);
	}
	
//	getters & setters

	public String getAddiction() {
		return addiction;
	}

	protected void setAddiction(String addiction) {
		this.addiction = addiction;
	}

	public String getMainInfo() {
		return mainInfo;
	}

	protected void setMainInfo(String mainInfo) {
		this.mainInfo = mainInfo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	protected void setDoctor(Doctor doctor) {
		doctor.removePatient(this);
		this.doctor = doctor;
		doctor.addPatient(this);
	}
	
	public void setDoctorForTest(Doctor doctor) {
		doctor.removePatient(this);
		this.doctor = doctor;
		doctor.addPatient(this);
	}

	public Diary getDiary() {
		return diary;
	}

	protected void setDiary(Diary diary) {
		this.diary = diary;
	}
	
	protected String searchString() {
		return this.getFirstName() + " " + this.getLastName() + " " + this.getFirstName();
	}

}
