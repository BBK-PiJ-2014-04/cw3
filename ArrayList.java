package cw3;

public class ArrayList implements List {
	
	public Object[] myarray;
	
	public ArrayList(Object[] passedArray) {
		this.myarray = passedArray;
	}
	
	@Override
	public boolean isEmpty() {
		if(myarray.length > 0){
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int size() {
		return myarray.length;
	}

	@Override
	public ReturnObject get(int index) {
		if(index < 0 || index >= myarray.length) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			return new ReturnObjectImpl(myarray[index]);
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
