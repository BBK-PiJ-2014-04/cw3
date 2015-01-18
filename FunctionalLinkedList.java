package cw3;

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	@Override
	public ReturnObject head() {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		else {
			return new ReturnObjectImpl(this.get(0));
		}
	}

	@Override
	public FunctionalList rest() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
