import java.util.Scanner;
//import java.util.Arrays;
/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
 /**
  * class to find the fibonacci numbers.
  */
final class Fibonacci {
    /*
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    /**
     * constructor.
     */
    private Fibonacci() { }
    /**
     * @param n [the no. of fibonnaci numbers]
     * @return [the object of list]
     */
    public static List fib(final int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        List main = new List(n);
        main.add(a);
        main.add(b);
        for (int i = 2; i < n; i++) {
            sum = a + b;
            main.add(sum);
            a = b;
            b = sum;
        }

        return main;
    }
    /**
     * @param args [an argument to the main method]
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}
