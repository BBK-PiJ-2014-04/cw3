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
		// TODO Auto-generated method stub
		return 0;
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
	
	

}
