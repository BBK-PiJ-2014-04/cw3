package cw3;

/**
 * The Test Class. Since we couldn't use external library, I've implemented my own unit test framework
 * 
 * @author SalvatoreCardali
 */
public class Tests {
	
	/**
	 * The main method. Executing the available tests for each Class developed on this project.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args)
	{		
		System.out.println("Welcome to the test area");
		System.out.println("The tests and code behind have been designed by Salvatore Cardali - Msc Computer Science");
		System.out.println("CourseWork 3\n");
		//First of all, let's write our five element of the Lists/Stacks
		List FirstElement = new ArrayList();
		FirstElement.add(0);
		FirstElement.add("Mytest");
		FirstElement.add(2.45643);
		List SecondElement = new LinkedList();
		SecondElement.add("Rock");
		SecondElement.add("Paper");
		SecondElement.add("Scissor");
		int thirdElement = 42;
		String FourthElement = "Everything I say is false";
		Stack FifthElement = new StackImpl(new LinkedList());
		FifthElement.push("Testing");
		FifthElement.push(3);
		
		//ArrayList Test
		System.out.println("ArrayList Tests:");
		if(!isEveryErrorMessageAppropriate(new ArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!isEveryElementOnRightIndexOnTheList(new ArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		System.out.println("ArrayList Tests - End\n");
		
		//FunctionalArrayList Test
		System.out.println("FunctionalArrayList Tests:");
		if(!isEveryErrorMessageAppropriate(new FunctionalArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!isEveryElementOnRightIndexOnTheList(new FunctionalArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestFunctionalMethods(new FunctionalArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		System.out.println("FunctionalArrayList Tests - End\n");
		
		//FunctionalLinkedList Test
		System.out.println("FunctionalLinkedList Tests:");
		if(!isEveryErrorMessageAppropriate(new FunctionalLinkedList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!isEveryElementOnRightIndexOnTheList(new FunctionalLinkedList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestFunctionalMethods(new FunctionalLinkedList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		System.out.println("FunctionalLinkedList Tests - End\n");
		
		//SampleableList Test
		System.out.println("SampleableListImpl Tests:");
		if(!isEveryErrorMessageAppropriate(new SampleableListImpl(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!isEveryElementOnRightIndexOnTheList(new SampleableListImpl(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!isEveryElementOnRightIndexOnTheSampleList(new SampleableListImpl(),FirstElement,SecondElement,thirdElement,FourthElement,FifthElement))
			return;
		System.out.println("SampleableListImpl Tests - End\n");
		
		
		//Stack Test
		System.out.println("Stack(both Improved and not) with LinkedList Tests:");
		if(!unitTestStack(new StackImpl(new LinkedList()),FirstElement,SecondElement,thirdElement,FourthElement,FifthElement,false))
			return;
		if(!unitTestStack(new ImprovedStackImpl(),FirstElement,SecondElement,thirdElement,FourthElement,FifthElement,true))
			return;
		System.out.println("Stack Tests - End\n");
		
		System.out.println("Stack(both Improved and not) with ArrayList Tests:");
		if(!unitTestStack(new StackImpl(new ArrayList()),FirstElement,SecondElement,thirdElement,FourthElement,FifthElement,false))
			return;
		System.out.println("Stack Tests - End\n");		
	}
	
	/**
	 * Tests the Stack and Improved Stack Functionality using:
	 * - reverseStackTest
	 * - removingElementOnTheStack
	 * - removingNonExistingValueFromTheStack 
	 * - removingNullFromTheStack
	 * - topAndPopAffectingSize
	 * - emptyStackTest
	 * A Stack can be passed as myList, however a Boolean must be passed in order to specify if the test will be performed on a ImprovedStack
	 * 
	 * 
	 * @param myList the object whose methods are going to be tested 
	 * @param firstElement object to load on myList
	 * @param secondElement object to load on myList
	 * @param thirdElement object to load on myList
	 * @param fourthElement object to load on myList
	 * @param fifthElement object to load on myList
	 * @param isImproved boolean that specifies whether the myList is an instance of Stack or ImprovedStack
	 * @return a boolean, false if the ErrorString has been filled out with something(some tests have failed)
	 *         , true if the ErrorString is empty
	 */
	public static boolean unitTestStack(Stack myStack,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement, Object fifthElement, boolean isImproved) {
		String errorString = "";
		emptyStackTest(myStack,errorString);
		myStack.push(firstElement);
		myStack.push(secondElement);
		myStack.push(thirdElement);
		myStack.push(fourthElement);
		myStack.push(fifthElement);
		ReturnObject myPreviousTop;
		int myPreviousSize = myStack.size();
		myPreviousTop = myStack.top();
		topAndPopAffectingSize(myStack, errorString, myPreviousTop, myPreviousSize);
		if(isImproved) {
			boolean isStillSame = true;
			ImprovedStackImpl newStack = (ImprovedStackImpl)myStack;
			ImprovedStack myReversedStack = new ImprovedStackImpl();
			removingNullFromTheStack(myStack, errorString,
					isStillSame, newStack);
			removingNonExistingValueFromTheStack(myStack,
					errorString, isStillSame, newStack);
			//now, an object that is actually on the stack
			removingElementOnTheStack(firstElement, errorString,
					isStillSame, newStack);
			reverseStackTest(errorString, newStack,
					myReversedStack);
		}
		System.out.println((errorString != "") ? errorString : "All the " + ((isImproved) ? "ImprovedStack" : "Stack") + " tests have been successful");
		return (errorString != "") ? false : true;
	}

	/**
	 * Testing whether the reversed Stack is really the bottom-up original Stack by using an Array as support structure
	 * 
	 * @param errorString
	 * @param newStack
	 * @param myReversedStack
	 */
	private static void reverseStackTest(String errorString,
		ImprovedStackImpl newStack, ImprovedStack myReversedStack) {
		ImprovedStack originalStack;
		originalStack = (ImprovedStackImpl) newStack.CloneStack();
		Object[] ArrayOriginalStack = new Object[originalStack.size()];
		for(int i = originalStack.size()-1; i >= 0; i--){
			ArrayOriginalStack[i] = originalStack.pop();
		}
		for(int i = 0; i < myReversedStack.size(); i++){
			if(!test(ArrayOriginalStack[i],myReversedStack.pop().getReturnValue()))
				errorString += "Test Stack 18 (ImprovedStack) failed\n";
		}		
	}

	/**
	 * Testing whether the Element is really removed from the stack by comparing the obtained stack with the original one
	 * 
	 * @param firstElement
	 * @param errorString
	 * @param isStillSame
	 * @param newStack
	 */
	private static void removingElementOnTheStack(Object firstElement,
			String errorString, boolean isStillSame, ImprovedStackImpl newStack) {
		ImprovedStack originalStack;
		Stack copiedStack;
		originalStack = (ImprovedStackImpl) newStack.CloneStack();
		copiedStack = (ImprovedStackImpl)newStack.CloneStack();
		originalStack.remove(firstElement); //I won't put this value in the test :)
		if(originalStack.size() != 2)
			errorString += "Test Stack 15 (ImprovedStack) failed\n";
		for(int i = 0; i < copiedStack.size(); i++) {
			if(!test(copiedStack.pop().getReturnValue(),originalStack.pop().getReturnValue()))
				if(i == 0) 
					isStillSame = false;
		}
		if(isStillSame)
			errorString += "Test Stack 16 (ImprovedStack) failed\n";
	}

	/**
	 * Testing whether the Stack remains unaltered when an attempt to remove an object which is not on the stack is made
	 * 
	 * @param myStack
	 * @param errorString
	 * @param isStillSame
	 * @param newStack
	 */
	private static void removingNonExistingValueFromTheStack(Stack myStack,
			String errorString, boolean isStillSame, ImprovedStackImpl newStack) {
		ImprovedStack originalStack;
		Stack copiedStack;
		originalStack = (ImprovedStackImpl) newStack.CloneStack();
		copiedStack = (ImprovedStackImpl)newStack.CloneStack();
		originalStack.remove("TESTTESTTEST"); //I won't put this value in the test :)
		if(myStack.size() != 3)
			errorString += "Test Stack 13 (ImprovedStack) failed\n";
		for(int i = 0; i < copiedStack.size(); i++) {
			if(!test(copiedStack.pop().getReturnValue(),originalStack.pop().getReturnValue()))
				isStillSame = false;
		}
		if(!isStillSame)
			errorString += "Test Stack 14 (ImprovedStack) failed\n";
	}

	/**
	 * Testing whether the Stack remains unaltered when an attempt to remove a NULL is made
	 * 
	 * @param myStack
	 * @param errorString
	 * @param isStillSame
	 * @param newStack
	 */
	private static void removingNullFromTheStack(Stack myStack,
			String errorString, boolean isStillSame, ImprovedStackImpl newStack) {
		ImprovedStack originalStack;
		Stack copiedStack;
		originalStack = (ImprovedStackImpl) newStack.CloneStack();
		copiedStack = (ImprovedStackImpl)newStack.CloneStack();
		originalStack.remove(null);
		if(myStack.size() != 3)
			errorString += "Test Stack 11 (ImprovedStack) failed\n";
		for(int i = 0; i < copiedStack.size(); i++) {
			if(!test(copiedStack.pop().getReturnValue(),originalStack.pop().getReturnValue()))
				isStillSame = false;
		}
		if(!isStillSame)
			errorString += "Test Stack 12 (ImprovedStack) failed\n";
	}
	
	/**
	 * Testing whether giving the previous top of the Stack and the previous size, top() leaves the Stack as it is and pop() removes the top
	 * 
	 * @param myStack
	 * @param errorString
	 * @param myPreviousTop
	 * @param myPreviousSize
	 */
	private static void topAndPopAffectingSize(Stack myStack,
			String errorString,ReturnObject myPreviousTop,int myPreviousSize) {
		ReturnObject myNewTop;
		if(myStack.size() != myPreviousSize)
			errorString += "Test Stack 5 failed\n";
		myNewTop = myStack.pop();
		if(!test(myNewTop.getReturnValue(),myPreviousTop.getReturnValue()))
			errorString += "Test Stack 6 failed\n";
		if(myStack.size() == myPreviousSize)
			errorString += "Test Stack 7 failed\n";
		if(test(myNewTop.getReturnValue(),myStack.pop()))
			errorString += "Test Stack 8 failed\n";
	}

	/**
	 * Testing whether the Stack is empty right after it's initialisation
	 * 
	 * @param myStack
	 * @param errorString
	 */
	private static void emptyStackTest(Stack myStack,String errorString) {
		if(myStack.size()!=0) 
			errorString += "Test Stack 1 failed\n";
		if(!myStack.isEmpty()) 
			errorString += "Test Stack 2 failed\n";
		if(!test(myStack.top().getError(),ErrorMessage.EMPTY_STRUCTURE)) 
			errorString += "Test Stack 3 failed\n";
	}
	
	/**
	 * Tests the SampleableList method sample() by comparing the resulting list with the object on the odd indexes from myList. 
	 * A SampleableList can be passed as myList
	 * 
	 * 
	 * @param myList the object whose methods are going to be tested 
	 * @param firstElement object to load on myList
	 * @param secondElement object to load on myList
	 * @param thirdElement object to load on myList
	 * @param fourthElement object to load on myList
	 * @param fifthElement object to load on myList
	 * @return a boolean, false if the ErrorString has been filled out with something(some tests have failed)
	 *         , true if the ErrorString is empty
	 */
	public static boolean isEveryElementOnRightIndexOnTheSampleList(SampleableList myList,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement, Object fifthElement) {
		String errorString = "";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		myList.add(2,fifthElement);
		SampleableList sampledList = myList.sample();
		//In this case, I want to try and test the get method of the sampledList against the original added elements
		if(!test(sampledList.get(0).getReturnValue(),secondElement))
			errorString += "Test SampledMethods 1 Failed\n";
		if(!test(sampledList.get(1).getReturnValue(),fifthElement))
			errorString += "Test SampledMethods 2 Failed\n";
		if(!test(sampledList.get(2).getReturnValue(),thirdElement))
			errorString += "Test SampledMethods 3 Failed\n";
		if(sampledList.size() != 3)
			errorString += "Test SampledMethods 4 Failed\n";
		System.out.println((errorString != "") ? errorString : "All the SampledMethods tests have been successful");
		return (errorString != "") ? false : true;
	}
	
	/**
	 * Tests the FunctionalList functionality(head(),rest()) by checking if the the resulting object is the same as the expected one (for the head() method)
	 * The rest() method is checked with the functionalListRestIsExcludingTheHead() method by comparing the resulting list with myList. 
	 * A FunctionalList can be passed as myList
	 * 
	 * 
	 * @param myList the object whose methods are going to be tested 
	 * @param firstElement object to load on myList
	 * @param secondElement object to load on myList
	 * @param thirdElement object to load on myList
	 * @param fourthElement object to load on myList
	 * @return a boolean, false if the ErrorString has been filled out with something(some tests have failed)
	 *         , true if the ErrorString is empty
	 */
	public static boolean unitTestFunctionalMethods(FunctionalList myList,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement) {
		String errorString = "";
		if(!test(myList.head().getError(),ErrorMessage.EMPTY_STRUCTURE)) 
			errorString += "Test FunctionalMethods 1 Failed\n";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		if(test(myList.get(1).getReturnValue(),firstElement))
			errorString += "Test FunctionalMethods 2 Failed\n";
		if(!test(myList.head().getReturnValue(),secondElement))
			errorString += "Test FunctionalMethods 3 Failed\n";
		functionalListRestIsExcludingTheHead(myList, errorString);
		System.out.println((errorString != "") ? errorString : "All the FunctionalMethods tests have been successful");
		return (errorString != "") ? false : true;
	}

	private static void functionalListRestIsExcludingTheHead(
		FunctionalList myList, String errorString) {
		FunctionalList restList = myList.rest();
		for(int i = 0; i < restList.size(); i++) {
			if(!test(restList.get(i).getReturnValue(),myList.get(i+1).getReturnValue()))
				errorString += "Test FunctionalMethods " + i+4 + " Failed\n";
		}
	}
	
	/**
	 * Tests the List basic functionality (add(item),add(index,item),remove(index),get(index)) by checking if the objects are loaded where expected 
	 * Any of ArrayList,LinkedList,FunctionalList and SampleableList can be passed as myList
	 * 
	 * 
	 * @param myList the object whose methods are going to be tested 
	 * @param firstElement object to load on myList
	 * @param secondElement object to load on myList
	 * @param thirdElement object to load on myList
	 * @param fourthElement object to load on myList
	 * @return a boolean, false if the ErrorString has been filled out with something(some tests have failed)
	 *         , true if the ErrorString is empty
	 */
	public static boolean isEveryElementOnRightIndexOnTheList(List myList,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement) {
		String errorString = "";
		myList.add(firstElement);
		myList.add(secondElement);
		myList.add(thirdElement);
		myList.remove(1);
		myList.add(1,fourthElement);
		if(!test(myList.get(0).getReturnValue(),firstElement))
			errorString = "Test MainMethods 1 Failed\n";
		if(!test(myList.get(1).getReturnValue(),fourthElement))
			errorString = "Test MainMethods 2 Failed\n";
		if(!test(myList.get(2).getReturnValue(),thirdElement))
			errorString = "Test MainMethods 3 Failed\n";
		System.out.println((errorString != "") ? errorString : "All the MainMethods tests have been successful");
		return (errorString != "") ? false : true;
	}
	
	
	/**
	 * Tests the List functionality by checking the ErrorMessage returned. 
	 * Any of ArrayList,LinkedList,FunctionalList and SampleableList can be passed as myList
	 * 
	 * 
	 * @param myList the object whose methods are going to be tested 
	 * @param firstElement object to load on myList
	 * @param secondElement object to load on myList
	 * @param thirdElement object to load on myList
	 * @param fourthElement object to load on myList
	 * @return a boolean, false if the ErrorString has been filled out with something(some tests have failed)
	 *         , true if the ErrorString is empty
	 */
	public static boolean isEveryErrorMessageAppropriate(List myList, Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement)
	{
		String errorString = "";
		if(myList.size()!=0) 
			errorString += "Test ErrorMessage 1 failed\n";
		if(!myList.isEmpty()) 
			errorString += "Test ErrorMessage 2 failed\n";
		if(!test(myList.add(0, firstElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS)) 
			errorString += "Test ErrorMessage 3 failed\n";
		if(!test(myList.add(-2, firstElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			errorString += "Test ErrorMessage 4 failed\n";
		if(!test(myList.add(firstElement).getError(),ErrorMessage.NO_ERROR))
			errorString += "Test ErrorMessage 5 failed\n";
		if(!test(myList.add(2, secondElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			errorString += "Test ErrorMessage 6 failed\n";
		if(test(myList.add(2, secondElement).getError(),ErrorMessage.INVALID_ARGUMENT))
			errorString += "Test ErrorMessage 7 failed\n";
		if(myList.size() != 1) 
			errorString += "Test ErrorMessage 8 failed\n";
		if(!test(myList.add(thirdElement).getError(),ErrorMessage.NO_ERROR)) //this should tests the resize (for when the initial length of the array (on ArrayList) was set to 2)
			errorString += "Test ErrorMessage 9 failed\n";
		if(!test(myList.add(fourthElement).getError(),ErrorMessage.NO_ERROR))
			errorString += "Test ErrorMessage 10 failed\n";
		if(!test(myList.add(0,fourthElement).getError(),ErrorMessage.NO_ERROR))
			errorString += "Test ErrorMessage 11 failed\n";
		if(!test(myList.remove(0).getError(),ErrorMessage.NO_ERROR))
			errorString += "Test ErrorMessage 12 failed\n";
		if(!test(myList.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			errorString += "Test ErrorMessage 13 failed\n";
		if(!test(myList.remove(1).getError(),ErrorMessage.NO_ERROR))
			errorString += "Test ErrorMessage 14 failed\n";
		if(!test(myList.add(null).getError(),ErrorMessage.INVALID_ARGUMENT))
			errorString += "Test ErrorMessage 15 failed\n";
		if(myList.size()==0) 
			errorString += "Test ErrorMessage 16 failed\n";
		if(myList.isEmpty()) 
			errorString += "Test ErrorMessage 17 failed\n";
		System.out.println((errorString != "") ? errorString : "All the ErrorMessage tests have been successful");
		return (errorString != "") ? false : true;
	}
	
	/**
	 * The tests that have been performed during the development of the code
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