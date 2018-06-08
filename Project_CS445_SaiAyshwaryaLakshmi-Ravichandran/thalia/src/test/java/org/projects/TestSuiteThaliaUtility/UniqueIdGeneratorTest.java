package org.projects.TestSuiteThaliaUtility;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.Test;
import org.projects.ThaliaUtility.UniqueIdGenerator;

public class UniqueIdGeneratorTest {

	@Test
	public void test() {
		UniqueIdGenerator id = new UniqueIdGenerator();
		assertEquals("Integer",id.getUniqueID().getClass().getSimpleName());
		assertEquals("Integer",id.getReportId().getClass().getSimpleName());
	}

}
