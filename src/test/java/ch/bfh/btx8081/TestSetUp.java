package ch.bfh.btx8081;

import java.time.LocalDate;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;

public class TestSetUp {
	
	private static DiaryManager manager = DiaryManager.getInstance();
	
	public static void setUp() throws UsernameIsAlreadyTakenException, UserNotFoundException, ShowAvoidanceStrategyException {
//		manager.newDoctor(firstName, lastName, phoneNumber, eMail, userName, password);
		manager.newDoctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
		manager.newDoctor("Heidi", "Müller", "0700000000", "heidi.mueller@mail.ch", "hmueller", "asdf");
//		manager.newPatient(firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo, doctor, consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
		manager.newPatient("Remo", "Meyer", "0700000001", "hans.meier@mail.ch", "remo", "123", "Hero", "Kommentar", (Doctor) manager.searchUserByUsername("hmeier"), "Hero", "mg", "Nicht implementiert");
		manager.newPatient("Kaurisanker", "Kirupananthan", "0700000002", "hans.meier@mail.ch", "kausi", "123", "Hero", "Kommentar", (Doctor) manager.searchUserByUsername("hmeier"), "Hero", "mg", "Nicht implementiert");
		manager.newPatient("Natalya", "Dénervaud", "0700000003", "hans.meier@mail.ch", "natalya", "123", "Hero", "Kommentar", (Doctor) manager.searchUserByUsername("hmeier"), "Hero", "mg", "Nicht implementiert");
		manager.newPatient("Dmytriy", "Pelts", "0700000004", "hans.meier@mail.ch", "dmytriy", "123", "Hero", "Kommentar", (Doctor) manager.searchUserByUsername("hmueller"), "Hero", "mg", "Nicht implementiert");
		manager.newPatient("Julian", "Rodriguez", "0700000005", "hans.meier@mail.ch", "julian", "123", "Hero", "Kommentar", (Doctor) manager.searchUserByUsername("hmueller"), "Hero", "mg", "Nicht implementiert");
	
		Patient julian = (Patient) manager.searchUserByUsername("julian");
		manager.newEntry(LocalDate.of(2020, 04, 26), julian, Integer.toUnsignedLong(23) , 3, 3, julian.getDiary().getActivities(), "Test1", "Question1");
		manager.newEntry(LocalDate.of(2020, 04, 25), julian, Integer.toUnsignedLong(23) , 3, 3, julian.getDiary().getActivities(), "Test2", "Question2");
		manager.newEntry(LocalDate.of(2020, 04, 24), julian, Integer.toUnsignedLong(23) , 3, 3, julian.getDiary().getActivities(), "Test3", "Question3");
		
		
	
	}

}
