import java.util.Scanner;
/**
 * class to check wether the input is valid or not.
 */
class InputValidator {
    private String data;
    private int length;
    /**
     * @param String [description]
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
final class Solution {
    private Solution() { }

    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
