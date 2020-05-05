package ch.bfh.btx8081.model;

public class Patient extends User {
	
	private String addiction;
	private String mainInfo;
	private Doctor doctor;
	private Diary diary;
	
//	Constructor for persistence
	public Patient(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, Diary diary) {
		super(id, firstName, lastName, phoneNumber, eMail, userName, password);
		this.addiction = addiction;
		this.mainInfo = mainInfo;
		this.doctor = doctor;
		doctor.addPatient(this);
		this.diary = diary;
	}

//	Constructor for new patient in Manager
	public Patient(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, String consumedSubstance, String consumptionMetric, String conditionAutomaticAlarm) {
		super(id, firstName, lastName, phoneNumber, eMail, userName, password);
		this.addiction = addiction;
		this.mainInfo = mainInfo;
		this.doctor = doctor;
		this.diary = new Diary(consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
	}
	
	
	
//	Alarm
	
	public void sendEmergenceAlarm() {
//		TODO
	}
	
	public void sendUrgentCaseAlarm() {
//		TODO
	}
	
	public void sendAppontmentAlarm() {
//		TODO
	}
	
//	getters & setters

	public String getAddiction() {
		return addiction;
	}

	public void setAddiction(String addiction) {
		this.addiction = addiction;
	}

	public String getMainInfo() {
		return mainInfo;
	}

	public void setMainInfo(String mainInfo) {
		this.mainInfo = mainInfo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		doctor.removePatient(this);
		this.doctor = doctor;
		doctor.addPatient(this);
	}

	public Diary getDiary() {
		return diary;
	}

	public void setDiary(Diary diary) {
		this.diary = diary;
	}

}
