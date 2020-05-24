package ch.bfh.btx8081.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.model.Diary;
import ch.bfh.btx8081.model.Doctor;
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
		
		// use entities
		em.getTransaction().begin();
	    
		Doctor doc2 = new Doctor();
		Diary diary1 = new Diary();
		List<Patient> patlist = new ArrayList<>();
		
		
		Patient pat1 = new Patient("gjgj", "ghkjgv", "0879865", "b@c", "gjkfsafsaf", "gj", "gjkbhjk", "fvjh", doc2, diary1);
		patlist.add(pat1);
		
		Doctor doc1 = new Doctor("remo2", "meyer", "666666", "a@b", "remom2", "1234", (ArrayList<Patient>) patlist);
		
	    
//		List<Activity> res = new ArrayList<Activity>();
//		res.add(new Activity("1", "1111"));
//		res.add(new Activity("2", "1111"));
//		
//		em.persist(res);
//		em.flush();
	    em.persist(doc1);
	    em.flush();
	    em.persist(pat1);
	    em.flush();
	    em.getTransaction().commit();

	    
//	    Query q = em.createQuery("SELECT e FROM Doctor e", Doctor.class); 
//		List<Doctor> doctors = q.getResultList();
//		for (Doctor d : doctors) {
//			System.out.println(d.getFirstName());
//		}
		
	    
	    
	    
		em.close();
		

	}

}