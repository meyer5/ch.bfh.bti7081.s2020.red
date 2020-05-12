package ch.bfh.btx8081.gui.patient;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Interface for the Presenter to make sure every event
 * that generates data is handled 
 * 
 * @author Remo
 *
 */
public interface ViewListenerInterface {
	

	public void nextBtnClicked(String viewName, double motivationNumber);

	public void nextBtnClicked(String viewName, BigDecimal consumption);

	public void nextBtnClicked(String viewName, String input);
	
	public void confirmBtnClicked(String viewName, boolean confirm);
	
	public void startBtnClicked(String viewName, LocalDate entryDate);
		
	
}
