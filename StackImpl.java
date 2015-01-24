package cw3;

public class StackImpl extends AbstractStack {

	public StackImpl(List list) {
		super(list);
	}

	@Override
	public boolean isEmpty() {
		if(this.internalList != null) {
			return this.internalList.isEmpty();
		}
		else {
			return true; //I'll put true as the return type is boolean and I can't return "Empty structure" as it'd be appropriate
		}
	}

	@Override
	public int size() {
		if(this.internalList != null) {
			return this.internalList.size();
		}
		else {
			return 0;
		}
	}

	@Override
	public void push(Object item) {
		if(item != null) {
			this.internalList.add(item);
		}
		//No return type, so if the user passes a null as item, the program won't do anything
	}

	@Override
	public ReturnObject top() {
		if(this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); 
			//no top() on an empty list. 
			//This will also work when the list is null, as the size method returns 0 when the list is null
			//I've chosen this approach when the list is null as EMPTY_STRUCTURE looks the most appropriate message among the ones present on the ErrorMessage enum
		}
		else {
			return new ReturnObjectImpl(this.internalList.get(size()-1));
		}
	}

	@Override
	public ReturnObject pop() {
		ReturnObject Popped = top(); //I rather use the top method and do not replicate code.
		if(Popped.getError() == ErrorMessage.NO_ERROR) {
			this.internalList.remove(size()-1);
		}
		return Popped;
	}
	
	

}
