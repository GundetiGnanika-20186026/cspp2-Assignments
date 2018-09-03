import java.util.Scanner;
class InputValidator {
    String data;
    int length;
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
public class Solution {
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
