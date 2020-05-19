package ch.bfh.btx8081.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Diary;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;

public class TestJpa {

	private static final String PERSISTENCE_UNIT_NAME = "addictionDiary";

	public static void main(String[] args) throws Exception {
		
		TestJpaDriverAndConnection.checkConnection();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// use entities
		em.getTransaction().begin();
	    
		Doctor doc2 = new Doctor();
		Diary diary1 = new Diary();
		List<Patient> patlist = new ArrayList<>();
		
		
		Patient pat1 = new Patient("gjgj", "ghkjgv", "0879865", "b@c", "gjk", "gj", "gjkbhjk", "fvjh", doc2, diary1);
		patlist.add(pat1);
		
		Doctor doc1 = new Doctor("remo", "meyer", "666666", "a@b", "remom", "1234", (ArrayList<Patient>) patlist);
	    
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

		em.close();
		
//		Class.forName("org.sqlite.JDBC");
//		Connection conn = DriverManager.getConnection("jdbc:sqlite:addictionDiary.db");
//		Statement st = conn.createStatement();
//		ResultSet mrs = conn.getMetaData().getTables(null, null, null, new String[] { "TABLE" });
//	    while (mrs.next()) {
//	      String tableName = mrs.getString(3);
//	      System.out.println("\n\n\n\nTable Name: "+ tableName);
//
//	      ResultSet rs = st.executeQuery("select * from " + tableName);
//	      ResultSetMetaData metadata = rs.getMetaData();
//	      while (rs.next()) {
//	        System.out.println(" Row:");
//	        for (int i = 0; i < metadata.getColumnCount(); i++) {
//	          System.out.println("    Column Name: "+ metadata.getColumnLabel(i + 1)+ ",  ");
//	          System.out.println("    Column Type: "+ metadata.getColumnTypeName(i + 1)+ ":  ");
//	          Object value = rs.getObject(i + 1);
//	          System.out.println("    Column Value: "+value+"\n");
//	        }
//	      }
//	    }
	}

}