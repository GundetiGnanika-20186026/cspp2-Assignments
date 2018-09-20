import java.util.*;
import java.io.*;
class Bagofwords {
	private  HashMap<String, Integer> dict1;

	Bagofwords() {
		dict1 = new HashMap<>();
	}

	public HashMap<String, Integer> getdict1() {
		return dict1;
	}

	public void plagerism(HashMap<String, Integer> finald1, HashMap<String, Integer> finald2) {
		// HashMap<String, ArrayList<Integer>> result = new Hash;
		//  for(int j = 0;j < finald2.size(); j++) {Map<>();
		// for(int i = 0; i < finald1.size(); i++) {
		//      if(finald1.getKey(i).equals(finald2.getKey(j))){
		//          result.put(finald1.getKey(i),[finald1.get(i),finald2.get(j)]);
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

		double ans = (numerator / denominator) * 100;
		ans = Math.round(ans);
		System.out.println((long)(ans));
	}



}

class Solution {

	public static void main(String[] args) {

		try {
			Scanner linescan = new Scanner(System.in);
			String dirname = linescan.nextLine();
			System.out.println(dirname);
			File new1 = new File(dirname);
			File[] files = new1.listFiles();
			// for(File i : files){
			//     System.out.println(i);
			// // }

			for (int i = 0; i < files.length; i++) {
				for (int j = 0; j < files.length; j++) {
					Bagofwords finalobj = new Bagofwords();

					// File file1 = new File(files[i]);
					Scanner scn = new Scanner(files[i]);
					HashMap<String, Integer> final1 = new HashMap<>();
					String[] para1;
					while (scn.hasNext()) {
						String s1 = scn.useDelimiter("\\A").next();
						para1 = s1.toLowerCase().split(" ");
						final1 = Countfreq(para1);
					}

					// String s1 = scn.useDelimiter("\\A").next();//nextLine().replaceAll("[^ A-Za-z0-9]","");
					// System.out.println(s1);
					// String[] para1 = s1.toLowerCase().split(" ");
					// System.out.println(Arrays.toString(para1));
					//System.out.println(Arrays.toString(para1));
					// HashMap<String, Integer> final1 = Countfreq(para1);
					//System.out.println(final1);
					scn.close();

					// File file2 = new File("test2.txt");
					Scanner scn1 = new Scanner(files[j]);
					//String s2 = scn1.nextLine().replaceAll("[^ A-Za-z0-9]","");
					// String s2 = scn1.nextLine().replaceAll("[^ \\p{Alpha}]","");
					HashMap<String, Integer> final2 = new HashMap<>();
					String[] para2;
					while (scn1.hasNext()) {
						String s2 = scn1.useDelimiter("\\A").next();
						para2 = s2.toLowerCase().split(" ");
						final2 = Countfreq(para2);
					}
					// String[] para2 = scn1.nextLine().split(" ");
					//System.out.println(final2);
					scn1.close();

					finalobj.plagerism(final1, final2);

				}
			}



		} catch (IOException io) {
			System.out.println("No such file");
		}
	}
	public static  HashMap<String, Integer> Countfreq(String[] array) {
		Bagofwords bagobj = new Bagofwords();
		for (int i = 0 ; i < array.length; i++) {
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
