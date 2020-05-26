package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.interfaces.DoctorService;

public class GraphPresenter implements GraphInterface.GraphListener {

	private GraphView view;
	private DoctorService service;
	private MainView main;

	public GraphPresenter(GraphView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		this.view.addListener(this);
	}

	@Override
	public void hadleOpenEntryClick() {
		// TODO Auto-generated method stub
		this.main.getClass();
		this.service.getClass();
	}

	@Override
	public void hadleBackClick() {
		// TODO Auto-generated method stub

	}

}
