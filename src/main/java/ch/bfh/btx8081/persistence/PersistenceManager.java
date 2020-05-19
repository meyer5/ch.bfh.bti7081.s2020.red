package ch.bfh.btx8081.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class PersistenceManager {
	
	private static final String PERSISTENCE_UNIT_NAME = "addictionDiary";
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();
//	// use entities
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
