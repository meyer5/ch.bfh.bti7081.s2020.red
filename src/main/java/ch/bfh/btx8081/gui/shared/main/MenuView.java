package ch.bfh.btx8081.gui.shared.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

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
//  private MainView main;
//  private Service service;

  public MenuView(MainView main, Service service) {

//    this.main = main;
//    this.service = service;
    menu = new MenuBar();
    if (service instanceof DoctorService) {

      menu.addItem(new Button("Edit patient data", VaadinIcon.USER_CARD.create()),
          e -> main.openEditPatientView((DoctorService) service));
      menu.addItem(new Button("All entries", VaadinIcon.NOTEBOOK.create()),
          e -> main.openEntriesListView(service));
      menu.addItem(new Button("Activities", VaadinIcon.HANDS_UP.create()),
          e -> main.openActivitiesView(service));
      menu.addItem(new Button("Open questions", VaadinIcon.QUESTION.create()),
          e -> main.openQuestionsView(service));
      menu.addItem(new Button("Strategies", VaadinIcon.MAGIC.create()),
          e -> main.openStrategiesView(service));
      menu.addItem(new Button("Patient overview", VaadinIcon.ARROW_FORWARD.create()),
          e -> main.openPatientInfoView((DoctorService) service));
      menu.addItem(new Button("Log out", VaadinIcon.SIGN_OUT.create()), e -> main.openLoginView());

    } else if (service instanceof PatientService) {
      
      menu.addItem(new Button("New entry", VaadinIcon.FILE_ADD.create()),
          e -> main.openNewEntryView((PatientService) service));
      menu.addItem(new Button("Show all entries", VaadinIcon.NOTEBOOK.create()),
          e -> main.openEntriesListView(service));
      menu.addItem(new Button("Alarm", VaadinIcon.BELL_O.create()),
          e -> main.openAlarmView((PatientService) service));
      menu.addItem(new Button("Questions", VaadinIcon.QUESTION.create()),
          e -> main.openQuestionsView(service));
      menu.addItem(new Button("Activities", VaadinIcon.HANDS_UP.create()),
          e -> main.openActivitiesView(service));
      menu.addItem(new Button("Strategies", VaadinIcon.MAGIC.create()),
          e -> main.openStrategiesView(service));
      menu.addItem(new Button("Back to overview", VaadinIcon.ARROW_FORWARD.create()),
          e -> main.openMainPatientView((PatientService) service));
      menu.addItem(new Button("Log out", VaadinIcon.SIGN_OUT.create()), e -> main.openLoginView());
    }


    HorizontalLayout top = new HorizontalLayout(menu);
    top.setJustifyContentMode(JustifyContentMode.CENTER);
    top.setWidth("100%");

    this.addToNavbar(true, top);

  }

}
