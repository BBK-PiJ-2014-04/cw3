package cw3;

/**
 * FunctionalArrayList extends the ArrayList class, so it's using that as underlying structure {@see ArrayList}
 * 
 * @author SalvatoreCardali
 *
 */

public class FunctionalArrayList extends ArrayList implements FunctionalList {

	/**
	 * see @inheritDoc
	 */
	@Override	
	public ReturnObject head() {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		else {
			return new ReturnObjectImpl(myarray[0]);
		}
	}
	
	/**
	 * see @inheritDoc
	 */
	@Override
	public FunctionalList rest() {
		FunctionalArrayList mynewList = new FunctionalArrayList();
		for(int i = 1; i < this.size(); i++) {
			mynewList.add(this.get(i).getReturnValue());
		}
		return mynewList;
	}

	

}
