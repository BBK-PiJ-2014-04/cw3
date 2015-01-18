package cw3;

public class FunctionalArrayList extends ArrayList implements FunctionalList {

	@Override
	public ReturnObject head() {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		else {
			return new ReturnObjectImpl(myarray[0]);
		}
	}

	@Override
	public FunctionalList rest() {
		FunctionalArrayList mynewList = new FunctionalArrayList();
		return mynewList;
	}

	

}
