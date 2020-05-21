package ch.bfh.btx8081.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;



public class PersistenceManager {
	
	private static final String PERSISTENCE_UNIT_NAME = "addictionDiary";
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();
	
	
	
	
	public List<Doctor> getDoctors() {
		Query q = em.createQuery("select i from doctor i"); 
		List<Doctor> doctors = q.getResultList();
		return doctors;
	}
	
//	public List<Patient> getPatients() {
//		Query q = em.createQuery("select i from patient i"); 
//		List<Patient> patients = q.getResultList();
//		return patients;
//	}

	public void save(Doctor doctor) {
		em.persist(doctor);
		em.flush();
		
	}

	public void save(Patient patient) {
		em.persist(patient);
		em.flush();
		
	}
	
	
	
	
	

//	em.getTransaction().begin();
//    
//    
//    em.persist(new Doctor());
//    em.flush();
////    em.persist(new Patient());
////    em.flush();
//
//    
//    
//    em.getTransaction().commit();
//
//	em.close();

}
