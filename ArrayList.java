package cw3;

public class ArrayList implements List {
	
	public Object[] myarray;
	
	public ArrayList() {
		myarray = new Object[100];
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
		for(int i=0; )
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
