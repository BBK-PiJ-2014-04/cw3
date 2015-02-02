package cw3;

/**
 * SampleableList has an extra-method (sample) to the List {@see List} interface.
 * It extends the LinkedList. 
 * 
 * @author SalvatoreCardali
 *
 */

public class SampleableListImpl extends LinkedList implements SampleableList {
	//no point of rewriting all the methods, better to extend the class LinkedList
	
	
	@Override
	public SampleableList sample() {
		SampleableList mySampledList = new SampleableListImpl();
		for(int i = 0; i < this.size(); i++) {
			if(i % 2 == 0) { //Module operation used to determine whether the number is odd or not.
				mySampledList.add(this.get(i).getReturnValue());
			}
		}
		return mySampledList;
	}

}
