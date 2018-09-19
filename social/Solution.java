import java.util.Scanner;
import java.util.ArrayList;
class User {
	private String username;
	private ArrayList<String> followers;
	User(String name1,ArrayList<String>  followers1){
		this.username = name1;
		this.followers = followers1;

	}
	public String getusername() {
		return username;
	}

	public ArrayList<String> getfollowers() {
		return followers;
	}
}

class Network {
   ArrayList<User> userarray;
   Network(){
   	userarray = new ArrayList<User>();
   }

   public void addConnection(User obj1){
   	    boolean required = false;
   	    for(int i = 0; i < userarray.size();i++){
   	    	if(userarray.get(i).username.equals(obj1.username)) {
   	    		for(int j = 0; j < obj1.followers.size();j++)
   	    			userarray.get(i).followers.add(obj1.followers.get(j));
   	    		    required = true
   	    	}
   	    }
   	    if(!required){
   	    	userarray.add(obj1);
   	    }
   }

   public void getConnections(String adval) {
   	for(int i = 0;i<userarray.size();i++) {
   		if(userarray.get(i).)
   	}
   }


}












class Solution{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext()){
			// String[] original = scn.nextLine().split("\\.");
			// String[] initial = original[0].split(" is connected to ");
			// System.out.println(Arrays.toString(initial));
			Network obj = new Network()
			String original = scn.nextLine().replace("("," ").replace(")","");
			String[] initial = original.split(" ",2);
			switch(initial[0]){
				case "addConnection":
				    String flist = initial[1];
				    ArrayList<String> fnew;
				    fnew = new ArrayList<String>(initial.length-2);
				    for(int i=2;i<initial.length;i++){
				    	fnew.add(initial[i]);
				    }
				    obj.addConnection(new User(flist,fnew));
				    break;
				case:"getConnections":
				    obj.getConnections(initial[1]);
				    break;
				case "getcommonConnections":
				    obj.getcommonConnections(initial[1],initial[2]);
                    break;


			}

		}
	}
}