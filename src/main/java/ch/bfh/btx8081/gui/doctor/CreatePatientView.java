package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Doctor;


@Route(value = "create_patient", layout = DoctorMainUI.class)
public class CreatePatientView extends VerticalLayout {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public DoctorPresenter presenter;

  // private ViewController viewController;

  public String patientData = "";

  // BeanValidationBinder<Patient> binder = new BeanValidationBinder<>(Patient.class);
  private FormLayout blockOne = new FormLayout();
  private FormLayout blockTwo = new FormLayout();
  private FormLayout blockThree = new FormLayout();
  
  


  private TextField firstName = new TextField();
  private TextField lastName = new TextField();
  private TextField phoneNumber = new TextField();
  private TextField eMail = new TextField();
  private TextField userName = new TextField();
  private PasswordField password = new PasswordField();
  private PasswordField repeatPassword = new PasswordField();
  private TextField addiction = new TextField();
  private TextField mainInfo = new TextField();

  // default doctor is the currently logged user
  // private ComboBox<Doctor> docters = new ComboBox<Doctor>();
  private TextField consumedSubstance = new TextField();
  private TextField consumptionMetric = new TextField();
  private TextField conditionAutomaticAlarm = new TextField();
  private Button saveButton = new Button("Save Patient");



  public CreatePatientView(DoctorPresenter presenter) {


    this.presenter = presenter;

  
    setSizeFull();

    // blockOne
    firstName.setWidth("100%");
    blockOne.addFormItem(firstName, "First name");

    lastName.setWidth("100%");
    blockOne.addFormItem(lastName, "Last name");

    phoneNumber.setWidth("100%");
    blockOne.addFormItem(phoneNumber, "Phone number");

    eMail.setWidth("100%");
    blockOne.addFormItem(eMail, "Email");


    // blockTwo
    userName.setWidth("100%");
    blockTwo.addFormItem(userName, "Username");

    password.setWidth("100%");
    blockTwo.addFormItem(password, "Password");
    blockTwo.getElement().appendChild(ElementFactory.createBr());

    repeatPassword.setWidth("100%");
    blockTwo.addFormItem(repeatPassword, "Repeat Password");



    // block Three
    addiction.setWidth("100%");
    blockThree.addFormItem(addiction, "Addiction");


    mainInfo.setWidth("100%");
    blockThree.addFormItem(mainInfo, "Main info");


    consumedSubstance.setWidth("100%");
    blockThree.addFormItem(consumedSubstance, "Consumed substance");


    consumptionMetric.setWidth("100%");
    blockThree.addFormItem(consumptionMetric, "Consumed metric");


    conditionAutomaticAlarm.setWidth("100%");
    blockThree.addFormItem(conditionAutomaticAlarm, "Condition automatic alarm");



    add(blockOne, blockTwo, blockThree, saveButton);

    // shouldn't be implemented here
    saveButton.addClickListener(ClickEvent -> {
      presenter.saveButton(patientData = firstName.getValue() + ";" + lastName.getValue() + ";"
          + phoneNumber.getValue() + ";" + eMail.getValue() + ";" + userName.getValue() + ";"
          + password.getValue() + ";" + addiction.getValue() + ";" + mainInfo.getValue() + ";"
          + consumedSubstance.getValue() + ";" + consumptionMetric.getValue() + ";"
          + conditionAutomaticAlarm.getValue());
    });

  }


}
