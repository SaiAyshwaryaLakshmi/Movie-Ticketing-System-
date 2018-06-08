package org.DesignPatterns.Iterator;

public class CarsScanning {
	public static void main(String args[]){
		
		CarsList list = new CarsList();
		System.out.println("Using Iterator - Does Not Expose Elements of List");
		for (Iterator item = list.getIterator(); item.hasNext();)
		{
			String name = (String)item.next();
			System.out.println("Name :" + name);
		}
		System.out.println("Without using Iterator - Risk Of Elements in List being modified");
		for (int i = 0; i<list.names.length ;i++)
		{
		  System.out.println("Name :" + list.names[i]);
		  list.names[1] = "BMW";
		}
	}
}
