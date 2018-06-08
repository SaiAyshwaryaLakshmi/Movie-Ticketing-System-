package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import org.junit.Test;
import org.projects.Thalia.PatronInfo;

public class PatronInfoTest {
	
	PatronInfo pI = new PatronInfo();


	@Test
	public void test_TicketsFieldConstructor() {
		
     pI = new PatronInfo("John Swords", "6439742408", "swords@random.com", "1 way street, Ohio, USA", "123456789", "09/23");
     assertEquals("John Swords",pI.getName());
     assertEquals("6439742408",pI.getPhone());
     assertEquals("swords@random.com",pI.getEmail());
     assertEquals("1 way street, Ohio, USA",pI.getBillingAddress());
     assertEquals("123456789",pI.getCcNumber());
     assertEquals("09/23",pI.getCcExpirationDate());
     
	}
	
	@Test
	public void test_SettersANDGetters() {
		pI.setName("Madison Tails");
		pI.setPhone("123456789");
		pI.setEmail("swords@something.com");
		pI.setBillingAddress("1 way street, New york, USA");
		pI.setCcNumber("23478909857");
		pI.setCcExpirationDate("09/24");
		
			 assertEquals("Madison Tails",pI.getName());
		     assertEquals("123456789",pI.getPhone());
		     assertEquals("swords@something.com",pI.getEmail());
		     assertEquals("1 way street, New york, USA",pI.getBillingAddress());
		     assertEquals("xxxxxxx9857",pI.getCcNumber());
		     assertEquals("09/24",pI.getCcExpirationDate());
		
	}


}
