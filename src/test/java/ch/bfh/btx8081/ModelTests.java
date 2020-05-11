package ch.bfh.btx8081;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.interfaces.DoctorInterface;
import ch.bfh.btx8081.interfaces.PatientInterface;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;

public class ModelTests {

	private static DoctorInterface doctor = DiaryManager.getInstance();
	private static PatientInterface patient = DiaryManager.getInstance();
	private static DiaryManager manager = DiaryManager.getInstance();

	@Before
	private static void setUp() throws UsernameIsAlreadyTakenException, UserNotFoundException {
		TestSetUp.setUp();
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
