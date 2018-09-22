import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
/**
 * Class for task.
 */
class Task {
    /**
     * { var_description }.
     */
    private String title;
    /**
     * { var_description }.
     */
    private String nameofperson;
    /**
     * { var_description }.
     */
    private int time;
    /**
     * { var_description }.
     */
    private boolean imp;
    /**
     * { var_description }.
     */
    private boolean urgent;
    /**
     * { var_description }.
     */
    private String status;
    /**
     * Constructs the object.
     *
     * @param      title1     The title 1
     * @param      assigned   The assigned
     * @param      timegiven  The timegiven
     * @param      important  The important
     * @param      urgent1    The urgent 1
     * @param      status1    The status 1
     */
    Task(final String title1, final String assigned, final int timegiven,
     final boolean important, final boolean urgent1,
      final String status1)throws Exception {
        this.title = title1;
        this.nameofperson = assigned;
        this.time = timegiven;
        this.imp = important;
        this.urgent = urgent1;
        this.status = status1;
        if (!(status.equals("todo") || status.equals("done"))) {
            throw new Exception("Invalid status" + " " + status);
        }
        if (time < 0) {
            throw new Exception("Invalid timeToComplete" + " " + time);
        }
        if (title.equals("")) {
            throw new Exception("Title not provided");
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String gettitle() {
        return title;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getnameofperson() {
        return nameofperson;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int gettime() {
        return time;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean getimp() {
        return imp;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean geturgent() {
        return urgent;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getstatus() {
        return status;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str += title + ", " + nameofperson + ", " + time + ", "; //+imp+", "+urgent+", "+status;
        if (imp) {
            str += "Important" + ", ";
        } else {
            str += "Not Important" + ", ";
        }
        if (urgent) {
            str += "Urgent" + ", ";

        } else {
            str += "Not Urgent" + ", ";
        }
        str += status;
        return str;
    }
}
//////////////////////////////////////////////////////////////////

/**
 * Class for todoist.
 */
class Todoist {
    /**
     * { var_description }.
     */
    private Task[] taskarray;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Todoist() {
        final int thirty = 30;
        taskarray = new Task[thirty];
        size = 0;
    }
    /**
     * { function_description }.
     */
    public void resize() {
        taskarray = Arrays.copyOf(taskarray, (1 + 1) * size);
    }
    /**
     * Adds a task.
     *
     * @param      obj1  The object 1
     */
    public void addTask(final Task obj1) {
        if (size == taskarray.length) {
            resize();
        }
        taskarray[size++] = obj1;
        //System.out.println(Arrays.toString(taskarray));

    }
    /**
     * Gets the next task.
     *
     * @param      personname  The personname
     *
     * @return     The next task.
     */
    public Task getNextTask(final String personname) {
        for (int i = 0; i < size; i++) {
            if (taskarray[i].getnameofperson().equals(personname)) {
                if (taskarray[i].getstatus().equals("todo")) {
                    if (taskarray[i].getimp()) {
                        if (!taskarray[i].geturgent()) {
                            return taskarray[i];
                        }
                    }
                }
            }

        }
        return null;


    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        //Task taskobj = new Task();
        String arrayprint = "";
        int i;
        for (i = 0; i < size; i++) {
            String str = "";
str += taskarray[i].gettitle() + ", " + taskarray[i].getnameofperson()
            + ", " + taskarray[i].gettime() + ", ";
            if (taskarray[i].getimp()) {
                str += "Important" + ", ";
            } else {
                str += "Not Important" + ", ";
            }
            if (taskarray[i].geturgent()) {
                str += "Urgent" + ", ";

            } else {
                str += "Not Urgent" + ", ";
            }
            str += taskarray[i].getstatus();


            arrayprint += str + "\n";
        }
        //arrayprint += taskobj.toString(taskarray[i]);
        return arrayprint;
    }
}
///////////////////////////////////////////////////////////////////////
/**
 * Class for todoist main.
 */
public class TodoistMain {
    /**
     * Constructs the object.
     */
    TodoistMain() { };

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
    public static void testAddTask(final Todoist todo,
     final String[] tokens) {
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
        int timeToComplete = Integer.parseInt(tokens[2 + 1]);
        boolean important = tokens[2 + 2].equals("y");
        boolean urgent = tokens[2 + 2 + 1].equals("y");
        String status = tokens[1 + 1 + 1 + 1 + 1 + 1];
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
