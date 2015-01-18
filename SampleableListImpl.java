package cw3;

public class SampleableListImpl extends LinkedList implements SampleableList {
	//no point of rewriting all the methods, better to extend the class LinkedList
	
	
	@Override
	public SampleableList sample() {
		SampleableList mySampledList = new SampleableListImpl();
		for(int i = 0; i < this.size(); i++) {
			
		}
		return mySampledList;
	}

}
