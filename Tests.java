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
		FunctionalList FunctionalNewList = mylist.rest();
		if(!test(mylist.head().getReturnValue().toString(),"test")) System.out.println("The head method did not pass the test");
		System.out.printf("The head is %s",mylist.head().getReturnValue().toString(),"test");
		
		//Add here the tests for SampleableList.
		//Add here the tests for StackImpl
		//Add here the tests for ImprovedStackImpl
		
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
	
	private static boolean UnitTestMainMethods(List mylist, Object[] arrayOfElements)
	{
		String ErrorString = "";
		if(mylist.size()!=0) 
			ErrorString += "Test 1 failed\n";
		if(!mylist.isEmpty()) 
			ErrorString += "Test 2 failed\n";
		if(!test(mylist.add(0, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS)) 
			ErrorString += "Test 3 failed\n";
		if(!test(mylist.add(-2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test 4 failed\n";
		if(test(mylist.add(m).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 5 failed\n";
		if(test(mylist.add(2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test 6 failed\n";
		if(test(mylist.add(2, integTest).getError(),ErrorMessage.INVALID_ARGUMENT))
			ErrorString += "Test 7 failed\n";
		if(mylist.size() == 1) 
			ErrorString += "Test 8 failed\n";
		if(test(mylist.add(m+3).getError(),ErrorMessage.NO_ERROR)) //this should tests the resize (for when the length of the array will be set to 2)
			ErrorString += "Test 9 failed\n";
		if(test(mylist.add(stringTest).getError(),ErrorMessage.NO_ERROR)) //this should tests if we can put different types of object on the array
			ErrorString += "Test 10 failed\n";
		if(test(mylist.add(0,stringTest).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 11 failed\n";
		if(test(mylist.remove(0).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 12 failed\n";
		if(test(mylist.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test 13 failed\n";
		if(test(mylist.remove(1).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 14 failed\n";
		System.out.println((ErrorString != "") ? ErrorString : "All the tests have been successful");
		return (ErrorString != "") ? false : true;
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