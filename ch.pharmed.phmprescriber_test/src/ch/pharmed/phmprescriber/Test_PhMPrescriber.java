package ch.pharmed.phmprescriber;

import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class Test_PhMPrescriber {


	@Before
	public void setUp() throws Exception{}

	@After
	public void teardown() throws Exception{
		PlatformUI.getWorkbench().saveAllEditors(false); // do not confirm saving
		PlatformUI.getWorkbench().saveAll(PlatformUI.getWorkbench().getActiveWorkbenchWindow(), PlatformUI.getWorkbench().getActiveWorkbenchWindow(), null, false);
		if (PlatformUI.getWorkbench() != null) // null if run from Eclipse-IDE
		{
			// needed if run as surefire test from using mvn install
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllPerspectives(false, true);
		}
	}

	@Test
	public void test(){

		System.out.println("JUnit testing PhMPrescriber-Plugin");
		getPhysicianInformationShouldReturnPhysicianAttributes();
	}

	private static void getPhysicianInformationShouldReturnPhysicianAttributes() {

		Physician phys = new Physician();
		phys.getAttributesFromWeb("U038713");
		assertEquals("U038713", phys.getZsrid());
		assertEquals("Strub", phys.getLastname());

		phys.getAttributesFromWeb("U 0387.13");
		assertEquals("Strub", phys.getLastname());
		assertEquals("U 0387.13", phys.getZsrid());

	}


}
