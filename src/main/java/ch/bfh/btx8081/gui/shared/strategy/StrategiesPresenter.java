package ch.bfh.btx8081.gui.shared.strategy;

import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.AvoidanceStrategy;

public class StrategiesPresenter implements StrategiesInterface.StrategiesListener {
	
	private StrategiesView view;
	private Service service;
	private MainView main;
	
	public StrategiesPresenter(StrategiesView view, Service service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
		view.setPatient(service.getPatient());
	}

	@Override
	public void hadleBackClick() {
		if (service instanceof DoctorService) {
			main.openPatientInfoView((DoctorService) service);
		} else if (service instanceof PatientService) {
			main.openMainPatientView((PatientService) service);
		}
	}

	@Override
	public void hadleDeleteStrategyClick(AvoidanceStrategy avoidanceStrategy) {
		service.removeNewAvoidanceStrategy(avoidanceStrategy);
		view.setPatient(service.getPatient());
	}

	@Override
	public void hadleCreateStrategyClick(String avoidanceStrategy) {
		service.createNewAvoidanceStrategy(avoidanceStrategy);;
		view.setPatient(service.getPatient());
	}


}
