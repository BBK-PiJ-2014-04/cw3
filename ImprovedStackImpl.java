package cw3;

public class ImprovedStackImpl implements ImprovedStack {
	
	private List myStack;
	
	public ImprovedStackImpl() {
		this.myStack = new LinkedList();
	}
	
	@Override
	public boolean isEmpty() {
		return this.myStack.isEmpty();
	}

	@Override
	public int size() {
		return this.myStack.size();
	}

	@Override
	public void push(Object item) {
		if(item != null) {
			this.myStack.add(item);
		} //No return type, so if a null is passed as item, the program won't do anything
	}

	@Override
	public ReturnObject top() {
		if(this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); 
			//no top() on an empty list. 
		}
		else {
			return new ReturnObjectImpl(this.myStack.get(size()-1).getReturnValue());
		}
	}

	@Override
	public ReturnObject pop() {
		ReturnObject Popped = top(); //I rather use the top method and do not replicate code.
		if(Popped.getError() == ErrorMessage.NO_ERROR) {
			this.myStack.remove(size()-1);
		}
		return Popped;
	}

	@Override
	public ImprovedStack reverse() {
		ImprovedStack ReversedStack = new ImprovedStackImpl();
		//the idea is to push elements in the new stack starting from the top of the old stack.
		for(int i = 0; i < this.size(); i++) {
			ReversedStack.push(this.myStack.get(i).getReturnValue());
		}
		return ReversedStack;
	}

	@Override
	public void remove(Object object) {
		if(object != null) {
			ReturnObject currentElement = null;
			for(int i = 0; i < this.size(); i++) {
				currentElement = this.myStack.get(i);
				if(!currentElement.hasError() //We shouldn't have any error, but better to be safe than sorry
						&& (object.equals(currentElement.getReturnValue())) 
						) {
					this.myStack.remove(i);
				}
			}
		}
	}
	
	public Stack CloneStack() {
		Stack ClonedStack = new ImprovedStackImpl();
		for(int i = this.size(); i > 0; i--) {
			ClonedStack.push(this.myStack.get(i-1).getReturnValue());
		}
		return ClonedStack;
	}

}
