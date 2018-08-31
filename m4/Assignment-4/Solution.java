import java.util.Scanner;
/**
* Given an String, We need to covrert to reverse.
**/
final class Solution {
    /**
     * constructor.
     */
    private Solution() { }
    /**
     * @param args [main method args]
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * @param s [sending a string s]
     * @return [description]
     */
    static String reverseString(final String s) {
        String rev = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += (s.charAt(i));
        }
        return rev;
    }

}
