package cw3;

public class Tests {
	public static void main(String [] args)
	{
		//Object[] myarray = new Object[100];
		//System.out.print(myarray[2]); //testing if returns null with no errors
		
		
		System.out.print("Welcome to the test area");
		ArrayList mylist = new ArrayList();
		int m = 5;
		String stringTest = "test";
		Integer integTest = null;
		
		if(!test(mylist.size(),0)) System.out.print("The size method did not pass the test");
		if(!mylist.isEmpty()) System.out.print("The isEmpty method did not pass the test");
		test(mylist.add(-2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(m).getError(),ErrorMessage.NO_ERROR);
		test(mylist.add(2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(2, integTest).getError(),ErrorMessage.INVALID_ARGUMENT);
		if(!test(mylist.size(),1)) System.out.print("The size method did not pass the test");
		test(mylist.add(m+3).getError(),ErrorMessage.NO_ERROR); //this should test the resize (for when the length of the array will be set to 2)
		test(mylist.add(stringTest).getError(),ErrorMessage.NO_ERROR); //this should test if we can put different types of object on the array
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
