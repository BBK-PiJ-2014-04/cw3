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
		for(int i = 1; i < this.size(); i++) {
			mynewList.add(this.get(i).getReturnValue());
		}
		return mynewList;
	}

	

}
