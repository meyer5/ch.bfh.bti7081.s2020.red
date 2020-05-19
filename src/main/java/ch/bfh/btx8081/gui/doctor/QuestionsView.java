package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.ironlist.IronList;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

@Route(value = "openQuestions", layout = DoctorMainUI.class)
public class QuestionsView extends VerticalLayout {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -8224404080503821707L;

	public static final String TITLE = "Open Questions";
	  
    private final IronList<QuestionForConsultation> questionsListing;
    private final Button newQuestionButton;
    private PatientService patientService; 
    
    //Diary ---> addQuestion(question)/questionAnswered(question)/getUnansweredQuestions()
    //getDiary() -???? ---> getDiary().getUnansweredQuestions()

	    public QuestionsView() {
	    	questionsListing = new IronList<>();


	    
	        newQuestionButton = new Button("Add New Category", event -> {
	          
	            questionsListing.setItems(
	            		new QuestionForConsultation("Test"), 
	            		new QuestionForConsultation("Test1"),
	            		new QuestionForConsultation("Test2"));
	           
	        });
	        newQuestionButton.setDisableOnClick(true);

	        add(new H2("Edit Questions"), newQuestionButton, questionsListing);
	    }
	    


}
