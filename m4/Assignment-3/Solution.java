import java.util.Scanner;
/**
 * converting binary to decimal.
 */
final class Solution {
	/**
	 * @constructor.
	 */
	private Solution() { }
	/**
	 * @param args [description]
	*/
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);
			System.out.println(res);
		}
	}
	/**
	 * @param s [passing string as a parameter]
	 * @return [ a string in form of decimal ]
	 */
	static String binaryToDecimal(final String s) {
        int sum = 0;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
        	char val = s.charAt(i);
        	String was = Character.toString(val);
        	int k = Integer.parseInt(was);
        	sum += k * Math.pow(2, j);
        }
        String result = Integer.toString(sum);
        return result;
	}

}
