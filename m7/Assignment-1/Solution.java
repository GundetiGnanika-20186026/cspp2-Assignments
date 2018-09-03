import java.util.Scanner;
/**
 * class to check wether the input is valid or not.
 */
class InputValidator {
    /**
     * @param data [given data]
     */
    private String data;
    /**
     * @param length [the length of given input]
     */
    private int length;
    /**
     * @param input [the string we enter]
     */
    InputValidator(final String input) {
        data = input;
        length = input.length();
    }
    /**
     * @return [true if valid and false if not valid]
     */
    public  boolean validateData() {
        final int six = 6;
        if (length >= six) {
            return true;
        }
        return false;
    }
}
/**
 * main class.
 */
final class Solution {
    /**
     * constructor.
     */
    private Solution() { }
    /**
     * @param args [main method]
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
