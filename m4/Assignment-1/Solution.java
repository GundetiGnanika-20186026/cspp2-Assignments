import java.util.Scanner;
/**
 * finding the max element in an array.
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
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr;
        int max = 0;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
        }
}

