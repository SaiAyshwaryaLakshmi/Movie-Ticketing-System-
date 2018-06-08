package org.DesignPatterns.Iterator;

public class CarsList implements Container {
	public String names[] = {"Altima","Maxima","Rouge"};
	
	@Override
	public Iterator getIterator() {
		
		return new ConcreteIterator();
	}
	private class ConcreteIterator implements Iterator{
		
		int number = 0;
		@Override
		public boolean hasNext() {
			if (number < names.length)
			{
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			
			if(this.hasNext())
			{
				return names[number++];
			}
			return null;
		}
	
	}
}
