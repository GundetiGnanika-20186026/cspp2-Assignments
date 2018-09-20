import java.util.*;
import java.io.*;
 class Bagofwords{
 	private  HashMap<String,Integer> dict1;

 	Bagofwords() {
 		dict1 = new HashMap<>();
 	}

 	public HashMap<String,Integer> getdict1(){
 		return dict1;
 	}

    public void plagerism(HashMap<String,Integer> finald1, HashMap<String,Integer> finald2) {
        HashMap<String,ArrayList<Integer>> result = new HashMap<>();
        // for(int i = 0; i < finald1.size(); i++) {
        // 	for(int j = 0;j < finald2.size(); j++) {
        // 		if(finald1.getKey(i).equals(finald2.getKey(j))){
        // 			result.put(finald1.getKey(i),[finald1.get(i),finald2.get(j)]);
        // 		}
        // 	}
        // }
        int numerator = 0;
        for(String key1: finald1.keySet()){
        	for(String key2 :finald2.keySet()) {
        		if(key1.equals(key2)) {
        			numerator += (finald1.get(key1)*finald2.get(key2));

        		}
        	}
        }
    }



}

class Solution{

	public static void main(String[] args) {

    try {

		File file1 = new File("testcases.txt");
		Scanner scn = new Scanner(file1);
		String[] para1 = scn.nextLine().toLowerCase().split(" ");
		HashMap<String,Integer> final1 = Countfreq(para1);
		//System.out.println(final1);
        scn.close();

		File file2 = new File("test2.txt");
		Scanner scn1 = new Scanner(file2);
		String[] para2 = scn1.nextLine().split(" ");
		HashMap<String,Integer> final2 = Countfreq(para2);
		//System.out.println(final2);
		scn1.close();

		} catch (FileNotFoundException e) {
		System.out.println("No such file");
		}
	}
	public static  HashMap<String,Integer> Countfreq(String[] array) {
		Bagofwords bagobj = new Bagofwords();
        for (int i = 0 ; i < array.length; i++) {
        	int value = 1;
        	if (bagobj.getdict1().containsKey(array[i])) {
        		value= bagobj.getdict1().get(array[i])+1;
            }
        	bagobj.getdict1().put(array[i],value);
        }
        //System.out.println(bagobj.getdict1());
        return bagobj.getdict1();
    }
}
