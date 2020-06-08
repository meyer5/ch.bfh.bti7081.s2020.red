package ch.bfh.btx8081.gui.shared.question;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;


@Route(value = "questions")
public class QuestionsView extends VerticalLayout implements QuestionsInterface {
	
	/**
	 * Idea: shows all open questions of a specific patient and the
	 * possibility to create a new one
	 * 
	 */
	
	private static final long serialVersionUID = -8224404080503821707L;
	public static final String TITLE = "Open Questions";
	
	private QuestionsListener presenter;
	
	private Grid<QuestionForConsultation> questionsList = new Grid<>(QuestionForConsultation.class);
	private FormLayout layout;
    private final Button newQuestionButton;
    private final Button deleteButton;
    private final Button backButton;
	private boolean isOpen = false;
    
	public QuestionsView() {
	
	    questionsList.setSelectionMode(SelectionMode.SINGLE);
	    	
	    newQuestionButton = new Button("Add New Question");
		backButton = new Button("Back", event3 -> {
			presenter.hadleBackClick();
		});
			
	    deleteButton = new Button("Question answered", event4 -> {
			if (questionsList.getSelectedItems().isEmpty()) {
				
			} else {
			presenter.hadleQuestionDoneClick((QuestionForConsultation) questionsList.getSelectedItems().toArray()[0]);
			}
		});
	    	
	    layout = new FormLayout();
	    	
	    newQuestionButton.addClickListener(event -> {
	        	
	    TextArea question = new TextArea();
	    Button saveButton = new Button("Save", event2 -> {
			this.presenter.hadleCreateQuestionClick(question.getValue());
		});
	        	
	    FlexLayout questionLayout = new FlexLayout();
	          
	        questionLayout.add(question, saveButton);
	        questionLayout.expand(question);
	        	
	        if (this.isOpen) {
				layout.removeAll();
				this.isOpen = false;
			} else {
				layout.add(questionLayout);
				this.isOpen = true;
			}
	            		
	    });
	        
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.add(newQuestionButton, deleteButton, backButton);

	    add(new H2("Open Questions"), layout, buttonLayout, questionsList);
	}

	@Override
	public void setPatient(Patient patient) {
		questionsList.setItems(patient.getDiary().getUnansweredQuestions());
	}

	@Override
	public void addListener(QuestionsListener presenter) {
		this.presenter = presenter;
	}
	    


}
