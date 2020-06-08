package ch.bfh.btx8081.persistence;

import java.util.List;

import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public class TestJpa {

	public static void main(String[] args) throws Exception {

//		TestJpaDriverAndConnection.checkConnection();

//		DiaryManager dm = DiaryManager.getInstance();
		PersistenceManager pm = new PersistenceManager();

//		Set or remove data from database for test
		
//		pm.clearDb();
//		dm.setUp();

//		Retreive data test

//		List<Doctor> docList = dm.getDoctorsFromDb();
//		for (Doctor d : docList) {
//			System.out.println("Doctor name = " + d.getUserName());
//			List<Patient> docPatList = dm.getAllPatientsOfDoctor(d);
//			for (Patient p : docPatList) {
//				System.out.println("Patient username =  " + p.getUserName());
//				System.out.println(p.getDiary().getConsumedSubstance());
//				List<Entry> entryList = dm.getDiaryEntries(p);
//				for (Entry e : entryList) {
//					System.out.println("Consumption: " + e.getConsumption());
//
//				}
//			}
//		}

//		Deletion test

//		Doctor doctorToDelete = docList.get(0);
//		dm.removeDoctor(doctorToDelete);
//		pm.clearDb();

	}

}