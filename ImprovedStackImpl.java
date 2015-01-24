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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub
		
	}

}
