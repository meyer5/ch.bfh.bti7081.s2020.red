package ch.bfh.btx8081.gui.patient.newEntry;
/**
 * Marker Interface for Presenter
 * makes sure every view has a method to handle the 
 * "Next" button and 
 * to pass the name of the view
 * 
 * @author Remo
 */
public interface PatientViewInterface {
	
	public void handleNextBtn();
	public String getName();
	
	
}
