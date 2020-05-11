package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class PatientFormLayout extends FormLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4993947004340633343L;
	
	final private TextField firstName = new TextField("First Name"); 
	final private TextField lastName = new TextField("Last Name"); 
	final private TextField phoneNumber = new TextField("Phone Number");
	final private TextField eMail = new TextField("E-Mail");
	final private TextField addiction = new TextField("Addiction");
	final private TextField doctor = new TextField("Doctor");
	final private TextArea mainInfo = new TextArea("Patient Main Info");
	final private TextField consumedSubstance = new TextField("Consumed Substance");
	final private TextField consumptionMeric = new TextField("Consumption Meric");
	final private TextField conditionAutomaticAlarm = new TextField("Max Consumption Alarm");
	
	public PatientFormLayout() {
		add(firstName, lastName, phoneNumber, eMail, addiction, doctor, mainInfo, 
				consumedSubstance, consumptionMeric, conditionAutomaticAlarm);
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

	public TextField geteMail() {
		return eMail;
	}

	public TextField getAddiction() {
		return addiction;
	}

	public TextField getDoctor() {
		return doctor;
	}

	public TextArea getMainInfo() {
		return mainInfo;
	}

	public TextField getConsumedSubstance() {
		return consumedSubstance;
	}

	public TextField getConsumptionMeric() {
		return consumptionMeric;
	}

	public TextField getConditionAutomaticAlarm() {
		return conditionAutomaticAlarm;
	}
	
}
