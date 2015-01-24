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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject pop() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
