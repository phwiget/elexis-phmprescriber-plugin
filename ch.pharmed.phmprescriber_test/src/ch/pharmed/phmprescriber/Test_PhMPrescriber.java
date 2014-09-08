package ch.pharmed.phmprescriber;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;



public class Test_PhMPrescriber {
	
	
	@Before
	public void setUp() throws Exception{}
	
	@Test
	public void test(){
		
		System.out.println("JUnit testing PhMPrescriber-Plugin");
		
		getPhysicianInformationShouldReturnPhysicianAttributes();
	}

	private static void getPhysicianInformationShouldReturnPhysicianAttributes() {
		
		System.out.println("Test Physician");
	
		Physician phys = new Physician();
		
		System.out.println(phys.getZsrid());
		System.out.println(phys.getLastname());
		
		phys.getAttributesFromWeb("U038713");
		System.out.println(phys.getLastname());
		
		phys.getAttributesFromWeb("U 0387.13");
		System.out.println(phys.getLastname());
		
	}
	

}
