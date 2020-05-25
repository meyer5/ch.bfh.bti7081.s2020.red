package ch.bfh.btx8081.gui.shared;

public interface QuestionsInterface {
	
	public void setPatient();

	public void addListener(QuestionsListener presenter);

	public interface QuestionsListener {

		public void hadleBackClick();
		
	}

}
