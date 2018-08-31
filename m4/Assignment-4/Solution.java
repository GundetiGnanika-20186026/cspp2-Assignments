
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
final class Solution {
    /*
	Do not modify the main function 
	*/
	public static void main(final String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function
	static String reverseString(final String s){
		String rev = new String();
		for(int i = s.length()-1; i >= 0; i--) {
			rev += (s.charAt(i));
		}
		return rev;
	}

}
