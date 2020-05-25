package ch.bfh.btx8081.gui.doctor;

public interface CreatePatientInterface {

	public void addListener(CreatePatientListener presenter);

	public interface CreatePatientListener {

		public void handleSaveClick();

		public void hadleCancelClick();

	}

}
