import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task{
	private String title;
	private String nameofperson;
	private int time;
	private boolean imp;
	private boolean urgent;
	private String status;
	Task(String title1,String assigned, int timegiven, boolean important,boolean urgent1,String status1)throws Exception{
		this.title = title1;
		this.nameofperson = assigned;
		this.time = timegiven;
		this.imp = important;
		this.urgent = urgent1;
		this.status = status1;
		if(!(status.equals("todo")||status.equals("done"))){
			throw new Exception("Invalid status"+" "+status);
		}
		if(time < 0){
			throw new Exception("Invalid timeToComplete"+" "+time);
		}
		if(title.equals("")){
			throw new Exception("Title not provided");
		}
	}

    public String gettitle(){
    	return title;
    }
    public String getnameofperson(){
    	return nameofperson;
    }
    public int gettime(){
    	return time;
    }
    public boolean getimp(){
    	return imp;
    }
    public boolean geturgent(){
    	return urgent;
    }
    public String getstatus(){
    	return status;
    }


	public String toString(){
		String str="";
        str+= title+", "+nameofperson+", "+time+", ";//+imp+", "+urgent+", "+status;
        if(imp){
        	str += "Important"+", ";
        }
        else{
        	str += "Not Important" +", ";
        }
        if(urgent){
        	str += "Urgent"+", ";

        }
        else {
        	str += "Not Urgent"+", ";
        }
        str += status;
        return str;
	}




}
//////////////////////////////////////////////////////////////////
class Todoist{
	Task[] taskarray;
	int size;
	Todoist(){
		taskarray = new Task[30];
		size = 0;
	}
	public void resize(){
		taskarray = Arrays.copyOf(taskarray, 2*size);
	}

	public void addTask(Task obj1){
		if(size == taskarray.length){
			resize();
		}
		taskarray[size++] = obj1;
        //System.out.println(Arrays.toString(taskarray));

	}

	public Task getNextTask(String personname){
	    for(int i = 0; i < size ; i ++){
	    	if (taskarray[i].getnameofperson().equals(personname)){
	    		if(taskarray[i].getstatus().equals("todo")){
	    			if(taskarray[i].getimp()){
	    				if(!taskarray[i].geturgent()){
                            return taskarray[i];
	    				}
	    			}
	    		}
	    	}

	    }
	    return null;


	}

	public String toString(){
		//Task taskobj = new Task();
		String arrayprint = "";
        int i;
		for( i = 0 ; i < size;i++){
			String str="";
        	str += taskarray[i].gettitle()+", "+taskarray[i].getnameofperson()+", "+taskarray[i].gettime()+", ";//+imp+", "+urgent+", "+status;
        	if(taskarray[i].getimp()){
        		str += "Important"+", ";
        	}
        	else{
        		str += "Not Important" +", ";
       		 }
        	if(taskarray[i].geturgent()){
        		str += "Urgent"+", ";

       		 }
        	else {
        		str += "Not Urgent"+", ";
        	}
        	str += taskarray[i].getstatus();


			arrayprint += str +"\n";
		}
			//arrayprint += taskobj.toString(taskarray[i]);
			return arrayprint;
	}
}








/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":

                    	testTask(tokens);

                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
             todo.addTask(createTask(tokens));
             //System.out.println(todo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
