/**
 * Creates a input stream.
 */
import java.io.BufferedInputStream;
/**
 * { item_description }
 */
import java.util.Scanner;
/**
 * { item_description }
 */
import java.util.Arrays;
/**
 * @author : Gnanika
 */
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    SetEmptyException(String s) {
        super(s);
    }
}
/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**
 * Class for sortedset.
 */
class Sortedset extends Set {
    /**
     * Function to find the last element in the set.
     */
    public Sortedset() {
        super();
    }
    /**
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size() == 0) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return get(size() - 1);
        }
    }
    /**
     * { function_description }.
     *
     * @param      toelement                        The toelement
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException                { exception_description }
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */

    public int[] headset(final int toelement) throws SetEmptyException,
    InvalidSubsetSelectionException {
        //return subSet(get(0), toelement);
        if (toelement <= this.get(0)) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return subSet(get(0), toelement);
        }
    }
    /**
     * { function_description }
     *
     * @param      fromelement                      The fromelement
     * @param      toelement                        The toelement
     *
     * @return     { description_of_the_return_value }
     *
     * @throws  InvalidSubsetSelectionException  { exception_description }
     */

public int[] subSet(final int fromelement, final int toelement)
 throws InvalidSubsetSelectionException {
        if (fromelement > toelement) {
throw new InvalidSubsetSelectionException("Invalid Arguments to Subset Exception");
        }
        int fromindex = getIndex(fromelement);
        int toindex = getIndex(toelement);
        int[] subset = new int[toindex - fromindex];
        int k = 0;
        for (int i = fromindex; i < toindex; i++) {
            subset[k++] = this.get(i);
        }
        return subset;
    }

    /**
     * @param item adds this item
     */
    public void add(final int item) {
        if (!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }
    /**
     * @param  item  The item
     * @return index.
     */

    public int getIndex(final int item) {
        for (int i = 0; i < size(); i++) {
            if (item <= this.get(i)) {
                return i;
            }
        }
        return size();
    }
    /**
     * @param  s     { parameter_description }
     * @return     { description_of_the_return_value }
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
     * @param args  The arguments.
     */
    public static void main(final String[] args) {
        Sortedset s = new Sortedset();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.
                                   contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "subSet":
                try {
                    String[] arrstring = tokens[1].split(",");
                    // if (Integer.parseInt(arrstring[0])
                    //       > Integer.parseInt(arrstring[1])) {
//     //System.out.println("Invalid Arguments to Subset Exception");
                    // } else {
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                                              Integer.parseInt(arrstring[1]));
                    Sortedset subset = new Sortedset();
                    subset.add(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            case "headSet":
                try {
                    int[] headarray = s.headset(Integer.parseInt(tokens[1]));
                    Sortedset headset = new Sortedset();
                    headset.add(headarray);
                    if (headset != null) {
                        System.out.println(headset);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {
                    System.out.println(s.last());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "intersection":
                s = new Sortedset();
                Sortedset t = new Sortedset();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Sortedset();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            default:
                break;
            }
        }
    }
}


