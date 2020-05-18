package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.interfaces.ServiceManager;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Patient;

@Route(value = "PatientInfo", layout = DoctorMainUI.class)
public class PatientInfoPresenter extends HorizontalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3407757504015724766L;

	public static final String TITLE = "Patient Info";
	
	private final VerticalLayout layout;
	private DoctorService service = null;
	
	public PatientInfoPresenter() throws WrongPasswordException, UserNotFoundException {
		
		final PatientFormLayout patientShowLayout = new PatientFormLayout();
        layout = new VerticalLayout();
                      
        this.service = (DoctorService) ServiceManager.getService("hmeier", "123");
        //service.selectPatient((Patient) DiaryManager.getInstance().searchUserByUsername("remo"));
        
        patientShowLayout.setFirstName("Peter");
        patientShowLayout.setLastName("Pops");
        patientShowLayout.setPhoneNumber("0782344534");
        patientShowLayout.setEMail("peter.pops@gmail.com");
        patientShowLayout.setConsumedSubstance("alcohol");
        ((PatientFormLayout) patientShowLayout).setDoctor(service.getDoctor().getFirstName());       
 
        
        // Build a footer, add Save and Cancel buttons
        final HorizontalLayout footer = new HorizontalLayout();

        // Browser page is updated
        Button buttonCancel = new Button("Cancel"); 
        buttonCancel.addClickListener(event -> UI.getCurrent().getPage().reload());
        
        // Changed fields will be saved and browser page is updated
        Button buttonEdit = new Button("Edit", event -> {
            try {
            	service.changeMainInfo(patientShowLayout.getMainInfo().getValue());
            	
            	service.changeContactInfo(patientShowLayout.getFirstName().getValue(), 
            			                  patientShowLayout.getLastName().getValue(), 
            			                  patientShowLayout.getPhoneNumber().getValue(), 
            			                  patientShowLayout.getEMail().getValue());
            	
            	service.setConditionAutomaticAlarm(patientShowLayout.getConditionAutomaticAlarm().getValue());
            	
            	System.out.println(patientShowLayout.getMainInfo().getValue());
            	System.out.println(patientShowLayout.getFirstName().getValue());
            	
            	UI.getCurrent().getPage().reload();
            	
            } catch (final Exception e) {
                e.printStackTrace();
            }
        });

        footer.getThemeList().set("spacing", true);
        footer.add(buttonEdit, buttonCancel);
        layout.add(patientShowLayout, footer);
        add(layout);
        expand(layout);
		
	}

}
