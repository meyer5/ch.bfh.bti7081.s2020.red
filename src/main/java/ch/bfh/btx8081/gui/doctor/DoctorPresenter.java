package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.interfaces.DoctorInterface;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public class DoctorPresenter implements DoctorInterface {

  

  @Override
  public ArrayList<Patient> searchPatientOfDoctor(Doctor doctor, String SearchQuery)
      throws PatientNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<Patient> getAllPatientsOfDoctor(Doctor doctor) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<Entry> getDiaryEntries(Patient patient) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void authenticate(String userName, String password)
      throws WrongPasswordException, UserNotFoundException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void newDoctor(String firstName, String lastName, String phoneNumber, String eMail,
      String userName, String password) throws UsernameIsAlreadyTakenException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void newPatient(String firstName, String lastName, String phoneNumber, String eMail,
      String userName, String password, String addiction, String mainInfo, Doctor doctor,
      String consumedSubstance, String consumptionMetric, String conditionAutomaticAlarm)
      throws UsernameIsAlreadyTakenException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void changeContactInfo(Patient patient, String firstName, String lastName,
      String phoneNumber, String eMail) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void changeMainInfo(Patient patient, String newMainInfo) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void createNewActivity(Patient patient, String activity, String iconID) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeNewActivity(Patient patient, Activity activity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void createNewAvoidanceStrategy(Patient patient, String avoidanceStrategy) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeNewAvoidanceStrategy(Patient patient, AvoidanceStrategy avoidanceStrategy) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setConditionAutomaticAlarm(Patient patient, String conditionAutomaticAlarm) {
    // TODO Auto-generated method stub
    
  }

}
