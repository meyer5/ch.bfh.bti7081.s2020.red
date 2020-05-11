package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.model.*;


@Route(value = "Patient_Info", layout = DoctorMainUI.class)
public class PatientInformation extends HorizontalLayout implements HasSize{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3371889836539622243L;
	public static final String TITLE = "Patient Info";
	
	private final HorizontalLayout layout;

	public PatientInformation() {
		
		setPadding(true);
		setSpacing(true);
		setSizeFull();
		
		final PatientFormLayout patientShowLayout = new PatientFormLayout();
		Binder<Patient> binderPatient = new Binder<>(Patient.class);
		Binder<Doctor> binderDoctor = new Binder<>(Doctor.class);
		Binder<Diary> binderDiary = new Binder<>(Diary.class);
		
		final Patient patient = createPatient();
		
        // Manual binding needed due to name inconsistency between UI and Bean, and lacking of @PropertyId annotation
        binderPatient.forField(patientShowLayout.getFirstName()).bind(Patient::getFirstName, null);
        binderPatient.forField(patientShowLayout.getLastName()).bind(Patient::getLastName, null);
        binderPatient.forField(patientShowLayout.getPhoneNumber()).bind(Patient::getPhoneNumber, null);
        binderPatient.forField(patientShowLayout.getAddiction()).bind(Patient::getAddiction, null);
        binderPatient.forField(patientShowLayout.getMainInfo()).bind(Patient::getMainInfo, null);
        
        binderDiary.forField(patientShowLayout.getConsumedSubstance()).bind(Diary::getConsumedSubstance, null);
        binderDiary.forField(patientShowLayout.getConsumptionMeric()).bind(Diary::getConsumptionMeric, null);
        binderDiary.forField(patientShowLayout.getConditionAutomaticAlarm()).bind(Diary::getConditionAutomaticAlarm, null);
        
        // Reads the initial data from the Patient
        binderPatient.readBean(patient);
        
        layout = new HorizontalLayout();
        
        layout.add(patientShowLayout);
        
        add(layout);
        expand(layout);
	}
	
	private static Patient createPatient() {
		final Patient patient = new Patient( 12345L,"Patrick", "lastName", "phoneNumber", "eMail", "userName", "password", 
				"addiction", "mainInfo", null, "consumedSubstance", "consumptionMetric", "conditionAutomaticAlarm");
		return patient;
	}

}
