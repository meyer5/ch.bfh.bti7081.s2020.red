package ch.bfh.btx8081;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.model.DiaryManager;

public class ModelTests {

//	private static DoctorInterface doctor = DiaryManager.getInstance();
//	private static PatientInterface patient = DiaryManager.getInstance();
	private static DiaryManager manager = DiaryManager.getInstance();

//	@Before
//	public void setUp() throws UsernameIsAlreadyTakenException, UserNotFoundException, ShowAvoidanceStrategyException {
//		TestSetUp.setUp();
//	}
//	
	
	@Test
	public void testDoctor() {
		
		System.out.println(manager.getDoctors().get(0).getUserName());

		assertTrue(manager.getDoctors().get(0).getUserName().equals("hmeier"));
		
	}

}
