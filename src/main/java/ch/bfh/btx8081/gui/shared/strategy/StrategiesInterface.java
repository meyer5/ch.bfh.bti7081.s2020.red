package ch.bfh.btx8081.gui.shared.strategy;

import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Patient;

public interface StrategiesInterface {
	
	public void setPatient(Patient patient);

	public void addListener(StrategiesListener presenter);

	public interface StrategiesListener {

		public void hadleBackClick();
		
		public void hadleDeleteStrategyClick(AvoidanceStrategy strategy);
		
		public void hadleCreateStrategyClick(String strategy);
		
	}

}
