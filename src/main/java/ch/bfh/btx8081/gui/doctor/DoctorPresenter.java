package ch.bfh.btx8081.gui.doctor;

import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.interfaces.DoctorService;

public class DoctorPresenter {


  private String firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo,
      consumedSubstance, consumptionMetric, conditionAutomaticAlarm;

  //private DoctorView view;

  private DoctorService service;


  public DoctorPresenter(DoctorService service) {

    this.service = service;
    //this.view = view;
    this.firstName = "";
    this.lastName = "";
    this.phoneNumber = "";
    this.eMail = "";
    this.userName = "";
    this.password = "";
    this.addiction = "";
    this.mainInfo = "";
    this.consumedSubstance = "";
    this.consumptionMetric = "";
    this.conditionAutomaticAlarm = "";
  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

//  @Override
//  public void authenticate(String userName, String password)
//      throws WrongPasswordException, UserNotFoundException {
//    // TODO Auto-generated method stub
//    
//  }

  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getEmail() {
    return eMail;
  }


  public void setEmail(String email) {
    this.eMail = email;
  }


  public String getUserName() {
    return userName;
  }


  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getAddiction() {
    return addiction;
  }


  public void setAddiction(String addiction) {
    this.addiction = addiction;
  }


  public String getMainInfo() {
    return mainInfo;
  }


  public void setMainInfo(String mainInfo) {
    this.mainInfo = mainInfo;
  }


  public DoctorService getService() {
    return service;
  }


  public void setService(DoctorService service) {
    this.service = service;
  }


  //public DoctorView getView() {
  //  return view;
  //}


  //public void setView(DoctorView view) {
   // this.view = view;
  //}



  public void saveButton(String patientData) {
    try {
      String[] patientDataSplitted = patientData.split(";");
      this.firstName = patientDataSplitted[0];
      this.lastName = patientDataSplitted[1];
      this.phoneNumber = patientDataSplitted[2];
      this.eMail = patientDataSplitted[3];
      this.userName = patientDataSplitted[4];
      this.password = patientDataSplitted[5];
      this.addiction = patientDataSplitted[6];
      this.mainInfo = patientDataSplitted[7];
      this.consumedSubstance = patientDataSplitted[8];
      this.consumptionMetric = patientDataSplitted[9];
      this.conditionAutomaticAlarm = patientDataSplitted[10];

      service.newPatient(firstName, lastName, phoneNumber, eMail, userName, password, addiction,
          mainInfo, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
    } catch (UsernameIsAlreadyTakenException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   

  }


}
