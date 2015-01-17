package cw3;

public class LinkedList implements List {
	private Object ListData;
	private LinkedList pointer;
	private int size;
	
	public LinkedList(Object ListData) {
		this.ListData = ListData;
		this.size = 0;
	}
	
	@Override
	
	public boolean isEmpty() {
		return (this.size == 0) ? true : false; 		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
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
					returnvalue = new ReturnObjectImpl(tempList.ListData);
				}
				else {
					tempList = tempList.pointer;
				}
			}
			return new ReturnObjectImpl(returnvalue);
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if(size() == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); //if someone tries to remove something from an empty list
		}
		else if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			Object returnvalue = null;
			LinkedList tempList = this.pointer;			
			for(int i = 0; i < this.size(); i++) {
				if(i == index)
				{
					returnvalue = new ReturnObjectImpl(tempList.ListData);
				}
				tempList = tempList.pointer;
			}	
			this.size--;
			return new ReturnObjectImpl(returnvalue);
		}
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
			LinkedList tempList = this;
			for(int i = 0; i < this.size(); i++) {
				if(i == index)
				{
					LinkedList newObject = new LinkedList(item);
					newObject.pointer = tempList.pointer;
					tempList.pointer = newObject; 
				}
				tempList = tempList.pointer;
			}
			this.size++;
		}
		return new ReturnObjectImpl(null);
	}

	@Override
	public ReturnObject add(Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			LinkedList tempList = this;
			while(tempList.pointer != null) {
				tempList = tempList.pointer;
			}
			LinkedList newObject = new LinkedList(item);
			tempList.pointer = newObject;
			this.size++;
		}
		return new ReturnObjectImpl(null);
	}
	
}
