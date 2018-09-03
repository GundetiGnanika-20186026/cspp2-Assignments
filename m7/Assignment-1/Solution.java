import java.util.*;
class InputValidator
{
	String data;
	int length;
    InputValidator(String input){
		data = input;
		length = input.length();
	}
    public  boolean validateData() {
		if (length >= 6) {
			return true;
		} else {
			return false;
		}
    }
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
