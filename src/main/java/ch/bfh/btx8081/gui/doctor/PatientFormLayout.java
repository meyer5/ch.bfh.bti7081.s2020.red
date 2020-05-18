package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class PatientFormLayout extends FormLayout {

	private static final long serialVersionUID = -4993947004340633343L;
	
	private FormLayout blockOne = new FormLayout();
	private FormLayout blockTwo = new FormLayout();
	private FormLayout blockThree = new FormLayout();
	
	final private TextField firstName = new TextField(); 
	final private TextField lastName = new TextField(); 
	final private TextField phoneNumber = new TextField();
	final private TextField eMail = new TextField();
	final private TextField addiction = new TextField();
	final private TextField userName = new TextField();
	final private TextField doctor = new TextField();
	final private TextArea mainInfo = new TextArea();
	final private TextField consumedSubstance = new TextField();
	final private TextField consumptionMetric = new TextField();
	final private TextField conditionAutomaticAlarm = new TextField();
	
	
	
	public PatientFormLayout() {
		
		firstName.setWidth("100%");
		lastName.setWidth("100%");
		userName.setWidth("100%");
		phoneNumber.setWidth("100%");
		eMail.setWidth("100%");
		addiction.setWidth("100%");
		mainInfo.setWidth("100%");
		doctor.setWidth("100%");
		consumedSubstance.setWidth("100%");
		consumptionMetric.setWidth("100%");
		conditionAutomaticAlarm.setWidth("100%");
		
		blockOne.addFormItem(firstName, "First Name");
		blockOne.addFormItem(lastName, "Last name");
		blockOne.addFormItem(userName, "Username");
		blockOne.addFormItem(phoneNumber, "Phone number");
		blockOne.addFormItem(eMail, "Email");
		
		blockThree.addFormItem(doctor, "Doctor");
		blockThree.addFormItem(addiction, "Addiction");
		
		blockTwo.addFormItem(consumedSubstance, "Consumed substance");
		blockTwo.addFormItem(consumptionMetric, "Consumed metric");
		blockTwo.addFormItem(conditionAutomaticAlarm, "Condition automatic alarm");
		blockTwo.addFormItem(mainInfo, "Main info");
		
		add(blockOne, blockTwo, blockThree);
	}

	public TextField getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}

	public TextField getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName.setValue(lastName);
	}

	public TextField getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.setValue(phoneNumber);
	}

	public TextField getEMail() {
		return eMail;
	}
	
	public void setEMail(String eMail) {
		this.eMail.setValue(eMail);
	}

	public TextField getAddiction() {
		return addiction;
	}

	public TextField getDoctor() {
		return doctor;
	}
	
	public void setDoctor(String doctorFirstName) {
		this.doctor.setValue(doctorFirstName);
	}

	public TextArea getMainInfo() {
		return mainInfo;
	}

	public TextField getConsumedSubstance() {
		return consumedSubstance;
	}

	public TextField getConsumptionMetric() {
		return consumptionMetric;
	}

	public TextField getConditionAutomaticAlarm() {
		return conditionAutomaticAlarm;
	}

	public TextField getUserName() {
		return userName;
	}

}
