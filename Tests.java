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
	
	private static boolean UnitTestErrorMessages(List myList, Object firstElement, Object secondElement, Object thirdElement, Object fourthElement)
	{
		String ErrorString = "";
		if(myList.size()!=0) 
			ErrorString += "Test 1 failed\n";
		if(!myList.isEmpty()) 
			ErrorString += "Test 2 failed\n";
	
		if(!test(myList.add(0, firstElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS)) 
			ErrorString += "Test 3 failed\n";
		if(!test(myList.add(-2, firstElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test 4 failed\n";
		if(test(myList.add(firstElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 5 failed\n";
		if(test(myList.add(2, secondElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test 6 failed\n";
		if(test(myList.add(2, secondElement).getError(),ErrorMessage.INVALID_ARGUMENT))
			ErrorString += "Test 7 failed\n";
		if(myList.size() == 1) 
			ErrorString += "Test 8 failed\n";
		if(test(myList.add(thirdElement).getError(),ErrorMessage.NO_ERROR)) //this should tests the resize (for when the initial length of the array (on ArrayList) was set to 2)
			ErrorString += "Test 9 failed\n";
		if(test(myList.add(fourthElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 10 failed\n";
		if(test(myList.add(0,fourthElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 11 failed\n";
		if(test(myList.remove(0).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test 12 failed\n";
		if(test(myList.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test 13 failed\n";
		if(test(myList.remove(1).getError(),ErrorMessage.NO_ERROR))
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