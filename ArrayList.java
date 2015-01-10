package cw3;

public class ArrayList implements List {
	
	public Object[] myarray;
	
	public ArrayList() {
		myarray = new Object[100]; //I will initialise my array with a fixed size(that I will expand if needed)
	}

	@Override
	public boolean isEmpty() {
		if(size() > 0){
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int size() {
		int arraysize = 0;
		for(int i=0;i<myarray.length;i++) {
			if(!myarray[i].equals(null)) {
				arraysize++;
			}
		} // The nulls won't be visible from outside the class, and I will use them to define the size and where to remove/add elements
		return arraysize;
	}

	@Override
	public ReturnObject get(int index) {
		if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			return new ReturnObjectImpl(myarray[index]);
		}
	}

	@Override
	public ReturnObject remove(int index) {
		Object returnvalue = new Object();
		if(size() == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); //if someone tries to remove something from an empty array
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			for(int i = index; i < this.size(); i++) {
				if(i == index) {
					returnvalue = myarray[index];
				}
				myarray[i] = myarray[i+1];
				if(myarray[i+1].equals(null)) {
					break;//if the next value is null, it means we reached the logical end of the array so we can break the cycle.
				}
			}
		}	
		return new ReturnObjectImpl(returnvalue);
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			myarray[end] = item;
			return new ReturnObjectImpl(null);
		}
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		int end = size();
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			myarray[end] = item;
			return new ReturnObjectImpl(null);
		}
	}

}
