
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.*;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0;i<=n;i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	static String binaryToDecimal(final String s) {
        int sum = 0;
        for (int i = 0 ,j = s.length() - 1; i < s.length(); i++, j--) {
        	char val = s.charAt(i);
        	String was =Character.toString(val);
        	int k = Integer.parseInt(was);
        	sum += k * Math.pow(2, s.indexOf(j));

        }
        String result = Integer.toString(sum);
        return result;
	}

}
