package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;

@Route(value = "edit-patient")
public class EditPatientView extends VerticalLayout implements EditPatientInterface {

	/**
	 *  Patient Form to edit patient information
	 */
	
	private static final long serialVersionUID = -4993947004340633343L;
	public static final String TITLE = "Edit patient";
	
	private EditPatientListener presenter;
	
	private FormLayout blockOne = new FormLayout();
	private FormLayout blockTwo = new FormLayout();
	private HorizontalLayout hLayout = new HorizontalLayout();

	private TextField firstName = new TextField();
	private TextField lastName = new TextField();
	private TextField phoneNumber = new TextField();
	private TextField eMail = new TextField();

	private TextArea mainInfo = new TextArea();
	
	public EditPatientView() {
		
		Button saveButton = new Button("Save Patient", event -> {
			presenter.handleSaveClick(firstName.getValue(), lastName.getValue(), phoneNumber.getValue(),
					eMail.getValue(), mainInfo.getValue());
		});
		Button cancelButton = new Button("cancel", event -> {
			presenter.handleCancelClick();
		});

		// blockOne
		firstName.setWidth("100%");
		blockOne.addFormItem(firstName, "First name");

		lastName.setWidth("100%");
		blockOne.addFormItem(lastName, "Last name");

		phoneNumber.setWidth("100%");
		blockOne.addFormItem(phoneNumber, "Phone number");

		eMail.setWidth("100%");
		blockOne.addFormItem(eMail, "Email");

		// block two
		mainInfo.setWidth("100%");
		blockTwo.addFormItem(mainInfo, "Main info");

		// add everything to layout

		hLayout.add(saveButton, cancelButton);

		add(new H2("Create new patient"), blockOne, blockTwo, hLayout);
	}

	@Override
	public void setPatient(Patient patient) {
		firstName.setValue(patient.getFirstName());
		lastName.setValue(patient.getLastName());
		phoneNumber.setValue(patient.getPhoneNumber());
		eMail.setValue(patient.geteMail());
		mainInfo.setValue(patient.getMainInfo());
	}

	@Override
	public void addListener(EditPatientListener presenter) {
		this.presenter = presenter;		
	}

	@Override
	public void fillAllFields() {
		Notification.show("Please fill all the required fields");
	}

}
