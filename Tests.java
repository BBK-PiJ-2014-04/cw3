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
		/*FunctionalList mylist = new FunctionalLinkedList();
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
		//System.out.println(mylinkedlist.size());*/
		ArrayList mylist = new ArrayList();
		mylist.add("Hello");
		mylist.add("My name is Salvo");
		mylist.add("Nice to meet you");
		System.out.println(mylist.getList());
		
	}
	
	private static boolean UnitTestFunctionalMethods(FunctionalList myList,Object firstElement, Object secondElement, Object thirdElement, Object fourthElement) {
		String ErrorString = "";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		if(test(myList.get(1).getReturnValue(),firstElement))
			ErrorString += "Test MainMethods 1 Failed";
		if(!test(myList.head(),secondElement))
			ErrorString += "Test FunctionalMethods 2 Failed";
		FunctionalList restList = myList.rest();
		for(int i = 0; i < restList.size(); i++) {
			if(!test(restList.get(i).getReturnValue(),myList.get(i+1).getReturnValue()))
				ErrorString += "Test FunctionalMethods 3 Failed";
		}
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean UnitTestMainMethods(List mylist,Object firstElement, Object secondElement, Object thirdElement, Object fourthElement) {
		String ErrorString = "";
		mylist.add(firstElement);
		mylist.add(secondElement);
		mylist.add(thirdElement);
		mylist.remove(1);
		mylist.add(1,fourthElement);
		if(!test(mylist.get(0).getReturnValue(),firstElement))
			ErrorString = "Test MainMethods 1 Failed";
		if(!test(mylist.get(1).getReturnValue(),fourthElement))
			ErrorString = "Test MainMethods 2 Failed";
		if(!test(mylist.get(2).getReturnValue(),thirdElement))
			ErrorString = "Test MainMethods 3 Failed";
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean UnitTestErrorMessages(List myList, Object firstElement, Object secondElement, Object thirdElement, Object fourthElement)
	{
		String ErrorString = "";
		if(myList.size()!=0) 
			ErrorString += "Test ErrorMessage 1 failed\n";
		if(!myList.isEmpty()) 
			ErrorString += "Test ErrorMessage 2 failed\n";
		if(!test(myList.add(0, firstElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS)) 
			ErrorString += "Test ErrorMessage 3 failed\n";
		if(!test(myList.add(-2, firstElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test ErrorMessage 4 failed\n";
		if(test(myList.add(firstElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 5 failed\n";
		if(test(myList.add(2, secondElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test ErrorMessage 6 failed\n";
		if(test(myList.add(2, secondElement).getError(),ErrorMessage.INVALID_ARGUMENT))
			ErrorString += "Test ErrorMessage 7 failed\n";
		if(myList.size() == 1) 
			ErrorString += "Test ErrorMessage 8 failed\n";
		if(test(myList.add(thirdElement).getError(),ErrorMessage.NO_ERROR)) //this should tests the resize (for when the initial length of the array (on ArrayList) was set to 2)
			ErrorString += "Test ErrorMessage 9 failed\n";
		if(test(myList.add(fourthElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 10 failed\n";
		if(test(myList.add(0,fourthElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 11 failed\n";
		if(test(myList.remove(0).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 12 failed\n";
		if(test(myList.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test ErrorMessage 13 failed\n";
		if(test(myList.remove(1).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 14 failed\n";
		System.out.println((ErrorString != "") ? ErrorString : "All the tests have been successful");
		return (ErrorString != "") ? false : true;
	}
	
	
	/**
	 * Tests if two strings are the same
	 *
	 * @param item1 the Original Object
	 * @param item2 the Compared Object
	 * @return true, if successful, otherwise false
	 */
	private static boolean test(Object item1, Object item2)
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