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
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReturnObject top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject pop() {
		// TODO Auto-generated method stub
		return null;
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
