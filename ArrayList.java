package cw3;

/**
 * 
 * ArrayList is a List implementation using an array as underlying structure.
 * The Array is instantiated when the Constructor is called with a fixed length
 * The array is expanded every time the method size() reaches the Array length - 1 
 * 
 * @author SalvatoreCardali
 *
 */

public class ArrayList implements List {
	
	protected Object[] myarray;
	
	/**
	 * Constructor
	 */
	public ArrayList() {
		myarray = new Object[100]; //I will initialise my array with a fixed size(that I will expand if needed)
	}

	
	/**
	 * see @inheritDoc
	 */
	@Override
	public boolean isEmpty() {
		return (size() == 0) ? true : false; 
	}

	/**
	 * see @inheritDoc
	 */
	@Override
	public int size() {
		int arraysize = 0;
		for(int i=0;i<myarray.length;i++) {
			if(!(myarray[i] == null)) {
				arraysize++;
			}
		} // The nulls won't be visible from outside the class, and I will use them to define the size and where to remove/add elements
		return arraysize;
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject get(int index) {
		if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			return new ReturnObjectImpl(myarray[index]);
		}
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject remove(int index) {
		Object returnvalue = new Object();
		if(isEmpty()) {
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
				if(myarray[i+1] == null) {
					break;//if the next value is null, it means we reached the logical end of the array so we can break the cycle.
				}
			}
		}	
		return new ReturnObjectImpl(returnvalue);
	}

	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject add(int index, Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			for(int i = this.size()-1; i >= index; i--) {
				myarray[i+1] = myarray[i];
				if(i == index) {
					myarray[index] = item;
				}
			}
			this.checkArraySize();
			return new ReturnObjectImpl(null);
		}
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject add(Object item) {
		int end = size();
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			myarray[end] = item;
			this.checkArraySize();
			return new ReturnObjectImpl(null);
		}
	}
	
	/**
	 * Checks if we're about to reach the maximum size of the internal array.
	 * If the actual size is equal to the maximum capacity of the array minus one, then
	 * the actual array is copied into another array with double capacity.
	 */
	private void checkArraySize() {
		if(size() == myarray.length-1) {
			Object[] newarray = new Object[myarray.length * 2]; //doubling the size of the array
			for(int i = 0; i < myarray.length; i++) {
				newarray[i] = myarray[i];
			}
			myarray = newarray;
		}
	}

}
