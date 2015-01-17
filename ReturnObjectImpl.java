package cw3;

public class ReturnObjectImpl implements ReturnObject {

	public Object myObject;
	
	public ReturnObjectImpl(Object myObject) //Constructor
	{
		this.myObject = myObject;
	}

	@Override
	public boolean hasError() {
		if(myObject == null) {
			return false; // the object can be null (f.i. when we add something to a list). In this case, no error.
		}
		return
		(myObject == ErrorMessage.EMPTY_STRUCTURE 
				|| myObject == ErrorMessage.INDEX_OUT_OF_BOUNDS 
				|| myObject == ErrorMessage.INVALID_ARGUMENT) ? true : false;
		}
		

	@Override
	public ErrorMessage getError() {
		if(hasError()) {
			return (ErrorMessage) myObject;
		}
		else {
			return ErrorMessage.NO_ERROR;
		}
	}

	@Override
	public Object getReturnValue() {
		if(hasError()) {
			return null;
		}
		else {
			return myObject;
		}
	}
	
}
