import java.util.Scanner;
import java.util.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
/**
 * Class for foodlog.
 */
class Foodlog {
    /**
     * { foodname }.
     */
    private String foodname;
    /**
     * { quantity }.
     */
    private String quantity;
    /**
     * { date }.
     */
    private String date;
    /**
     * { time }.
     */
    private String time;
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      quant  The quant
     * @param      time1  The time 1
     */
    Foodlog(String name, String quant, String date1, String time1) {
        this.foodname = name;
        this.quantity = quant;
        this.date = date1;
        this.time = time1;
    }

    /**
     * { getting foodname  }.
     *
     * @return     { foodname }
     */
    public String getfoodname() {
        return foodname;
    }

    /**
     * { getting quantity }.
     *
     * @return     { quantity }
     */
    public String getquantity() {
        return quantity;
    }

    /**
     * { getting date }.
     *
     * @return     { date  }
     */
    public String getdate() {
        return date;
    }

    /**
     * { getting time }
     *
     * @return     { time }
     */
    public String gettime() {
        return time;
    }

}
//////////////////////////////////////////////////////////////////////

/**
 * Class for waterlog.
 */
class Waterlog {
    /**
     * { amount of water }.
     */
    private String amount;
    /**
     * { date and time }.
     */
    private String date;
    /**
     * { time }
     */
    private String time;

    /**
     * Constructs the object.
     *
     * @param      qunt      The qunt
     * @param      datetime  The datetime
     */
    Waterlog(String amount, String date1, String time1) {
        this.amount = amount;
        this.date = date1;
        this.time = time1;
    }

    /**
     * { getting amount }.
     *
     * @return     { the amount }
     */
    public String getamount() {
        return amount;
    }

    /**
     * { date and time }.
     *
     * @return     { date and time }
     */
    public String getdate() {
        return date;
    }
    /**
     * { time }
     *
     * @return     { description_of_the_return_value }
     */
    public String gettime() {
        return time;
    }

}
//////////////////////////////////////////////////////////////////

/**
 * Class for physicalact.
 */
class PhysicalActivitylog {
    /**
     * { activity }.
     */
    private String activity;
    /**
     * { date }.
     */
    private String date;
    /**
     * { start time }.
     */
    private String starttime;
    /**
     * { end time }.
     */
    private String endtime;
    /**
     * { notes }.
     */
    private String notes;

    /**
     * Constructs the object.
     *
     * @param      act     The act
     * @param      date1   The date 1
     * @param      sttime  The sttime
     * @param      endtim  The endtim
     */
    PhysicalActivitylog(String act, String notes1, String date1, String sttime, String endtim) {
        this.activity = act;
        this.notes = notes1;
        this.date = date1;
        this.starttime = sttime;
        this.endtime = endtim;
    }

    /**
     * { get activity }.
     *
     * @return     { activity }
     */
    public String getactivity() {
        return activity;
    }



    /**
     * { get date }.
     *
     * @return     { getdate }
     */
    public String getdate() {
        return date;
    }

    /**
     * { get start time }.
     *
     * @return     { return start time }
     */
    public String getstarttime() {
        return starttime;
    }

    /**
     * { get end time }.
     *
     * @return     {  }
     */
    public String getendtime() {
        return endtime;
    }
    /**
     * { return notes }.
     *
     * @return     { notes }
     */
    public String getnotes() {
        return notes;
    }

}
////////////////////////////////////////////////////////////////////
/**
 * Class for weight.
 */
class Weightlog {
    /**
     * { var_description }
     */
    private String date;
    private String  time;
    private String weightinkg;
    private String fatpercent;

    Weightlog(String date1, String time1, String weight1, String percent) {
        this.date = date1;
        this.time = time1;
        this.weightinkg = weight1;
        this.fatpercent = percent;

    }

    public String getdate() {
        return date;
    }

    public String gettime() {
        return time;
    }

    public String getweightinkg() {
        return weightinkg;
    }

    public String getfatpercent() {
        return fatpercent;
    }

}
/////////////////////////////////////////////////////////

class Sleeplog {
    private String date;
    private String starttime;
    private String endtime;
    Sleeplog(String date1, String starttime1, String endtime1) {
        this.date = date1;
        this.starttime = starttime1;
        this.endtime = endtime1;
    }

    public String getdate() {
        return date;
    }

    public String getstarttime() {
        return starttime;
    }

    public String getendtime() {
        return endtime;
    }


}
////////////////////////////////////////////////////
class Summary {
    Foodlog[] foodarray;
    int foodsize;
    Waterlog[] waterarray;
    int watersize;
    PhysicalActivitylog[] activityarray;
    int activitysize;
    Sleeplog[] sleeparray;
    int sleepsize;
    Weightlog[] weightarray;
    int weightsize;
    Summary() {
        foodarray = new Foodlog[50];
        waterarray = new Waterlog[50];
        activityarray = new PhysicalActivitylog[50];
        sleeparray = new Sleeplog[50];
        weightarray = new Weightlog[50];
        foodsize = 0;
        watersize = 0;
        activitysize = 0;
        sleepsize = 0;
        weightsize = 0;
    }

    public void addfoodarray(Foodlog foodobj1) {
        foodarray[foodsize++] = foodobj1;
    }
    public void addwaterarray(Waterlog waterobj1) {
        waterarray[watersize++] = waterobj1;
    }
    public void addactivityarray(PhysicalActivitylog actobj1) {
        activityarray[activitysize++] = actobj1;
    }
    public void addsleeparray(Sleeplog slpobj1) {
        sleeparray[sleepsize++] = slpobj1;
    }
    public void addweightarray(Weightlog wobj1) {
        weightarray[weightsize++] = wobj1;
    }

    public void printfoodlog() {
        if(foodsize == 0){
            System.out.println("None");
        } else {
            for (int i = 0 ; i < foodsize ; i++) {

            System.out.println("Date:" + foodarray[i].getdate());
            System.out.println("Time:" + foodarray[i].gettime());
            System.out.println("Name:" + foodarray[i].getfoodname());
            System.out.println("Quantity:" + foodarray[i].getquantity());

        }
    }

    }

    public void printwaterlog() {
        if(watersize == 0){
            System.out.println("None");
        } else {
        for (int i = 0 ; i < watersize ; i++) {

            System.out.println("Date:" + waterarray[i].getdate());
            System.out.println("Quantity:" + waterarray[i].getamount()+"ml");
        }
    }


    }

    public void printphysicalactivity() {
        if(activitysize == 0){
            System.out.println("None");
        } else {
        for (int i = 0 ; i < activitysize ; i++) {

            System.out.println("Name:" + activityarray[i].getactivity());
            System.out.println("Notes:" + activityarray[i].getnotes());
            System.out.println("Date:" + activityarray[i].getdate());
            System.out.println("Starttime:" + activityarray[i].getstarttime());
            System.out.println("Endtime:" + activityarray[i].getendtime());
        }
    }

    }

    public void printweightlog() {
        if(weightsize == 0) {
            System.out.println("None");
        } else {
        for (int i = 0 ; i < weightsize ; i++) {

            System.out.println("Date:" + weightarray[i].getdate());
            System.out.println("Time:" + weightarray[i].gettime());
            System.out.println("Weight:" + weightarray[i].getweightinkg());
            System.out.println("Fat:" + weightarray[i].getfatpercent());
        }
    }

    }

    public void printsleep() {
        if(sleepsize == 0){
            System.out.println("None");
        } else {
        for (int i = 0; i < sleepsize; i++) {

            System.out.println("Date:" + sleeparray[i].getdate());
            System.out.println("Starttime:" + sleeparray[i].getstarttime());
            System.out.println("Endtime:" + sleeparray[i].getendtime());
        }
    }
    }
}





//////////////////////////////////////////////////////////////////////////
    class Solution {
        public static void main(String[] args) {
            //SimpleDateFormat uni1 = new SimpleDateFormat("dd/MM/yyyy");
            //Date uni2 = new Date();

            Scanner scn = new Scanner(System.in);
            Summary summobj = new Summary();
            while (scn.hasNext()) {
                String[] input = scn.nextLine().split(" ", 2);
                switch (input[0]) {
                case "Food":
                    String[] foodsplit = input[1].split(",");
                    Foodlog foodobj = new Foodlog(foodsplit[0], foodsplit[1], foodsplit[2], foodsplit[3]);
                    summobj.addfoodarray(foodobj);
                    break;
                case "Water" :
                    String[] watersplit = input[1].split(",");
                    Waterlog waterobj = new Waterlog(watersplit[0], watersplit[1], watersplit[2]);
                    summobj.addwaterarray(waterobj);
                    break;
                case "PhysicalActivity":
                    String[] activitysplit = input[1].split(",");
                    PhysicalActivitylog activityobj = new PhysicalActivitylog(activitysplit[0], activitysplit[1], activitysplit[2], activitysplit[3], activitysplit[4]);
                    summobj.addactivityarray(activityobj);
                    break;
                case "Sleep" :
                    String[] sleepsplit = input[1].split(",");
                    Sleeplog sleepobj = new Sleeplog(sleepsplit[0], sleepsplit[1], sleepsplit[2]);
                    summobj.addsleeparray(sleepobj);
                    break;
                case "Weight" :
                    String[] weightsplit = input[1].split(",");
                    Weightlog weightobj = new Weightlog(weightsplit[0], weightsplit[1], weightsplit[2], weightsplit[3]);
                    summobj.addweightarray(weightobj);
                    break;
                case "Foodlog" :
                    System.out.println("Food");
                    summobj.printfoodlog();
                    System.out.println();
                    break;
                case "Waterlog" :
                    System.out.println("Water");
                    summobj.printwaterlog();
                    System.out.println();
                    break;
                case "PhysicalActivitylog" :
                    System.out.println("PhysicalActivity");
                    summobj.printphysicalactivity();
                    System.out.println();

                    break;
                case "Weightlog" :
                    System.out.println("Weight");
                    summobj.printweightlog();
                    System.out.println();
                    break;
                case "Sleeplog" :
                    System.out.println("Sleep");
                    summobj.printsleep();
                    System.out.println();
                    break;
                case "Summary" :
                    System.out.println("Food");
                    summobj.printfoodlog();
                     System.out.println("Water");
                    summobj.printwaterlog();
                     System.out.println("PhysicalActivity");
                    summobj.printphysicalactivity();
                     System.out.println("Weight");
                    summobj.printweightlog();
                      System.out.println("Sleep");
                    summobj.printsleep();
                    break;
                default :

                }
            }

        }
    }


