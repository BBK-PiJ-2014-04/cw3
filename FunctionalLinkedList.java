package cw3;

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	@Override
	public ReturnObject head() {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		else {
			return new ReturnObjectImpl(this.get(0)); // I could have used "pointer.ListData" but in order to do it I should have changed pointer from private to protected. I rather use the get method.
		}
	}

	@Override
	public FunctionalList rest() {
		FunctionalLinkedList mynewList = new FunctionalLinkedList();
		for(int i = 1; i < this.size(); i++) {
			mynewList.add(this.get(i).getReturnValue());
		}
		return mynewList;
	}
	
}
