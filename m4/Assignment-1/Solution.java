
import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[];
		int max = 0;
		arr = new int[size];
		for (int i=0; i < size; i++) { 
			arr[i] = sc.nextInt();
			if (max < arr[i]) max=arr[i];
        }
        System.out.println(max);
		  
        
	}
}
