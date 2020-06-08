package ch.bfh.btx8081;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.Test;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.model.Diary;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;

public class ModelTests {

    private static DiaryManager manager = DiaryManager.getInstance();

	@Test
	public void schould_GetDoctor() throws UsernameIsAlreadyTakenException, UserNotFoundException, ShowAvoidanceStrategyException  {
		//given
		Doctor doctorExpected = new Doctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "doctor1", "123");
		
		//when
		System.out.println(manager.getDoctors().get(0).getUserName());

		//then
		assertEquals(doctorExpected.getUserName(), manager.getDoctors().get(0).getUserName());
		
	}
	
	@Test
	public void should_ChangeContactInfoByPatient() throws UsernameIsAlreadyTakenException, UserNotFoundException, ShowAvoidanceStrategyException {
		
		//given
		Doctor doctorTest = new Doctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
		Diary diaryTest = new Diary();
		Patient patientWillChanged = new Patient("Remo", "Meyer", "0700000001", "hans.meier@mail.ch", "remo", "123", "Hero", "Kommentar", doctorTest, diaryTest);
		Patient patientExpected = new Patient("ChangedFirstName", "ChangedLastName", "ChangedPhoneNumber", "ChangedEMail", "remo", "123", "Hero", "Kommentar", doctorTest, diaryTest);

		//when
		manager.changeContactInfo(patientWillChanged, "ChangedFirstName", "ChangedLastName", "ChangedPhoneNumber", "ChangedEMail");

		//then
		assertAll(
				() -> assertEquals(patientExpected.getFirstName(), patientWillChanged.getFirstName()),
				() -> assertEquals(patientExpected.getLastName(), patientWillChanged.getLastName()),
				() -> assertEquals(patientExpected.getPhoneNumber(), patientWillChanged.getPhoneNumber()),
				() -> assertEquals(patientExpected.geteMail(), patientWillChanged.geteMail())
		);
	}
	
	@Test
	public void should_ChangeMainInfoByPatient() throws UsernameIsAlreadyTakenException, UserNotFoundException, ShowAvoidanceStrategyException {
		
		//given
		Doctor doctorTest = new Doctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
		Diary diaryTest = new Diary();
		Patient patientWillChanged = new Patient("Remo", "Meyer", "0700000001", "hans.meier@mail.ch", "remo", "123", "Hero", "Kommentar", doctorTest, diaryTest);
		Patient patientExpected = new Patient("Remo", "Meyer", "0700000001", "hans.meier@mail.ch", "remo", "123", "Hero", "ChangedKommentar", doctorTest, diaryTest);

		//when
		manager.changeMainInfo(patientWillChanged, "ChangedKommentar");

		//then
		assertEquals(patientExpected.getMainInfo(), patientWillChanged.getMainInfo());
		
	}
	
	

}
