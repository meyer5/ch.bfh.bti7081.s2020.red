package ch.bfh.btx8081.gui.shared;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;


@Route(value = "questions")
public class QuestionsView extends VerticalLayout implements QuestionsInterface {
	
	private static final long serialVersionUID = -8224404080503821707L;
	public static final String TITLE = "Open Questions";
	
	private ArrayList<QuestionsListener> listeners = new ArrayList<QuestionsListener>();
	  
	private FormLayout blockQuestions;
    private final Button newQuestionButton;
    private final Button saveButton;
    private final Button deleteButton;
    private final Button cancelButton;
    
    //Diary ---> addQuestion(question)/questionAnswered(question)/getUnansweredQuestions()
    //getDiary() -???? ---> getDiary().getUnansweredQuestions()
    //DoctorServer().getCurrentPatient().getDiary().getUnansweredQuestions();

	    public QuestionsView() {
	
	    	newQuestionButton = new Button("Add New Question");
	    	saveButton = new Button("Save");
	    	cancelButton = new Button("Cancel");
	    	deleteButton = new Button("Delete");
	    	
	    	blockQuestions = new FormLayout();
	    	//blockQuestions.setWidth("30%");
	    	
	        newQuestionButton.addClickListener(event -> {
	        	
	        	FlexLayout questionLayout = new FlexLayout();

	        	TextArea question = new TextArea();
	        	Checkbox checkbox = new Checkbox();
	          
	        	questionLayout.add(question, checkbox);
	        	questionLayout.expand(question);
	        	
	        	blockQuestions.add(questionLayout);
	        	  	
	        	//newQuestionButton.setEnabled(true);
	            		
	        });
	        //newQuestionButton.setDisableOnClick(true);
	        
        	HorizontalLayout buttonLayout = new HorizontalLayout();
        	buttonLayout.add(saveButton, deleteButton, cancelButton);

	        add(new H2("Open Questions"), newQuestionButton, blockQuestions, buttonLayout);
	    }

	@Override
	public void setPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(QuestionsListener presenter) {
		listeners.add(presenter);		
	}
	    


}
