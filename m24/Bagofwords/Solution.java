// import java.util.*;
// import java.io.*;
//  class Bagofwords{
//  	private  HashMap<String,Integer> dict1;

//  	Bagofwords() {
//  		dict1 = new HashMap<>();
//  	}

//  	public HashMap<String,Integer> getdict1(){
//  		return dict1;
//  	}

//     public void plagerism(HashMap<String,Integer> finald1, HashMap<String,Integer> finald2) {
//         HashMap<String,ArrayList<Integer>> result = new HashMap<>();
//         // for(int i = 0; i < finald1.size(); i++) {
//         // 	for(int j = 0;j < finald2.size(); j++) {
//         // 		if(finald1.getKey(i).equals(finald2.getKey(j))){
//         // 			result.put(finald1.getKey(i),[finald1.get(i),finald2.get(j)]);
//         // 		}
//         // 	}
//         // }
//         int numerator = 0;
//         for(String key1: finald1.keySet()){
//         	for(String key2 :finald2.keySet()) {
//         		if(key1.equals(key2)) {
//         			numerator += (finald1.get(key1)*finald2.get(key2));

//         		}
//         	}
//         }
//         int denominator = 0;
//         for(String key11 :finald1.keySet()){
//         	int
//         }
//     }



// }

// class Solution{

// 	public static void main(String[] args) {

//     try {

// 		File file1 = new File("test1.txt");
// 		Scanner scn = new Scanner(file1);
// 		String[] para1 = scn.nextLine().toLowerCase().split(" ");
// 		HashMap<String,Integer> final1 = Countfreq(para1);
// 		//System.out.println(final1);
//         scn.close();

// 		File file2 = new File("test2.txt");
// 		Scanner scn1 = new Scanner(file2);
// 		String[] para2 = scn1.nextLine().split(" ");
// 		HashMap<String,Integer> final2 = Countfreq(para2);
// 		//System.out.println(final2);
// 		scn1.close();

// 		} catch (FileNotFoundException e) {
// 		System.out.println("No such file");
// 		}
// 	}
// 	public static  HashMap<String,Integer> Countfreq(String[] array) {
// 		Bagofwords bagobj = new Bagofwords();
//         for (int i = 0 ; i < array.length; i++) {
//         	int value = 1;
//         	if (bagobj.getdict1().containsKey(array[i])) {
//         		value= bagobj.getdict1().get(array[i])+1;
//             }
//         	bagobj.getdict1().put(array[i],value);
//         }
//         //System.out.println(bagobj.getdict1());
//         return bagobj.getdict1();
//     }
// }


// //


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
        // HashMap<String, ArrayList<Integer>> result = new Hash;
        //  for(int j = 0;j < finald2.size(); j++) {Map<>();
        // for(int i = 0; i < finald1.size(); i++) {
        //      if(finald1.getKey(i).equals(finald2.getKey(j))){
        //  result.put(finald1.getKey(i),[finald1.get(i),finald2.get(j)]);
        //      }
        //  }
        // }
        int numerator = 0;
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
        double denominator;
        denominator = Math.sqrt(square1) * Math.sqrt(square2);
        final int hun = 100;
        double ans = (numerator / denominator) * hun;
        ans = Math.round(ans);
        return (long) (ans);
    }



    // public void Stringmatch(HashMap<String, Integer>
    //  finald11, HashMap<String, Integer> finald22) {
//    int lcs = 0;
    // int max = 0;
//      for(String key1 : finald11.keySet()){
    //      for(String key2 : finald22.keySet()){
//              if(key1.charAt(0).equals(key2.charAt(0))){
//                  if(key1.equals(key2)) {
//                      lcs = key1.length();
    //                  }


//              }
//              if (max < lcs)  {
//                      max = lcs;
//                  }

//          }

//          }


    // }



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
                    String s1 = "";
                    while (scn.hasNext()) {
                        //String s1 = scn.useDelimiter("\\A").next();
            String s11 = scn.nextLine().replaceAll("[^A-Za-z0-9_ ]", " ");
                        s11 = s11.replaceAll("\\s+", " ");
                        s1 = s1 + s11;


                    }
                    para1 = s1.toLowerCase().split(" ");
                    final1 = countfreq(para1);
                    int  keyscount = final1.keySet().size();


                    // String s1 = scn.useDelimiter("\\A").next();
                    //nextLine().replaceAll("[^ A-Za-z0-9]","");
                    // System.out.println(s1);
                    // String[] para1 = s1.toLowerCase().split(" ");
                    // System.out.println(Arrays.toString(para1));
                    //System.out.println(Arrays.toString(para1));
                    // HashMap<String, Integer> final1 = countfreq(para1);
                    //System.out.println(final1);
                    scn.close();

                    // File file2 = new File("test2.txt");
                    Scanner scn1 = new Scanner(files[j]);
         //String s2 = scn1.nextLine().replaceAll("[^ A-Za-z0-9]","");
        // String s2 = scn1.nextLine().replaceAll("[^ \\p{Alpha}]","");
                    HashMap<String, Integer> final2 = new HashMap<>();
                    String[] para2;
                    String s2 = "";
                    while (scn1.hasNext()) {
                        //String s2 = scn1.useDelimiter("\\A").next();
            String s22 = scn1.nextLine().replaceAll("[^A-Za-z0-9_ ]", " ");
                        s22 = s22.replaceAll("\\s+", " ");
                        s2 = s2 + s22;
                        //System.out.println(s2);
                        // para2 = s2.toLowerCase().split(" ");

                        // final2 = countfreq(para2);
                    }
                    para2 = s2.toLowerCase().split(" ");
                    final2 = countfreq(para2);
                    // String[] para2 = scn1.nextLine().split(" ");
                    //System.out.println(final2);
                    scn1.close();
                    double resultpercent = finalobj.plagerism(final1, final2);
                    resultpercent = Math.round(resultpercent);
                    double max = 0.0;
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