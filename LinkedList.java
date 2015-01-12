package cw3;

public class LinkedList implements List {
	private Object Listdata;
	private LinkedList pointer;
	
	
	@Override
	public boolean isEmpty() {
		return (pointer == null) ? false : true;		
	}

	@Override
	public int size() {
		List tempList;
		int size = 0;
		if(!isEmpty()) {
			do {
				size++;
				tempList = pointer;
			} while(tempList != null);
		}
		return size;
		
	}

	@Override
	public ReturnObject get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
