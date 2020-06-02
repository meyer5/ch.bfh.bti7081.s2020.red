package ch.bfh.btx8081.gui.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.gui.doctor.CreatePatientPresenter;
import ch.bfh.btx8081.gui.doctor.CreatePatientView;
import ch.bfh.btx8081.gui.doctor.EditPatientPresenter;
import ch.bfh.btx8081.gui.doctor.EditPatientView;
import ch.bfh.btx8081.gui.doctor.MainDoctorPresenter;
import ch.bfh.btx8081.gui.doctor.MainDoctorView;
import ch.bfh.btx8081.gui.doctor.MenuView;
import ch.bfh.btx8081.gui.doctor.PatientInfoPresenter;
import ch.bfh.btx8081.gui.doctor.PatientInfoView;
import ch.bfh.btx8081.gui.patient.MainPatientPresenter;
import ch.bfh.btx8081.gui.patient.MainPatientView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryActivityView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryCommentView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryConfirmView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryConsumptionView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryMotivationView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryPresenter;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryPressureView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryQuestionView;
import ch.bfh.btx8081.gui.patient.newEntry.NewEntryStartView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.Entry;

@Route(value = "Main")
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private MenuView menu;
	
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
		menu = new MenuView(this, service);
		MainPatientView view = new MainPatientView();
		new MainPatientPresenter(view, service, this);
		this.add(menu, view);
	}

	public void openNewEntryView(PatientService service) {
		openNewEntryDateView(service);
	}

	public void openActivitiesView(Service service) {
		removeAll();
		menu = new MenuView(this, service);
		ActivitiesView view = new ActivitiesView();
		new ActivitiesPresenter(view, service, this);
		this.add(menu, view);
	}

	public void openStrategiesView(Service service) {
		removeAll();
		menu = new MenuView(this, service);
		StrategiesView view = new StrategiesView();
		new StrategiesPresenter(view, service, this);
		this.add(menu, view);
	}

	public void openQuestionsView(Service service) {
		removeAll();
		menu = new MenuView(this, service);
		QuestionsView view = new QuestionsView();
		new QuestionsPresenter(view, service, this);
		this.add(menu, view);
	}

	public void openAlarmView(PatientService service) {
//		removeAll();
//		MainPatientView view = new MainPatientView();
//		new MainPatientPresenter(view, service, this);
//		this.add(view);
	}

	public void openEntryView(Service service, Entry entry) {
		removeAll();
		menu = new MenuView(this, service);
		EntryView view = new EntryView();
		new EntryPresenter(view, service, this, entry);
		this.add(menu, view);
	}

	public void openEntriesListView(Service service) {
		removeAll();
		menu = new MenuView(this, service);
		EntriesListView view = new EntriesListView();
		new EntriesListPresenter(view, service, this);
		this.add(menu, view);
	}

	public void openPatientInfoView(DoctorService service) {
		removeAll();
		menu = new MenuView(this, service);
		PatientInfoView view;
		view = new PatientInfoView();
		new PatientInfoPresenter(view, service, this);
		this.add(menu, view);
	}

	public void openEditPatientView(DoctorService service) {
		removeAll();
		menu = new MenuView(this, service);
		EditPatientView view = new EditPatientView();
		new EditPatientPresenter(view, service, this);
		this.add(menu, view);
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
	
//	New Entry Views
	
	public void openNewEntryDateView(PatientService service) {
		removeAll();
		NewEntryStartView view = new NewEntryStartView();
		NewEntryPresenter presenter = new NewEntryPresenter(service, this);
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryConsumptionView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryConsumptionView view = new NewEntryConsumptionView();
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryPressureView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryPressureView view = new NewEntryPressureView();
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryMotivationView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryMotivationView view = new NewEntryMotivationView();
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryActivityView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryActivityView view = new NewEntryActivityView();
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryCommentView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryCommentView view = new NewEntryCommentView();
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryQuestionView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryQuestionView view = new NewEntryQuestionView();
		presenter.setView(view);
		this.add(view);
	}
	
	public void openNewEntryConfirmView(NewEntryPresenter presenter) {
		removeAll();
		NewEntryConfirmView view = new NewEntryConfirmView();
		presenter.setView(view);
		this.add(view);
	}

}
