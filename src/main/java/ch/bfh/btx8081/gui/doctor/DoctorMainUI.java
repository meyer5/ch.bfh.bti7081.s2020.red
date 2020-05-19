package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route(value = "doctor")
public class DoctorMainUI extends AppLayout {

  private static final long serialVersionUID = -5980036826709531009L;

  public DoctorMainUI() {

    setPrimarySection(AppLayout.Section.NAVBAR);
    final boolean touchOptimized = true;
    addToNavbar(touchOptimized, new DrawerToggle());
    addToNavbar(new H2("Addiction Diary"));

    final VerticalLayout menuBar = new VerticalLayout();

    menuBar.add(new RouterLink(PatientDashboard.TITLE, PatientDashboard.class));
    menuBar.add(new RouterLink(PatientInfoPresenter.TITLE, PatientInfoPresenter.class));
    //menuBar.add(new RouterLink(CreatePatientView.TITLE, CreatePatientView.class));
    menuBar.add(new RouterLink(SearchByNameView.TITLE, SearchByNameView.class));
    menuBar.add(new RouterLink(QuestionsView.TITLE, QuestionsView.class));

    addToDrawer(menuBar);

  }

}

