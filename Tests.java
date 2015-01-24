package cw3;

/**
 * The Class Tests.
 */
public class Tests {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args)
	{
		//Object[] myarray = new Object[100];
		//System.out.print(myarray[2]); //testing if returns null with no errors
		
		
		System.out.println("Welcome to the test area");
		//List mylist = new ArrayList();
		//List mylist = new LinkedList();
		//FunctionalList mylist = new FunctionalArrayList();
		FunctionalList mylist = new FunctionalLinkedList();
		int m = 5;
		String stringTest = "test";
		Integer integTest = null;

		if(mylist.size()==0) System.out.println("The size method did not pass the test");
		if(!mylist.isEmpty()) System.out.println("The isEmpty method did not pass the test");
		if(!test(mylist.add(0, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS)) System.out.println("The method add(index,item) did not pass the test(it shouldn't be used to insert the first element of the list)");
		test(mylist.add(-2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(m).getError(),ErrorMessage.NO_ERROR);
		test(mylist.add(2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(2, integTest).getError(),ErrorMessage.INVALID_ARGUMENT);
		if(mylist.size() == 1) System.out.println("The size method did not pass the test");
		test(mylist.add(m+3).getError(),ErrorMessage.NO_ERROR); //this should test the resize (for when the length of the array will be set to 2)
		test(mylist.add(stringTest).getError(),ErrorMessage.NO_ERROR); //this should test if we can put different types of object on the array
		test(mylist.add(0,stringTest).getError(),ErrorMessage.NO_ERROR);
		/*test(mylist.remove(0).getError(),ErrorMessage.NO_ERROR);
		test(mylist.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.remove(1).getError(),ErrorMessage.NO_ERROR);*/
		if(!test(mylist.head().getReturnValue().toString(),"test")) System.out.println("The head method did not pass the test");
		System.out.printf("The head is %s",mylist.head().getReturnValue().toString(),"test");
		FunctionalList FunctionalNewList = mylist.rest();
		
		//Add here the tests for SampleableList.
		//Add here the tests for StackImpl
		//Add here the tests for ImprovedStackImpl
		
		System.out.println("");
		
		System.out.println("Original List");
		for(int i = 0; i < mylist.size(); i++) {
			System.out.println(mylist.get(i).getReturnValue());
		}
		
		System.out.println("");
		System.out.println("Rest List");
		for(int i = 0; i < FunctionalNewList.size(); i++) {
			System.out.println(FunctionalNewList.get(i).getReturnValue());
		}
		System.out.printf("Rest List size: %d", FunctionalNewList.size());
		
		System.out.println("");
		FunctionalNewList.remove(1);
		System.out.println("Modified Rest List");
		for(int i = 0; i < FunctionalNewList.size(); i++) {
			System.out.println(FunctionalNewList.get(i).getReturnValue());
		}
		
		System.out.printf("Modified Rest List size: %d", FunctionalNewList.size());
		
		System.out.println("");
		System.out.println("Checking Original List Again");
		for(int i = 0; i < mylist.size(); i++) {
			System.out.println(mylist.get(i).getReturnValue());
		}
		
		System.out.printf("Original List size: %d", mylist.size());
		
		//System.out.println(mylinkedlist.isEmpty());
		//System.out.println(mylinkedlist.size());
		
		
	}
	
	
	/**
	 * Tests if two strings are the same
	 *
	 * @param item1 the Original String
	 * @param item2 the Compared STring
	 * @return true, if successful, otherwise false
	 */
	private static boolean test(String item1, String item2)
	{
		if(item1.equals(item2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Tests if the Error Generated is the error that we were expecting
	 *
	 * @param errorGenerated the error generated
	 * @param errorExpected the error expected
	 * @return true, if successful
	 */
	private static boolean test(ErrorMessage errorGenerated, ErrorMessage errorExpected) {
		if(errorGenerated.equals(errorExpected)) {
			return true;
		}
		return false;
	}
	
}
