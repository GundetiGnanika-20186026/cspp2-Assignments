import java.util.*;
public class Solution {
    /* Fill the main function to print resultant of addition of matrices*/
    public static void main(String[] args) {
        int[][] arr1;
        int[][] arr2;
        Scanner scn = new Scanner(System.in);
        int size1 = scn.nextInt();
        int size2 = scn.nextInt();
        arr1 = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < arr1[i].length; j++){
                arr1[i][j] = scn.nextInt();
            }
        }
        int size11 = scn.nextInt();
        int size22 = scn.nextInt();
        arr2 = new int[size11][size22];
        for (int i = 0; i < size11; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }
        if ((size1 != size11) || (size2 != size22)) {
         System.out.println("not possible");
        }
        else {
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        for (int i = 0; i < size11; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j]);
                if (j == 0 || j == 1) { 
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    }
}