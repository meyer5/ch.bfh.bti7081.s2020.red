package ch.bfh.btx8081.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Diary;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public class TestJpa {

	private static final String PERSISTENCE_UNIT_NAME = "addictionDiary";

	public static void main(String[] args) throws Exception {
		
		TestJpaDriverAndConnection.checkConnection();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		em.setProperty("PRAGMA foreign_keys", "ON");
			// check if properties are set
		//System.out.println(em.getProperties().toString());
		
		DiaryManager diaryManager = DiaryManager.getInstance();
		
		Doctor doc2 = new Doctor("remo2", "meyer", "666666", "adasfdsa@b", "remom666", "1234");
		Diary diary1 = new Diary();
		Diary diary2 = new Diary();
		Diary diary3 = new Diary();

		List<Patient> patlist = new ArrayList<>();
		
		
		Patient pat1 = new Patient("gjgj", "ghkjgv", "0879865", "b@c", "gjkfsafsaf", "gj", "gjkbhjk", "fvjh", doc2, diary1);
		patlist.add(pat1);
		Doctor doc1 = new Doctor("remo2", "meyer", "666666", "a@b", "remom2", "1234", (ArrayList<Patient>) patlist);
		Doctor doc3 = new Doctor("Hans", "Meier", "0777777777", "hans.meier@mail.ch", "hmeier", "123");
		Doctor doc4 = new Doctor("Heidi", "Müller", "0700000000", "heidi.mueller@mail.ch", "hmueller", "asdf");
		Patient pat2 = new Patient("Natalya", "Dénervaud", "0700000003", "hans.meier@mail.ch", "natalya", "123", "Hero", "Kommentar",
				doc3, diary2);
		Patient pat3 = new Patient("Kaurisanker", "Kirupananthan", "0700000002", "hans.meier@mail.ch", "kausi", "123", "Hero",
				"Kommentar", doc4, diary3);
		

		diaryManager.newEntry(pat1, 1, 2, 3, null, "bvdjsak", "gbdsajk");
		diaryManager.createNewActivity(pat1, "swimming", "1");
		diaryManager.save(pat1);
		

//		 use entities
//		em.getTransaction().begin();
//	    
//		em.persist(doc1);
//		em.persist(doc2);
//		em.persist(doc3);
//		em.persist(doc4);
//	    em.persist(pat1);
//	    em.persist(pat2);
//	    em.persist(pat3);
//	    
//	    
//	    em.getTransaction().commit();

	    
//	    Query q = em.createQuery("SELECT e FROM Doctor e", Doctor.class); 
//		List<Doctor> doctors = q.getResultList();
//		for (Doctor d : doctors) {
//			System.out.println(d.getFirstName());
//		}
		
	    
	    
	    
		em.close();
		

	}

}