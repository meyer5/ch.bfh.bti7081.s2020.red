package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class PatientFormLayout extends VerticalLayout {

	/**
	 *  Patient Form to showing patient's information
	 */
	private static final long serialVersionUID = -4993947004340633343L;
	
	private FormLayout blockOne = new FormLayout();
	private FormLayout blockTwo = new FormLayout();
	private FormLayout blockThree = new FormLayout();
	private FormLayout blockFour = new FormLayout();
	
	final private TextField firstName = new TextField(); 
	final private TextField lastName = new TextField(); 
	final private TextField phoneNumber = new TextField();
	final private TextField eMail = new TextField();
	final private TextField addiction = new TextField();
	final private TextField userName = new TextField();
	final private PasswordField password = new PasswordField();
	
	final private TextField doctor = new TextField();
	final private TextArea mainInfo = new TextArea();
	final private TextField consumedSubstance = new TextField();
	final private TextField consumptionMetric = new TextField();
	final private TextField conditionAutomaticAlarm = new TextField();
	
	public PatientFormLayout() {
		
		firstName.setWidth("100%");
		lastName.setWidth("100%");
		phoneNumber.setWidth("100%");
		eMail.setWidth("100%");
		addiction.setWidth("100%");
		userName.setWidth("100%");
		password.setWidth("100%");
		
		doctor.setWidth("100%");
		mainInfo.setWidth("100%");
		consumedSubstance.setWidth("100%");
		consumptionMetric.setWidth("100%");
		conditionAutomaticAlarm.setWidth("100%");
		
		consumedSubstance.setReadOnly(true);
		consumptionMetric.setReadOnly(true);
		addiction.setReadOnly(true);
		
		blockOne.addFormItem(firstName, "First Name");
		blockOne.addFormItem(lastName, "Last name");
		blockOne.addFormItem(phoneNumber, "Phone number");
		blockOne.addFormItem(eMail, "Email");
		blockOne.addFormItem(userName, "Username");	
		blockOne.addFormItem(password, "Password");
		
		blockTwo.addFormItem(doctor, "Doctor");
		
		
		blockThree.addFormItem(addiction, "Addiction");
		blockThree.addFormItem(consumedSubstance, "Consumed substance");
		blockThree.addFormItem(consumptionMetric, "Consumed metric");
		blockThree.addFormItem(conditionAutomaticAlarm, "Condition automatic alarm");
		
		
		blockFour.addFormItem(mainInfo, "Main info").getElement().setAttribute("colspan", "2");
		
		add(blockOne, blockTwo, blockThree, blockFour);
	}

	public TextField getFirstName() {
		return firstName;
	}

	public TextField getLastName() {
		return lastName;
	}
	
	public TextField getPhoneNumber() {
		return phoneNumber;
	}
	
	public TextField getEMail() {
		return eMail;
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
	
	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}
	
	public void setLastName(String lastName) {
		this.lastName.setValue(lastName);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.setValue(phoneNumber);
	}
	
	public void setEMail(String eMail) {
		this.eMail.setValue(eMail);
	}
	
	public void setConsumedSubstance(String consumedSubstance) {
		this.consumedSubstance.setValue(consumedSubstance);
	}

}
