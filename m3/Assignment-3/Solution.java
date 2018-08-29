
import java.util.Scanner;
/*
    Do not modify this main function.
    */
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
     * @brief [brief description]
     * @details [long description]
     * 
     * @param String [description]
     */

    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * 
     * @param int [description]
     * @param int [description]
     * 
     * @return [description]
     */
    
    static int gcd(final int n1, final int n2) {
        int a = n1;
        int b = n2;
        if (a < b) {
            int temp = b;
            b = n1;
            a = temp;
        }
        if (a > b) {

            int rem = 1;
            while (rem != 0) {
                int quo = a / b;
                    rem = a % b;
                a = b;
                b = rem;
            }
        }
        return a;

        }


    }

