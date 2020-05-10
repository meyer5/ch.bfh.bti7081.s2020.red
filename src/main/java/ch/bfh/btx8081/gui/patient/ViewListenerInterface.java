package ch.bfh.btx8081.gui.patient;

import java.math.BigDecimal;
import java.util.List;

public interface ViewListenerInterface {
	
		
	public void nextBtnClicked(String viewName, double motivationNumber);

	public void nextBtnClicked(String viewName, BigDecimal consumption);

	public void nextBtnClicked(String viewName, String input);
	
	
}
