package org.projects.ThaliaUtility;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
    static AtomicInteger atomicInteger = new AtomicInteger(122);
    static AtomicInteger atom = new AtomicInteger(800);
    
    public static Integer getUniqueID() {
        return atomicInteger.incrementAndGet();
    }
    
    public static Integer getReportId()
    {
   		return atom.incrementAndGet();
    	
    }
}
