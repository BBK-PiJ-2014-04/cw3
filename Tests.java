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
		System.out.println("Welcome to the test area");
		
	}
	
	private static boolean unitTestSampleableMethods(SampleableList myList,Object firstElement, Object secondElement, Object thirdElement, Object fourthElement, Object fifthElement) {
		String ErrorString = "";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		myList.add(2,fifthElement);
		SampleableList sampledList = myList.sample();
		//In this case, I want to try and test the get method of the sampledList against the original added elements
		if(!test(sampledList.get(0).getReturnValue(),secondElement))
			ErrorString += "Test SampledMethods 1 Failed";
		if(!test(sampledList.get(1).getReturnValue(),fifthElement))
			ErrorString += "Test SampledMethods 2 Failed";
		if(!test(sampledList.get(1).getReturnValue(),thirdElement))
			ErrorString += "Test SampledMethods 3 Failed";
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestFunctionalMethods(FunctionalList myList,Object firstElement, Object secondElement, Object thirdElement, Object fourthElement) {
		String ErrorString = "";
		if(!test(myList.add(0, firstElement).getError(),ErrorMessage.EMPTY_STRUCTURE)) 
			ErrorString += "Test FunctionalMethods 1 Failed";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		if(test(myList.get(1).getReturnValue(),firstElement))
			ErrorString += "Test FunctionalMethods 2 Failed";
		if(!test(myList.head(),secondElement))
			ErrorString += "Test FunctionalMethods 3 Failed";
		FunctionalList restList = myList.rest();
		for(int i = 0; i < restList.size(); i++) {
			if(!test(restList.get(i).getReturnValue(),myList.get(i+1).getReturnValue()))
				ErrorString += "Test FunctionalMethods " + i+4 + " Failed";
		}
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestMainMethods(List myList,Object firstElement, Object secondElement, Object thirdElement, Object fourthElement) {
		String ErrorString = "";
		myList.add(firstElement);
		myList.add(secondElement);
		myList.add(thirdElement);
		myList.remove(1);
		myList.add(1,fourthElement);
		if(!test(myList.get(0).getReturnValue(),firstElement))
			ErrorString = "Test MainMethods 1 Failed";
		if(!test(myList.get(1).getReturnValue(),fourthElement))
			ErrorString = "Test MainMethods 2 Failed";
		if(!test(myList.get(2).getReturnValue(),thirdElement))
			ErrorString = "Test MainMethods 3 Failed";
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestErrorMessages(List myList, Object firstElement, Object secondElement, Object thirdElement, Object fourthElement)
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
	 * 
	 */
	private static void developmentTests() {
		//List mylist = new ArrayList();
		//List mylist = new LinkedList();
		//FunctionalList mylist = new FunctionalArrayList();
		FunctionalList mylist = new FunctionalLinkedList();
		FunctionalList FunctionalNewList = mylist.rest();
		if(!test(mylist.head().getReturnValue().toString(),"test")) System.out.println("The head method did not pass the test");
		System.out.printf("The head is %s",mylist.head().getReturnValue().toString(),"test");
		
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