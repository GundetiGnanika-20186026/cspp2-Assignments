import java.util.*;
import java.io.*;
class Solution {
	static TreeMap<String, ArrayList<String>> dict = new TreeMap<>();
	public static void main(String[] args) {
		try {
			File file = new File("input000.txt");
			Scanner scn = new Scanner(file);
			String[] limit = scn.nextLine().split(" ");
			for (int i = 0; i < Integer.parseInt(limit[1]); i++) {
				String line = scn.nextLine().replace(".", "");
				String[] tokens = line.split(" is connected to ");
				String[] follower = tokens[1].split(", ");
				//System.out.println(followers);
				ArrayList<String> followerslist = new ArrayList<String>(Arrays.asList(follower));
				dict.put(tokens[0], followerslist);
			}
			while (scn.hasNext()) {
				String[] test = scn.nextLine().split(" ");
				switch (test[0]) {
				case "Network":
					//
					// System.out.println(dict);
					// System.out.println();
					String[] keys = dict.keySet().toArray(new String[dict.keySet().size()]);
					for(int i = 0;i<keys.length-1;i++){
						System.out.print(keys[i]+": ");
						System.out.print(dict.get(keys[i])+", ");
					}
					System.out.print(keys[keys.length-1] +": ");
					System.out.print(dict.get(keys[keys.length-1]));
					System.out.println();
					System.out.println();
					break;
				case "addConnections":
					if (dict.containsKey(test[1])) {
						dict.get(test[1]).add(test[2]);
					}
					break;
				case "getConnections":
					if (dict.containsKey(test[1])) {
						System.out.println(dict.get(test[1]));
						System.out.println();
					} else {
						System.out.println("Not a user in Network");
						System.out.println();
					}
					break;
				case "CommonConnections" :
					ArrayList<String> common = new ArrayList<>();
					ArrayList<String> first = dict.get(test[1]);
					ArrayList<String> second = dict.get(test[2]);
					for (int i = 0; i < first.size(); i++) {
						for (int j = 0; j < second.size(); j++) {
							if (first.get(i).equals(second.get(j))) {
								common.add(first.get(i));
							}
						}
					}
					System.out.println(common);
					System.out.println();
					break;



				}
			}


		} catch (FileNotFoundException e) {
			System.out.println("No such file");
		}
	}





}
