package cw3;

public class LinkedList implements List {
	private Object Listdata;
	private LinkedList pointer;
	
	@Override
	public boolean isEmpty() {
		return (Listdata == null && pointer == null) ? true : false; // I'm doing a workaround of the head of the list problem, by nullifying his object value (just the head)		
	}

	@Override
	public int size() {
		int size = 0;
		LinkedList tempList;
		if(!isEmpty()) {
			tempList = this;
			if(tempList.Listdata == null && tempList.pointer != null) {
				do {
					size++;
					tempList = pointer;
				} while(tempList != null);
			}
		}
		return size;
		
	}

	@Override
	public ReturnObject get(int index) {
		if(index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			Object returnvalue = null;
			if(index == 0) {
				return (this.Listdata == null) ? new ReturnObjectImpl(pointer.Listdata) : new ReturnObjectImpl(this.Listdata);
				//I will not use the head as part of the list, virtually it will be excluded, by nullifying his Listdata
			}
			else {
				LinkedList tempList = this;
				int i = -1; //As the head ListData has been nullified, we set the counter to -1 so virtually the 0 will be the "actual" head, the first pointer
				while(i <= index) {
					if(i == index)
					{
						returnvalue = new ReturnObjectImpl(tempList.Listdata);
					}
					tempList = pointer;
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
			if(index == 0) {
				return new ReturnObjectImpl(pointer.Listdata);
				//if the requested index is zero, it is the value on the pointer of the head.
			}
			else {
				LinkedList tempList = this;
				int i = -1; //As the head ListData has been nullified, we set the counter to -1 so virtually the 0 will be the "actual" head, the first pointer
				while(i <= index) {
					if(i == index)
					{
						returnvalue = new ReturnObjectImpl(tempList.Listdata);
					}
					tempList = pointer;
				}
			}
			return new ReturnObjectImpl(returnvalue);
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
