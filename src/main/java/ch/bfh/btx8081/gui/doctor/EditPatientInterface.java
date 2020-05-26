package ch.bfh.btx8081.gui.doctor;

public interface EditPatientInterface {

	public void setPatient();

	public void addListener(EditPatientListener presenter);

	public interface EditPatientListener {

		public void hadleSaveClick();

		public void hadleBackClick();

	}

}
