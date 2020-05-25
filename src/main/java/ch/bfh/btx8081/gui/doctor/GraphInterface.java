package ch.bfh.btx8081.gui.doctor;

public interface GraphInterface {

	public void setPatient();

	public void addListener(GraphListener presenter);

	public interface GraphListener {

		public void hadleOpenEntryClick();

		public void hadleBackClick();

	}

}
