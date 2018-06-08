package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import org.junit.Test;
import org.projects.Thalia.SeatingInfo;

public class SeatingInfoTest {

	SeatingInfo sI = new SeatingInfo();
	@Test
	public void test_SeatingInfoConstructorField() {
		sI = new SeatingInfo("6",75L);
		assertEquals("6",sI.getSid());
		assertSame(75L,sI.getPrice());
	}
	
	@Test
	public void test_SettersANDGetters() {
		sI.setPrice(67L);
		sI.setSid("8");
		assertEquals("8",sI.getSid());
	     assertSame(67L,sI.getPrice());		
 }
}
