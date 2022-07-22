

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany mgmtCo;
	Property prop1, prop2, prop3, prop4, prop5, prop6;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mgmtCo = new ManagementCompany();
		
		//student add three properties, with plots, to mgmt co
		prop1 = new Property("First House", "Detroit", 500.0, "Mr. Parker", 4, 2, 2, 2);
		prop2 = new Property("Second House", "Beijing", 1500, "Echigoya", 4, 4, 3, 3);
		prop3 = new Property("Storage", "Vegas", 2345.0, "anonymous", 6, 0, 2, 2);
		
		mgmtCo.addProperty(prop1);
		mgmtCo.addProperty(prop2);
		mgmtCo.addProperty(prop3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		mgmtCo = null;
		prop1=prop2=prop3=prop4=prop5=prop6 = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		/*fail("STUDENT test not implemented yet");*/
		prop4 = new Property("Guest House", "Detroit", 1000, "Packer");
		prop5 = new Property("Workstation", "Cleveland", 655, "anonTBD", 1, 5, 2, 2);
		prop6 = new Property("", "", 1, "", 9, 9, 1, 1);
		
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(mgmtCo.addProperty(prop4), 3, 0);
		
		//student should add property with 8 args
		assertEquals(mgmtCo.addProperty(prop5), 4, 0);
		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(mgmtCo.addProperty(prop6), -1, 0);
		
	}
 
	@Test
	public void testMaxRentProp() {
		/*fail("STUDENT test not implemented yet");*/
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmtCo.maxRentProp(), 2345.0, 0);
		
	}

	@Test
	public void testTotalRent() {
		/*fail("STUDENT test not implemented yet");*/
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmtCo.totalRent(), 4345.0, 0);
	}

 }
