package ch.bfh.btx8081.gui.shared.entryList;

import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public interface EntriesListInterface {

	public void setPatient(Patient patient);

	public void addListener(EntriesListListener presenter);

	public interface EntriesListListener {

		public void hadleOpenEntryClick(Entry entry);

		public void hadleBackClick();

	}

}
