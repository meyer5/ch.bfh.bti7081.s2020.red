package ch.bfh.btx8081.gui.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.gui.doctor.CreatePatientPresenter;
import ch.bfh.btx8081.gui.doctor.CreatePatientView;
import ch.bfh.btx8081.gui.doctor.EditPatientPresenter;
import ch.bfh.btx8081.gui.doctor.EditPatientView;
import ch.bfh.btx8081.gui.doctor.MainDoctorPresenter;
import ch.bfh.btx8081.gui.doctor.MainDoctorView;
import ch.bfh.btx8081.gui.doctor.PatientInfoPresenter;
import ch.bfh.btx8081.gui.doctor.PatientInfoView;
import ch.bfh.btx8081.gui.doctor.GraphPresenter;
import ch.bfh.btx8081.gui.doctor.GraphView;
import ch.bfh.btx8081.gui.patient.MainPatientPresenter;
import ch.bfh.btx8081.gui.patient.MainPatientView;
import ch.bfh.btx8081.gui.patient.newEntry.EntryViewController;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryPresenter;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

@Route(value = "Main")
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public MainView() {
		this.openLoginView();
	}

	public void openLoginView() {
		removeAll();
		LogInView view = new LogInView();
		new LogInPresenter(view, this);
		this.add(view);
	}

	public void openMainDoctorView(DoctorService service) {
		removeAll();
		MainDoctorView view = new MainDoctorView();
		new MainDoctorPresenter(view, service, this);
		this.add(view);
	}

	public void openMainPatientView(PatientService service) {
		removeAll();
		MainPatientView view = new MainPatientView();
		new MainPatientPresenter(view, service, this);
		this.add(view);
	}

	public void openNewEntryView(PatientService service) {
		removeAll();
		EntryViewController view = new EntryViewController();
//		new NewEntryPresenter(view, service, this);
		this.add(view);
	}

	public void openActivitiesView(Service service) {
		removeAll();
		ActivitiesView view = new ActivitiesView();
		new ActivitiesPresenter(view, service, this);
		this.add(view);
	}

	public void openStrategiesView(Service service) {
		removeAll();
		StrategiesView view = new StrategiesView();
		new StrategiesPresenter(view, service, this);
		this.add(view);
	}

	public void openQuestionsView(Service service) {
		removeAll();
		QuestionsView view = new QuestionsView();
		new QuestionsPresenter(view, service, this);
		this.add(view);
	}

	public void openShowStrategyView(PatientService service) {
//		removeAll();
//		MainPatientView view = new MainPatientView();
//		new MainPatientPresenter(view, service, this);
//		this.add(view);
	}

	public void openAlarmView(PatientService service) {
//		removeAll();
//		MainPatientView view = new MainPatientView();
//		new MainPatientPresenter(view, service, this);
//		this.add(view);
	}

	public void openEntryView(Service service, Entry entry) {
		removeAll();
		EntryView view = new EntryView();
		new EntryPresenter(view, service, this, entry);
		this.add(view);
	}

	public void openEntriesListView(Service service) {
		removeAll();
		EntriesListView view = new EntriesListView();
		new EntriesListPresenter(view, service, this);
		this.add(view);
	}

	public void openPatientInfoView(DoctorService service) throws WrongPasswordException, UserNotFoundException {
		removeAll();
		PatientInfoView view = new PatientInfoView();
		new PatientInfoPresenter(view, service, this);
		this.add(view);
	}

	public void openEditPatientView(DoctorService service) {
		removeAll();
		EditPatientView view = new EditPatientView();
		new EditPatientPresenter(view, service, this);
		this.add(view);
	}

	public void openCreatePatientView(DoctorService service) {
		removeAll();
		CreatePatientView view = new CreatePatientView();
		new CreatePatientPresenter(view, service, this);
		this.add(view);
	}
	
	public void openGraphView(DoctorService service) {
		removeAll();
		GraphView view = new GraphView();
		new GraphPresenter(view, service, this);
		this.add(view);
	}

}
