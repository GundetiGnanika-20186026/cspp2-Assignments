import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author :Gnanika.
 */
class Set {
    /**
     * set array.
     */
    private int[] set;
    /**
     * size declaration.
     */
    private int size;
    /**
     * constructor.
     */
    protected Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }
    /**
     * @param capacity [parameterised constructor]
    */
    protected Set(final int capacity) {
        set = new int[capacity];
        size = 0;
    }
    /**
     * @return size of the set
     */
    public int size() {
        return size;
    }
    /**
     * resize method.
     */
    public void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**
     * @param item [add method]
     */
    public void add(final int item) {
        if (size == set.length) {
            resize();
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                count++;
            }
        }
        if (count == 0) {
            set[size++] = item;
        }
    }
    /**
     * @param items [adding array of items to set]
     */
    public void add(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**
     * @return [string of set elements]
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String res = "{";
        for (int i = 0; i < size - 1; i++) {
            res = res + set[i] + ", ";
        }
        return res + set[size - 1] + "}";
    }
    /**
     * @param item [the value]
     * @return [boolean]
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * @param set1 [which is a object]
     * @return [ the set]
     */
    public Set intersection(final Set set1) {
        Set setres = new Set(set1.size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < set1.size; j++) {
                if (set1.set[j] == set[i]) {
                    setres.add(set[i]);
                }
            }
        }
        return setres;
    }
    /**
     * @param items [description]
     * @return [set]
     */
    public Set  retainAll(final int[] items) {
        Set setres = new Set(items.length);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[j] == set[i]) {
                    setres.add(set[i]);
                }
            }
        }
        return setres;
    }
    /**
     * @param items [description]
     * @return [description]
     */
    public int[][] cartesianProduct(final Set items) {
        if (size == 0) {
            return null;
        }
        int arr[][] = new int [size][items.set.length];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items.set.length; j++) {
                String str = "[";
                str = str + set[i] + ", " + items.set[j] + "]";
                arr[i][j] = Integer.parseInt(str);
            }

        }
        return arr;

    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the
            // corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
