package cw3;
/**
 * LinkedList is a List implementation that recreates a LinkedList classic Structure, using a pointer to reference the next element.
 * The first element is going to represent the object itself but not the head, as the first ListData is always going to null (otherwise that wouldn't be no way to delete the head)
 * 
 * @author SalvatoreCardali
 *
 */
public class LinkedList implements List {
	private Object ListData;
	private LinkedList pointer;
	private int size;
	
	/**
	 * Constructor
	 */
	public LinkedList() {
		this.size = 0;
	}
	
	@Override
	/**
	 * see @inheritDoc
	 */
	public boolean isEmpty() {
		return (this.size == 0) ? true : false; 		
	}

	@Override
	/**
	 * see @inheritDoc
	 */
	public int size() {
		return this.size;
	}

	@Override
	/**
	 * see @inheritDoc
	 */
	public ReturnObject get(int index) {
		if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			Object returnvalue = null;
			LinkedList tempList = this.pointer;
			for(int i = 0; i < this.size(); i++) {
				if(i == index)
				{
					returnvalue = tempList.ListData;
				}
				else {
					tempList = tempList.pointer;
				}
			}
			return new ReturnObjectImpl(returnvalue);
		}
	}

	@Override
	/**
	 * see @inheritDoc
	 */
	public ReturnObject remove(int index) {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); //if someone tries to remove something from an empty list
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			Object returnvalue = null;
			LinkedList tempList = this;		
			for(int i = 0; i < this.size(); i++) {
				if(i == index)
				{
					returnvalue = tempList.pointer.ListData;
					tempList.pointer = tempList.pointer.pointer;
					break;
				}
				tempList = tempList.pointer;
			}	
			this.size--;
			return new ReturnObjectImpl(returnvalue);
		}
	}

	@Override
	/**
	 * see @inheritDoc
	 */
	public ReturnObject add(int index, Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			LinkedList tempList = this;
			for(int i = 0; i < this.size(); i++) {
				if(i == index)
				{
					LinkedList newObject = new LinkedList();
					newObject.ListData = item;
					newObject.pointer = tempList.pointer;
					tempList.pointer = newObject; 
					break;
				}
				tempList = tempList.pointer;
			}
			this.size++;
		}
		return new ReturnObjectImpl(null);
	}

	@Override
	/**
	 * see @inheritDoc
	 */
	public ReturnObject add(Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			LinkedList tempList = this;
			while(tempList.pointer != null) {
				tempList = tempList.pointer;
			}
			LinkedList newObject = new LinkedList();
			newObject.ListData = item;
			tempList.pointer = newObject;
			this.size++;
		}
		return new ReturnObjectImpl(null);
	}
	
}
