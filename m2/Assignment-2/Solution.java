import java.util.Scanner;
/** code to find quadratic. **/
final class Solution {
    /**
      *  Do not modify this main function.
    **/
    private Solution() { }
    /**
       * @param args this is the constructor.
    **/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
    /**
    * @param a a is a variable
     @param b a is a variable
      @param c a is a variable
      @return a number
     * Need to write the rootsOfQuadraticEquation function.
    **/
    static double roots(final int a, final int b, final int c) {
    /**
     * my fuction to calculate roots.
    **/
    final int four = 4;
        double value = (b * b) - (four * a * c);
        double r1 = (-b + Math.sqrt(value)) / (2 * a);
        double r2 = (-b - Math.sqrt(value)) / (2 * a);
        System.out.println(r1 + " " + r2);
        return 0;
    }
}





