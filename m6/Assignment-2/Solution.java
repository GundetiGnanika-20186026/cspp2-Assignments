import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows,
                                final int columns) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int fifty = 50;
                final int hun1 = 100;
                final int hun2 = 200;
                final int hun3 = 300;
                final int hun4 = 400;
                final int hun5 = 500;
                final int onefifty = 150;
                final int twofifty = 250;
                final int threefifty = 350;
                final int fourfifty = 450;
                final int fivefifty = 550;
                if ((a[i][j] > 0) && (a[i][j] < fifty)) a[i][j] = 0;
                if ((a[i][j] >= fifty) && (a[i][j] < onefifty)) {
                    a[i][j] = hun1;
                }
                if ((a[i][j] >= onefifty) && (a[i][j] < twofifty)) {
                    a[i][j] = hun2;
                }
                if ((a[i][j] >= twofifty) && (a[i][j] < threefifty)) {
                    a[i][j] = hun3;
                }
                if ((a[i][j] >= threefifty) && (a[i][j] < fourfifty)) {
                    a[i][j] = hun4;
                }
                if ((a[i][j] >= fourfifty) && (a[i][j] < fivefifty)) {
                    a[i][j] = hun5;
                }
            }
        }
        return a;

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
