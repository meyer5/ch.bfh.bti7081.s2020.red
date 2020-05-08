package ch.bfh.btx8081;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.interfaces.DoctorInterface;
import ch.bfh.btx8081.interfaces.PatientInterface;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;

public class ModelTests {

	private static DoctorInterface doctor = DiaryManager.getInstance();
	private static PatientInterface patient = DiaryManager.getInstance();
	private static DiaryManager manager = DiaryManager.getInstance();

	@Before
	private static void setUp() throws UsernameIsAlreadyTakenException {
//		ModelTests.doctor.newDoctor(firstName, lastName, phoneNumber, eMail, userName, password);
		doctor.newDoctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
		doctor.newDoctor("Heidi", "Müller", "0700000000", "heidi.mueller@mail.ch", "hmueller", "asdf");
//		doctor.newPatient(firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
		doctor.newPatient("Patrick", lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
		doctor.newPatient("Patrick", lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
		doctor.newPatient("Patrick", lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
		doctor.newPatient("Patrick", lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
