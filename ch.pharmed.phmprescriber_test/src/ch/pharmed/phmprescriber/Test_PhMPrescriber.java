package ch.pharmed.phmprescriber;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class Test_PhMPrescriber {
	
	
	@Before
	public void setUp() throws Exception{}
	
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
