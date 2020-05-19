package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route(value = "del-doctor-main")
public class ZZZ_del_DoctorMainUI extends AppLayout {

  private static final long serialVersionUID = -5980036826709531009L;

  public ZZZ_del_DoctorMainUI() {

    setPrimarySection(AppLayout.Section.NAVBAR);
    final boolean touchOptimized = true;
    addToNavbar(touchOptimized, new DrawerToggle());
    addToNavbar(new H2("Addiction Diary"));

    final VerticalLayout menuBar = new VerticalLayout();

    menuBar.add(new RouterLink(StatisticsView.TITLE, StatisticsView.class));
    menuBar.add(new RouterLink(PatientInfoView.TITLE, PatientInfoView.class));
//    menuBar.add(new RouterLink(CreatePatientView.TITLE, CreatePatientView.class));
    menuBar.add(new RouterLink(MainDoctorView.TITLE, MainDoctorView.class));

    addToDrawer(menuBar);

  }

}

