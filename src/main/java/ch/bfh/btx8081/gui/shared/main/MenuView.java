package ch.bfh.btx8081.gui.shared.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.gui.shared.*;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;


@Route(value = "menu")
public class MenuView extends AppLayout {
  /**
   * 
   */
  private static final long serialVersionUID = -103353706598925084L;

  public static final String TITLE = "Menu";

  // private final Tabs menu;
  private MenuBar menu;
  private MainView main;
  private Service service;

  public MenuView(MainView main, Service service) {

    // Create Menu
    // this.setDrawerOpened(false);

    this.main = main;
    this.service = service;
    menu = new MenuBar();
    if (service instanceof DoctorService) {

      menu.addItem(new Button("Edit Patient data", VaadinIcon.USER_CARD.create()),
          e -> main.openEditPatientView((DoctorService) service));
      menu.addItem(new Button("all Entries", VaadinIcon.NOTEBOOK.create()),
          e -> main.openEntriesListView(service));
      menu.addItem(new Button("Activites", VaadinIcon.HANDS_UP.create()),
          e -> main.openActivitiesView(service));
      menu.addItem(new Button("open Questions", VaadinIcon.QUESTION.create()),
          e -> main.openQuestionsView(service));
      menu.addItem(new Button("Strategies", VaadinIcon.MAGIC.create()),
          e -> main.openStrategiesView(service));
      menu.addItem(new Button("Patient overview", VaadinIcon.ARROW_FORWARD.create()),
          e -> main.openPatientInfoView((DoctorService) service));
      menu.addItem(new Button("Log out", VaadinIcon.SIGN_OUT.create()), e -> main.openLoginView());

    } else if (service instanceof PatientService) {
      
      menu.addItem(new Button("new Entry", VaadinIcon.FILE_ADD.create()),
          e -> main.openNewEntryView((PatientService) service));
      menu.addItem(new Button("show all Entries List", VaadinIcon.NOTEBOOK.create()),
          e -> main.openEntriesListView(service));
      menu.addItem(new Button("Alarm", VaadinIcon.BELL_O.create()),
          e -> main.openAlarmView((PatientService) service));
      menu.addItem(new Button("Question", VaadinIcon.QUESTION.create()),
          e -> main.openQuestionsView(service));
      menu.addItem(new Button("Activites", VaadinIcon.HANDS_UP.create()),
          e -> main.openActivitiesView(service));
      menu.addItem(new Button("Strategies", VaadinIcon.MAGIC.create()),
          e -> main.openStrategiesView(service));
      menu.addItem(new Button("back to Mainview", VaadinIcon.ARROW_FORWARD.create()),
          e -> main.openMainPatientView((PatientService) service));
      menu.addItem(new Button("log out", VaadinIcon.SIGN_OUT.create()), e -> main.openLoginView());
    }


    HorizontalLayout top = new HorizontalLayout(menu);
    top.setJustifyContentMode(JustifyContentMode.CENTER);
    top.setWidth("100%");

    this.addToNavbar(true, top);

  }

}
