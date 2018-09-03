import java.util.Scanner;
/**
 * class to check wether the input is valid or not.
 */
class InputValidator {
    /**
     * @param data [description]
     */
    private String data;
    /**
     * @param length [descripti0n]
     */
    private int length;
    /**
     * @param input [description]
     */
    InputValidator(final String input) {
        data = input;
        length = input.length();
    }
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
     * @param args [description]
     */

    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
