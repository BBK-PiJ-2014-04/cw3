package cw3;

public class StackImpl extends AbstractStack {

	public StackImpl(List list) {
		super(list);
		//As suggested by the lecturer, 
		//we shouldn't do anything if a Null list is passed when the class is instantiated, 
		//so a NullPointerException will be thrown in that case
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public boolean isEmpty() {
		return this.internalList.isEmpty(); 
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public int size() {
		return this.internalList.size();
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public void push(Object item) {
		if(item != null) {
			this.internalList.add(item);
		}
		//No return type, so if a null is passed as item, the program won't do anything
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject top() {
		if(this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); 
			//no top() on an empty list. 
			//This will also work when the list is null, as the size method returns 0 when the list is null
			//I've chosen this approach when the list is null as EMPTY_STRUCTURE looks the most appropriate message among the ones present on the ErrorMessage enum
		}
		else {
			return new ReturnObjectImpl(this.internalList.get(size()-1).getReturnValue());
		}
	}

	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject pop() {
		ReturnObject Popped = top(); //I rather use the top method and do not replicate code.
		if(Popped.getError() == ErrorMessage.NO_ERROR) {
			this.internalList.remove(size()-1);
		}
		return Popped;
	}
	
	/**
	 * Returns an exact clone of the Stack
	 * 
	 * @return a clone of the Stack 
	 */
	public Stack CloneStack() {
		Stack ClonedStack = new StackImpl(new LinkedList());
		for(int i = this.size(); i > 0; i--) {
			ClonedStack.push(this.internalList.get(i-1).getReturnValue());
		}
		return ClonedStack;
	}
	
	

}
