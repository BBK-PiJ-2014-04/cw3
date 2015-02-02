package cw3;


/**
 * 
 * Improved version of a stack, using an underlying LinkedList instantiated when the Constructor is called
 * Added the possibility of removing an element from the Stack and reversing the Stack itself
 *
 * 
 * @author SalvatoreCardali
 *
 */
public class ImprovedStackImpl implements ImprovedStack {
	
	private List myStack;
	
	/**
	 * Constructor
	 * 
	 */
	public ImprovedStackImpl() {
		this.myStack = new LinkedList();
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public boolean isEmpty() {
		return this.myStack.isEmpty();
	}

	/**
	 * see @inheritDoc
	 */
	@Override
	public int size() {
		return this.myStack.size();
	}

	/**
	 * see @inheritDoc
	 */
	@Override
	public void push(Object item) {
		if(item != null) {
			this.myStack.add(item);
		} //No return type, so if a null is passed as item, the program won't do anything
	}

	/**
	 * see @inheritDoc
	 */
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
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public ReturnObject pop() {
		ReturnObject Popped = top(); //I rather use the top method and do not replicate code.
		if(Popped.getError() == ErrorMessage.NO_ERROR) {
			this.myStack.remove(size()-1);
		}
		return Popped;
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public ImprovedStack reverse() {
		ImprovedStack ReversedStack = new ImprovedStackImpl();
		//the idea is to push elements in the new stack starting from the top of the old stack.
		for(int i = 0; i < this.size(); i++) {
			ReversedStack.push(this.myStack.get(i).getReturnValue());
		}
		return ReversedStack;
	}
	
	/**
	 * see @inheritDoc
	 */
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
	
	/**
	 * Returns an exact clone of the Stack
	 * 
	 * @return a clone of the Stack 
	 */
	public Stack CloneStack() {
		Stack ClonedStack = new ImprovedStackImpl();
		for(int i = this.size(); i > 0; i--) {
			ClonedStack.push(this.myStack.get(i-1).getReturnValue());
		}
		return ClonedStack;
	}

}
