package cw3;

public class LinkedList implements List {
	private Object Listdata;
	private LinkedList pointer;
	
	@Override
	public boolean isEmpty() {
		return (pointer == null) ? true : false;		
	}

	@Override
	public int size() {
		int size = 0;
		LinkedList tempList;
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
		if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			LinkedList tempList = pointer;
			for(int i = 1; i == index; i++) {
				tempList = pointer;
			}
			return new ReturnObjectImpl(tempList.Listdata);
		}
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
