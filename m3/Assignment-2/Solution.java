
import java.util.Scanner;
/*
    Do not modify this main function.
    */
class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++) {
            int num = i;
            final int ten = 10;
            final int seven = 7;
            while(num != 0) {
            if ((num % ten) == seven) {
             count = count + 1;
            }

            num = num / ten;
            }

        }
        System.out.println(count);
    }
}