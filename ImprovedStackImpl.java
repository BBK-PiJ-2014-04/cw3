package cw3;

public class ImprovedStackImpl implements ImprovedStack {
	
	private List mystack;
	
	public ImprovedStackImpl() {
		this.mystack = new LinkedList();
	}
	
	@Override
	public boolean isEmpty() {
		return this.mystack.isEmpty();
	}

	@Override
	public int size() {
		return this.mystack.size();
	}

	@Override
	public void push(Object item) {
		if(item != null) {
			this.mystack.add(item);
		} //No return type, so if a null is passed as item, the program won't do anything
	}

	@Override
	public ReturnObject top() {
		if(this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); 
			//no top() on an empty list. 
		}
		else {
			return new ReturnObjectImpl(this.mystack.get(size()-1));
		}
	}

	@Override
	public ReturnObject pop() {
		ReturnObject Popped = top(); //I rather use the top method and do not replicate code.
		if(Popped.getError() == ErrorMessage.NO_ERROR) {
			this.mystack.remove(size()-1);
		}
		return Popped;
	}

	@Override
	public ImprovedStack reverse() {
		ImprovedStack ReversedStack = new ImprovedStackImpl();
		//the idea is to push elements in the new stack starting from the top of the old stack.
		for(int i = 0; i < this.size(); i++) {
			ReversedStack.push(this.mystack.get(i));
		}
		return ReversedStack;
	}

	@Override
	public void remove(Object object) {
		if(object != null) {
			ReturnObject currentElement = null;
			for(int i = 0; i < this.size(); i++) {
				currentElement = this.mystack.get(i);
				if(!currentElement.hasError() //We shouldn't have any error, but better to be safe than sorry
						&& (object.equals(currentElement.getReturnValue())) 
						) {
					this.mystack.remove(i);
				}
			}
		}
	}

}
