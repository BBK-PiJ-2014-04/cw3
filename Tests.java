package cw3;

public class Tests {
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

		if(!test(mylist.size(),0)) System.out.println("The size method did not pass the test");
		if(!mylist.isEmpty()) System.out.println("The isEmpty method did not pass the test");
		if(!test(mylist.add(0, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS)) System.out.println("The method add(index,item) did not pass the test(it shouldn't be used to insert the first element of the list)");
		test(mylist.add(-2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(m).getError(),ErrorMessage.NO_ERROR);
		test(mylist.add(2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(2, integTest).getError(),ErrorMessage.INVALID_ARGUMENT);
		if(!test(mylist.size(),1)) System.out.println("The size method did not pass the test");
		test(mylist.add(m+3).getError(),ErrorMessage.NO_ERROR); //this should test the resize (for when the length of the array will be set to 2)
		test(mylist.add(stringTest).getError(),ErrorMessage.NO_ERROR); //this should test if we can put different types of object on the array
		test(mylist.add(0,stringTest).getError(),ErrorMessage.NO_ERROR);
		/*test(mylist.remove(0).getError(),ErrorMessage.NO_ERROR);
		test(mylist.remove(3).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.remove(1).getError(),ErrorMessage.NO_ERROR);*/
		if(!test(mylist.head().getReturnValue().toString(),"test")) System.out.println("The head method did not pass the test");
		FunctionalList FunctionalNewList = mylist.rest();
		
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
		System.out.println(String.format("Rest List size:{0}", FunctionalNewList.size()));
		
		System.out.println("");
		FunctionalNewList.remove(1);
		System.out.println("Modified Rest List");
		for(int i = 0; i < FunctionalNewList.size(); i++) {
			System.out.println(FunctionalNewList.get(i).getReturnValue());
		}
		
		System.out.println(String.format("Modified Rest List size:{0}", FunctionalNewList.size()));
		
		System.out.println("");
		System.out.println("Checking Original List Again");
		for(int i = 0; i < mylist.size(); i++) {
			System.out.println(mylist.get(i).getReturnValue());
		}
		
		System.out.println(String.format("Original List size:{0}", FunctionalNewList.size()));
		
		//System.out.println(mylinkedlist.isEmpty());
		//System.out.println(mylinkedlist.size());
		
		
	}
	
	
	private static boolean test(String item1, String item2)
	{
		if(item1.equals(item2)) {
			return true;
		}
		return false;
	}
	
	private static boolean test(int item1, int item2)
	{
		if(item1 == item2) {
			return true;
		}
		return false;
	}
	
	private static boolean test(ErrorMessage errorGenerated, ErrorMessage errorExpected) {
		if(errorGenerated.equals(errorExpected)) {
			return true;
		}
		return false;
	}
	//ArrayList tests
	
}
