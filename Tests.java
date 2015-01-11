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
		int prevSize = 0;
		int successSize = 0;
		System.out.print(mylist.size());
		
		//if(!test(mylist.size(),0)) System.out.print("The size method did not pass the test"); else prevSize = mylist.size();
		/*if(!mylist.isEmpty()) System.out.print("The isEmpty method did not pass the test");
		test(mylist.add(-2, m).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(m).getError(),ErrorMessage.NO_ERROR);
		test(mylist.add(2, stringTest).getError(),ErrorMessage.INDEX_OUT_OF_BOUNDS);
		test(mylist.add(2, integTest).getError(),ErrorMessage.INVALID_ARGUMENT);
		if(!test(mylist.size(),1)) System.out.print("The size method did not pass the test"); else successSize = mylist.size();
		*/
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
