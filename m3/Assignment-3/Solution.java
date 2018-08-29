
import java.util.Scanner;
/*
    Do not modify this main function.
    */
public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        
        System.out.println(gcd(n1, n2));
    }
    /*
    Need to write the gcd function and print the output.
    */
    static int gcd( int n1,  int n2) {
        if (n1 < n2) {
            int temp = n2;
            n2 = n1;
            n1 = temp;
        }
        if (n1 > n2) {

            int rem = 1;
            while (rem != 0) {
                int quo = n1 / n2;
                    rem = n1 % n2;
                n1 = n2;
                n2 = rem;
            }
        }
        return n1;

        }


    }

