package ch.bfh.btx8081.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.User;

public class PersistenceManager {

	private static final String PERSISTENCE_UNIT_NAME = "addictionDiary";

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private EntityManager em = factory.createEntityManager();

	public List<Doctor> getDoctors() {
		TypedQuery<Doctor> q = em.createQuery("SELECT e FROM Doctor e", Doctor.class);
		List<Doctor> doctors = q.getResultList();
		return doctors;
	}

	public List<Patient> getPatients() {
		TypedQuery<Patient> q = em.createQuery("SELECT e FROM Patient e", Patient.class); 
		List<Patient> patients = q.getResultList();
		return patients;
	}

	public void saveUserData(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	
//	em.close();
//	factory.close();

}
