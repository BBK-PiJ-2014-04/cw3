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
		if(!unitTestErrorMessages(new ArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestMainMethods(new ArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		System.out.println("ArrayList Tests - End\n");
		
		//FunctionalArrayList Test
		System.out.println("FunctionalArrayList Tests:");
		if(!unitTestErrorMessages(new FunctionalArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestMainMethods(new FunctionalArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestFunctionalMethods(new FunctionalArrayList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		System.out.println("FunctionalArrayList Tests - End\n");
		
		//FunctionalLinkedList Test
		System.out.println("FunctionalLinkedList Tests:");
		if(!unitTestErrorMessages(new FunctionalLinkedList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestMainMethods(new FunctionalLinkedList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestFunctionalMethods(new FunctionalLinkedList(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		System.out.println("FunctionalLinkedList Tests - End\n");
		
		//SampleableList Test
		System.out.println("SampleableListImpl Tests:");
		if(!unitTestErrorMessages(new SampleableListImpl(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestMainMethods(new SampleableListImpl(),FirstElement,SecondElement,thirdElement,FourthElement))
			return;
		if(!unitTestSampleableMethods(new SampleableListImpl(),FirstElement,SecondElement,thirdElement,FourthElement,FifthElement))
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
	
	private static boolean unitTestStack(Stack myStack,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement, Object fifthElement, boolean isImproved) {
		String ErrorString = "";
		int myPreviousSize = 0;
		ReturnObject MyPreviousTop = null;
		ReturnObject MyNewTop = null;
		if(myStack.size()!=0) 
			ErrorString += "Test Stack 1 failed\n";
		if(!myStack.isEmpty()) 
			ErrorString += "Test Stack 2 failed\n";
		if(!test(myStack.top().getError(),ErrorMessage.EMPTY_STRUCTURE)) 
			ErrorString += "Test Stack 3 failed\n";
		myStack.push(firstElement);
		myStack.push(secondElement);
		myStack.push(thirdElement);
		myStack.push(fourthElement);
		myStack.push(fifthElement);
		if(myStack.size()!=5) 
			ErrorString += "Test Stack 4 failed\n";
		myPreviousSize = myStack.size();
		MyPreviousTop = myStack.top();
		if(myStack.size() != myPreviousSize)
			ErrorString += "Test Stack 5 failed\n";
		MyNewTop = myStack.pop();
		if(!test(MyNewTop.getReturnValue(),MyPreviousTop.getReturnValue()))
			ErrorString += "Test Stack 6 failed\n";
		if(myStack.size() == myPreviousSize)
			ErrorString += "Test Stack 7 failed\n";
		if(test(MyNewTop.getReturnValue(),myStack.pop()))
			ErrorString += "Test Stack 8 failed\n";
		if(myStack.size() != 3)
			ErrorString += "Test Stack 9 failed\n";
		if(myStack.isEmpty())
			ErrorString += "Test Stack 10 failed\n";
		if(isImproved) {
			boolean isStillSame = true;
			ImprovedStackImpl NewStack = (ImprovedStackImpl)myStack;
			//This will create copies of the original stack on which I'm going to run my tests. Also, I will reset this condition after every test.
			ImprovedStack OriginalStack = (ImprovedStackImpl) NewStack.CloneStack();
			Stack CopiedStack = (ImprovedStackImpl)NewStack.CloneStack();
			ImprovedStack myReversedStack = new ImprovedStackImpl();
			OriginalStack.remove(null);
			if(myStack.size() != 3)
				ErrorString += "Test Stack 11 (ImprovedStack) failed\n";
			for(int i = 0; i < CopiedStack.size(); i++) {
				if(!test(CopiedStack.pop().getReturnValue(),OriginalStack.pop().getReturnValue()))
					isStillSame = false;
			}
			if(!isStillSame)
				ErrorString += "Test Stack 12 (ImprovedStack) failed\n";
			isStillSame = true;
			OriginalStack = (ImprovedStackImpl) NewStack.CloneStack();
			CopiedStack = (ImprovedStackImpl)NewStack.CloneStack();
			OriginalStack.remove("TESTTESTTEST"); //I won't put this value in the test :)
			if(myStack.size() != 3)
				ErrorString += "Test Stack 13 (ImprovedStack) failed\n";
			for(int i = 0; i < CopiedStack.size(); i++) {
				if(!test(CopiedStack.pop().getReturnValue(),OriginalStack.pop().getReturnValue()))
					isStillSame = false;
			}
			if(!isStillSame)
				ErrorString += "Test Stack 14 (ImprovedStack) failed\n";
			//now, an object that is actually on the stack
			isStillSame = true;
			OriginalStack = (ImprovedStackImpl) NewStack.CloneStack();
			CopiedStack = (ImprovedStackImpl)NewStack.CloneStack();
			OriginalStack.remove(firstElement); //I won't put this value in the test :)
			if(OriginalStack.size() != 2)
				ErrorString += "Test Stack 15 (ImprovedStack) failed\n";
			for(int i = 0; i < CopiedStack.size(); i++) {
				if(!test(CopiedStack.pop().getReturnValue(),OriginalStack.pop().getReturnValue()))
					if(i == 0) 
						isStillSame = false;
			}
			if(isStillSame)
				ErrorString += "Test Stack 16 (ImprovedStack) failed\n";
			OriginalStack = (ImprovedStackImpl) NewStack.CloneStack();
			CopiedStack = (ImprovedStackImpl)NewStack.CloneStack();
			Object[] ArrayOriginalStack = new Object[OriginalStack.size()];
			for(int i = OriginalStack.size()-1; i >= 0; i--){
				ArrayOriginalStack[i] = OriginalStack.pop();
			}
			for(int i = 0; i < myReversedStack.size(); i++){
				if(!test(ArrayOriginalStack[i],myReversedStack.pop().getReturnValue()))
					ErrorString += "Test Stack 18 (ImprovedStack) failed\n";
			}
			//I need to test what happens if I pop an empty structure, as I've got a strange Exception before
		}
		System.out.println((ErrorString != "") ? ErrorString : "All the " + ((isImproved) ? "ImprovedStack" : "Stack") + " tests have been successful");
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestSampleableMethods(SampleableList myList,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement, Object fifthElement) {
		String ErrorString = "";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		myList.add(2,fifthElement);
		SampleableList sampledList = myList.sample();
		//In this case, I want to try and test the get method of the sampledList against the original added elements
		if(!test(sampledList.get(0).getReturnValue(),secondElement))
			ErrorString += "Test SampledMethods 1 Failed\n";
		if(!test(sampledList.get(1).getReturnValue(),fifthElement))
			ErrorString += "Test SampledMethods 2 Failed\n";
		if(!test(sampledList.get(2).getReturnValue(),thirdElement))
			ErrorString += "Test SampledMethods 3 Failed\n";
		if(sampledList.size() != 3)
			ErrorString += "Test SampledMethods 4 Failed\n";
		System.out.println((ErrorString != "") ? ErrorString : "All the SampledMethods tests have been successful");
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestFunctionalMethods(FunctionalList myList,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement) {
		String ErrorString = "";
		if(!test(myList.head().getError(),ErrorMessage.EMPTY_STRUCTURE)) 
			ErrorString += "Test FunctionalMethods 1 Failed\n";
		myList.add(firstElement);
		myList.add(0,secondElement);
		myList.add(thirdElement);
		myList.add(1,fourthElement);
		if(test(myList.get(1).getReturnValue(),firstElement))
			ErrorString += "Test FunctionalMethods 2 Failed\n";
		if(!test(myList.head().getReturnValue(),secondElement))
			ErrorString += "Test FunctionalMethods 3 Failed\n";
		FunctionalList restList = myList.rest();
		for(int i = 0; i < restList.size(); i++) {
			if(!test(restList.get(i).getReturnValue(),myList.get(i+1).getReturnValue()))
				ErrorString += "Test FunctionalMethods " + i+4 + " Failed\n";
		}
		System.out.println((ErrorString != "") ? ErrorString : "All the FunctionalMethods tests have been successful");
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestMainMethods(List myList,Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement) {
		String ErrorString = "";
		myList.add(firstElement);
		myList.add(secondElement);
		myList.add(thirdElement);
		myList.remove(1);
		myList.add(1,fourthElement);
		if(!test(myList.get(0).getReturnValue(),firstElement))
			ErrorString = "Test MainMethods 1 Failed\n";
		if(!test(myList.get(1).getReturnValue(),fourthElement))
			ErrorString = "Test MainMethods 2 Failed\n";
		if(!test(myList.get(2).getReturnValue(),thirdElement))
			ErrorString = "Test MainMethods 3 Failed\n";
		System.out.println((ErrorString != "") ? ErrorString : "All the MainMethods tests have been successful");
		return (ErrorString != "") ? false : true;
	}
	
	private static boolean unitTestErrorMessages(List myList, Object firstElement, 
			Object secondElement, Object thirdElement, 
			Object fourthElement)
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
		if(!test(myList.add(firstElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 5 failed\n";
		if(!test(myList.add(2, secondElement).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test ErrorMessage 6 failed\n";
		if(test(myList.add(2, secondElement).getError(),ErrorMessage.INVALID_ARGUMENT))
			ErrorString += "Test ErrorMessage 7 failed\n";
		if(myList.size() != 1) 
			ErrorString += "Test ErrorMessage 8 failed\n";
		if(!test(myList.add(thirdElement).getError(),ErrorMessage.NO_ERROR)) //this should tests the resize (for when the initial length of the array (on ArrayList) was set to 2)
			ErrorString += "Test ErrorMessage 9 failed\n";
		if(!test(myList.add(fourthElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 10 failed\n";
		if(!test(myList.add(0,fourthElement).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 11 failed\n";
		if(!test(myList.remove(0).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 12 failed\n";
		if(!test(myList.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS))
			ErrorString += "Test ErrorMessage 13 failed\n";
		if(!test(myList.remove(1).getError(),ErrorMessage.NO_ERROR))
			ErrorString += "Test ErrorMessage 14 failed\n";
		if(!test(myList.add(null).getError(),ErrorMessage.INVALID_ARGUMENT))
			ErrorString += "Test ErrorMessage 15 failed\n";
		if(myList.size()==0) 
			ErrorString += "Test ErrorMessage 16 failed\n";
		if(myList.isEmpty()) 
			ErrorString += "Test ErrorMessage 17 failed\n";
		System.out.println((ErrorString != "") ? ErrorString : "All the ErrorMessage tests have been successful");
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