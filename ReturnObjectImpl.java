package cw3;

public class ReturnObjectImpl implements ReturnObject {

	public Object myObject;
	
	public ReturnObjectImpl(Object myObject) //Constructor
	{
		this.myObject = myObject;
	}

	@Override
	public boolean hasError() {
		switch((ErrorMessage) myObject) {
		case EMPTY_STRUCTURE:
			return true;
		case INDEX_OUT_OF_BOUNDS:
			return true;
		case INVALID_ARGUMENT:
			return true;
		default:
			return false;
		}
		
	}

	@Override
	public ErrorMessage getError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getReturnValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
