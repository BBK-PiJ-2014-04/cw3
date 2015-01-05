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
		} // The nulls won't be visible from outside the class, and I will use them to define removed/added elements
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
		if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			for(int i = index; i < this.size(); i++) {
				if(i == index) {
					
				}
				if(!myarray[i+1].equals(null)) {
					myarray[i] = myarray[i+1];
				}
					
			}
		}	
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
