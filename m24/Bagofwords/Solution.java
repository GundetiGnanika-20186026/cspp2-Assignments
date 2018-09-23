import java.util.Scanner;
import java.io.File;
//import java.util.Arrays;
import java.util.HashMap;
/**
 * Class for bagofwords.
 */
class Bagofwords {
    /**
     * { var_description }.
     */
    private  HashMap<String, Integer> dict1;
    /**
     * Constructs the object.
     */
    Bagofwords() {
        dict1 = new HashMap<>();
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public HashMap<String, Integer> getdict1() {
        return dict1;
    }
    /**
     * { function_description }.
     *
     * @param      finald1  The finald 1
     * @param      finald2  The finald 2
     *
     * @return     { description_of_the_return_value }
     */
    public long plagerism(final HashMap<String, Integer> finald1,
                          final  HashMap<String, Integer> finald2) {

        double numerator = 0;
        for (String key1 : finald1.keySet()) {
            for (String key2 : finald2.keySet()) {
                if (key1.equals(key2)) {
                    numerator += (finald1.get(key1) * finald2.get(key2));

                }
            }
        }

        int square1 = 0;
        for (String key1 : finald1.keySet()) {
            square1 += Math.pow(finald1.get(key1), 2);

        }
        int square2 = 0;
        for (String key2 : finald2.keySet()) {
            square2 += Math.pow(finald2.get(key2), 2);
        }
        double denominator = 0;
        denominator = Math.sqrt(square1) * Math.sqrt(square2);
        final int hun = 100;
        //System.out.print(" " + numerator + " "+ denominator + " " );
        double ans = ((numerator * hun) / denominator);
        ans = Math.round(ans);
        return (long) (ans);
    }



}
/**
 * Class for solution.
 */

final  class Solution {
    /**
     * Class for solution.
     */
    private Solution() { };
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int a = 0, b = 0;
        double max = 0.0;
        try {
            Scanner linescan = new Scanner(System.in);
            String dirname = linescan.nextLine();
            //System.out.println(dirname);
            File new1 = new File(dirname);
            File[] files = new1.listFiles();
            // for(File i : files){
            //     System.out.println(i);
            // // }
            System.out.print("\t" + "\t");
            for (File file : files) {
                System.out.print(file.getName() + "\t");
            }
            System.out.println();
            for (int i = 0; i < files.length; i++) {
                System.out.print(files[i].getName() + "\t");
                for (int j = 0; j < files.length; j++) {
                    Bagofwords finalobj = new Bagofwords();

                    // File file1 = new File(files[i]);
                    Scanner scn = new Scanner(files[i]);
                    HashMap<String, Integer> final1 = new HashMap<>();
                    String[] para1;
                    String s1 = null;
                    while (scn.hasNext()) {
                        s1 = scn.useDelimiter("\\A").next();


                    }
                    if (s1 != null) {
                         para1 = s1.toLowerCase().split(" ");
                        final1 = countfreq(para1);
                        int  keyscount = final1.keySet().size();
                    }



                    scn.close();

                    // File file2 = new File("test2.txt");
                    Scanner scn1 = new Scanner(files[j]);
        //String s2 = scn1.nextLine().replaceAll("[^ A-Za-z0-9]","");
        // String s2 = scn1.nextLine().replaceAll("[^ \\p{Alpha}]","");
                    HashMap<String, Integer> final2 = new HashMap<>();
                    String[] para2;
                    String s2 = null;
                    while (scn1.hasNext()) {
                        s2 = scn1.useDelimiter("\\A").next();
                    }
                    if (s2 != null) {
                        para2 = s2.toLowerCase().split(" ");
                        final2 = countfreq(para2);
                    }


                    // String[] para2 = scn1.nextLine().split(" ");
                    //System.out.println(final2);
                    scn1.close();
                    double resultpercent = finalobj.plagerism(final1, final2);
                    resultpercent = Math.round(resultpercent);

                    System.out.print((long) resultpercent + "\t\t");
                    if (resultpercent > max && i != j) {
                        max = resultpercent;
                        a = i;
                        b = j;
                    }

                }
                System.out.println();
            }
            System.out.println("Maximum similarity is between "
                + files[a].getName() + " " + "and" + " " + files[b].getName());





        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
    /**
     * { function_description }.
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }.
     */
    public static  HashMap<String, Integer> countfreq(final String[] array) {
        Bagofwords bagobj = new Bagofwords();
        for (int i = 0; i < array.length; i++) {
            int value = 1;
            if (bagobj.getdict1().containsKey(array[i])) {
                value = bagobj.getdict1().get(array[i]) + 1;
            }
            bagobj.getdict1().put(array[i], value);
        }
        //System.out.println(bagobj.getdict1());
        return bagobj.getdict1();
    }
}
