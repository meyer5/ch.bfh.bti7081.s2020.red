package ch.bfh.btx8081;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ch.bfh.btx8081.model.Diary;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.persistence.PersistenceManager;

public class PersistenceTest {

	private PersistenceManager pm = new PersistenceManager();
	
	//TODO test with DiaryManager
	
	List<Patient> patlist = new ArrayList<>();
	List<Doctor> doclist = new ArrayList<>();
	
	Doctor doc2 = new Doctor("remo", "meyer", "666666", "adasfdsa@b", "remom666", "1234");
	Diary diary1 = new Diary();
	Diary diary2 = new Diary();
	Diary diary3 = new Diary();
	Patient pat1 = new Patient("gjgj", "ghkjgv", "0879865", "b@c", "gjkfsafsaf", "gj", "gjkbhjk", "fvjh", doc2,
			diary1);
	Doctor doc1 = new Doctor("remo2", "meyer", "666666", "a@b", "remom2", "1234", (ArrayList<Patient>) patlist);
	Doctor doc3 = new Doctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
	Doctor doc4 = new Doctor("Heidi", "Müller", "0700000000", "heidi.mueller@mail.ch", "hmueller", "asdf");
	Patient pat2 = new Patient("Natalya", "Dénervaud", "0700000003", "hans.meier@mail.ch", "natalya", "123", "Hero",
			"Kommentar", doc3, diary2);
	Patient pat3 = new Patient("Kaurisanker", "Kirupananthan", "0700000002", "hans.meier@mail.ch", "kausi", "123",
			"Hero", "Kommentar", doc4, diary3);
	
	
	
	@Test
	public void testSaveDoctor() {
		pm.saveDoctor(doc2);
		doclist = pm.getDoctors();
		assertTrue(doclist.get(0).getFirstName().equals("remo"));
	}
	
	@Test
	public void testSavePatient() {
		pm.savePatient(pat1);
		patlist = pm.getPatients();
		assertTrue(patlist.get(0).getFirstName().equals("gjgj"));
	}
	
	@Test
	public void testDelete() {
		
	}

}
