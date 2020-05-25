package ch.bfh.btx8081.gui.doctor;

public interface MainDoctorInterface {
	
	public void setDoctor();

	public void addListener(MainDoctorListener presenter);

	public interface MainDoctorListener {

		public void hadleCreateNewPatientClick();

		public void hadleOpenPatientClick();

	}

}
