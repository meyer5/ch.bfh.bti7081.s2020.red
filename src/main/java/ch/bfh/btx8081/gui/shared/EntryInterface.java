package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.model.Entry;

public interface EntryInterface {
	
	public void setEntry(Entry entry);

	public void addListener(EntryListener presenter);

	public interface EntryListener {

		public void hadleBackClick();

	}

}