package cw3;

/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * This list is implemented using an array as actual object to store the data.
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
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	@Override
	public boolean isEmpty() {
		return (size() == 0) ? true : false; 
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
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
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
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
	 * Returns the elements at the given position and removes it
	 * from the list. The indexes of elements after the removed
	 * element must be updated accordingly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
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
	 * Adds an element to the list, inserting it at the given
	 * position. The indexes of elements at and after that position
	 * must be updated accordingly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
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
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
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
	
	//I'm not implementing the ToString method as it requires me to add it to the Interface
	public String getList(){
		String ReturnedList = "";
		for(int i = 0; i < this.size(); i++) {
			if(i > 0) ReturnedList += ", ";
			ReturnedList += this.get(i).getReturnValue().toString();
		}
		return ReturnedList;
	}

}
