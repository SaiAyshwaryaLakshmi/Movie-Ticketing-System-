package org.DesignPatterns.Iterator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class UnitTestForIteratorDesignPattern {
	
	public static Iterator iterator;
	public static Container container;
	
	public UnitTestForIteratorDesignPattern(Iterator iterator, Container container)
	{
		this.iterator = iterator;
		this.container = container;
	}

	@Test
	public void testIteratorMethodsImplemented() {
		assertTrue(container.getIterator());
		
	}
	 @Parameterized.Parameters
	    public static Collection<Object[]> instancesToTest() {
	        return Arrays.asList(
	                    new Object[]{new CarsFromList()},
	                    new Object[]{new Cars()}
	        );

}
