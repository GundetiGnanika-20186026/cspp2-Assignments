import java.util.Scanner;
/** to find the power. **/
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
       * @param args this is the constructor.
    **/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    /**
    * @param base a is a variable
      @param exponent a is a variable
      @return a number
    **/
    static long power(final int base, final int exponent) {
    /**
     * my fuction to calculate power.
    **/
        if (exponent == 0) {
            return 1;
        } else {
        return base * power(base, exponent - 1);
        }

    }
}

