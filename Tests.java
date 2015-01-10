package cw3;

public class Tests {
	public static void main(String [] args)
	{
		//Object[] myarray = new Object[100];
		//System.out.print(myarray[2]); //testing if returns null with no errors
		
		ArrayList mylist = new ArrayList();
		int m = 5;
		String stringTest = "test";
		Integer integTest = null;
		
		if(!mylist.isEmpty()) System.out.print("The isEmpty method did not pass the test");
		test(mylist.add(-2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(m).getError(),ErrorMessage.);
		test(mylist.add(2, stringTest).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(2, integTest).getError(),ErrorMessage.INVALID_ARGUMENT);
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
