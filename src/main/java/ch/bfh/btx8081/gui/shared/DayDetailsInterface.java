package ch.bfh.btx8081.gui.shared;

public interface DayDetailsInterface {
	
	public void setPatient();

	public void addListener(DayDetailsListener presenter);

	public interface DayDetailsListener {

		public void hadleBackClick();

	}

}
