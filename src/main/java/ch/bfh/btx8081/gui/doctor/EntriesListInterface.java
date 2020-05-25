package ch.bfh.btx8081.gui.doctor;

public interface EntriesListInterface {

	public void setPatient();

	public void addListener(EntriesListListener presenter);

	public interface EntriesListListener {

		public void hadleOpenEntryClick();

		public void hadleBackClick();

	}

}
