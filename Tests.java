package cw3;

public class Tests {
	public static void main(String [] args)
	{
		//Object[] myarray = new Object[100];
		//System.out.print(myarray[2]); //testing if returns null with no errors
		
		ArrayList mylist = new ArrayList();
		if(!mylist.isEmpty()) System.out.print("The isEmpty method did not pass the test");
	}
	
	public boolean test(String item1, String item2)
	{
		if(item1.equals(item2)) {
			return true;
		}
		return false;
	}
	
	public boolean test(int item1, int item2)
	{
		if(item1 == item2) {
			return true;
		}
		return false;
	}
	
	//ArrayList tests
	
}
