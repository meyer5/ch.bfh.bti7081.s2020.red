package ch.bfh.btx8081.persistence;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.bfh.btx8081.model.Diary;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

/**
 * Class that provides methods to make connection to database.
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

	public List<Patient> getPatientsOfDoctor(Doctor d) {
		Query q = em.createNativeQuery("SELECT * FROM Patient WHERE DOCTOR_USERNAME=doctor_username", Patient.class);
		q.setParameter("doctor_username", d.getUserName());
		List<Patient> patients = q.getResultList();
		return patients;
	}

	public List<Diary> getDiaries() {
		TypedQuery<Diary> q = em.createQuery("SELECT e FROM Diary e", Diary.class);
		List<Diary> diaries = q.getResultList();
		return diaries;
	}

	public Diary getPatientDiaries(Patient p) {
		Query q = em.createNativeQuery("SELECT * FROM Patient WHERE USERNAME=USERNAME", Diary.class);
		q.setParameter("USERNAME", p.getUserName());
		Diary diary = (Diary) q.getSingleResult();
		return diary;
	}

	public List<Entry> getDiaryEntries(Patient patient) {
		Diary d = getPatientDiaries(patient);
		Query q = em.createNativeQuery("SELECT * FROM Entry WHERE diary_id=id", Entry.class);
		q.setParameter("id", d.getId());
		List<Entry> entries = q.getResultList();
		return entries;
	}

	public void saveDoctor(Doctor doctor) {
		try {
			em.getTransaction().begin();
			em.persist(doctor);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println(e.toString());
		}
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
	
	public void saveDiary(Diary diary) throws EntityExistsException {
		try {
			em.getTransaction().begin();
			em.persist(diary);
			em.getTransaction().commit();

		} catch (EntityExistsException e) {
			System.out.println(e.toString());
		}
	}
	
	public void saveEntry(Entry entry) throws EntityExistsException {
		try {
			em.getTransaction().begin();
			em.persist(entry);
			em.getTransaction().commit();

		} catch (EntityExistsException e) {
			System.out.println(e.toString());
		}
	}

	public void removeDoctorFromDb(Doctor doctor) {
		try {
			em.getTransaction().begin();
			em.remove(doctor);
			em.getTransaction().commit();
			System.out.println("Deleted doctor " + doctor.getUserName());
		} catch (EntityNotFoundException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void removePatientFromDb(Patient patient) {
		try {
			em.getTransaction().begin();
			em.remove(patient);
			em.getTransaction().commit();
			System.out.println("Deleted patient " + patient.getUserName());
		} catch (EntityNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	public void removeDiaryFromDb(Diary diary) {
		try {
			em.getTransaction().begin();
			em.remove(diary);
			em.getTransaction().commit();
			System.out.println("Deleted diary " + diary.toString());
		} catch (EntityNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	public void clearDb() {
		List<Doctor> docs = getDoctors();
		for (Doctor d : docs) {
			removeDoctorFromDb(d);
		}
		List<Patient> pats = getPatients();
		for (Patient p : pats) {
			removePatientFromDb(p);
		}
		List<Diary> diaries = getDiaries();
		for(Diary d: diaries) {
			removeDiaryFromDb(d);
		}
	}

	public void removeEntryFromDb(Entry entry) {
		try {
			em.getTransaction().begin();
			em.remove(entry);
			em.getTransaction().commit();
			System.out.println("Deleted entry " + entry.toString());
		} catch (EntityNotFoundException e) {
			System.out.println(e.toString());
		}
		
	}

}
