package cw3;

public class LinkedList implements List {
	private Object Listdata;
	private LinkedList pointer;
	
	@Override
	public boolean isEmpty() {
		return (size() > 0) ? false : true;		
	}

	@Override
	public int size() {
		int size = 0;
		LinkedList tempList;
		if(!isEmpty()) {
			tempList = this;
			do {
				if(tempList.Listdata != null) {
					size++;
				}
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
			LinkedList tempList = this;
			for(int i = 0; i <= index; i++) {
				if(tempList.Listdata == null) {
					i--;
				}
				if(i < index) {
					tempList = pointer;
				}
			}
			return new ReturnObjectImpl(tempList.Listdata);
		}
	}

	@Override
	public ReturnObject remove(int index) {
		Object returnvalue;
		if(size() == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); //if someone tries to remove something from an empty array
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			LinkedList tempList = this;
			for(int i = 0; i <= index; i++) {
				if(tempList.Listdata == null) {
					i--;
				}
				if(i < index) {
					tempList = pointer;
				}
			}
			return new ReturnObjectImpl(tempList.Listdata);
		}
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
