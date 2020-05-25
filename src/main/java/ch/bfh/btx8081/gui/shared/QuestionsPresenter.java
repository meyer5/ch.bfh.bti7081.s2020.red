package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.interfaces.Service;

public class QuestionsPresenter implements QuestionsInterface.QuestionsListener {

	private QuestionsView view;
	private Service service;
	private MainView main;
	
	public QuestionsPresenter(QuestionsView view, Service service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void hadleBackClick() {
		// TODO Auto-generated method stub
		
	}
	
}
