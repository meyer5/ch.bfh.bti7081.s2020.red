package ch.bfh.btx8081.persistence;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;

/**
 * Class that makes connection to database.
 * 
 * @author Remo
 *
 */
public class PersistenceManager {

	private static final String PERSISTENCE_UNIT_NAME = "addictionDiary";

	private EntityManagerFactory factory;
	private EntityManager em;

	public PersistenceManager() {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em = factory.createEntityManager();
	}

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

	public void saveDoctor(Doctor doctor) {
		
		//TODO check if doctor already exists ???
		em.getTransaction().begin();
		em.persist(doctor);
		em.getTransaction().commit();

	}

	public void savePatient(Patient patient) throws EntityExistsException {
		try {
			em.getTransaction().begin();
			em.persist(patient);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println(e.toString());
		}

	}

//	em.close();
//	factory.close();

}
