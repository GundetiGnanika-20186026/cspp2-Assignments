import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


class Foodlog {
    private String foodname;
    private double quantity;
    private String dateandtime;
    Foodlog(String name, double quant, String time1) {
        this.foodname = name;
        this.quantity = quant;
        this.dateandtime = time1;
    }

    public String getfoodname() {
        return foodname;
    }
    public double getquantity() {
        return quantity;
    }
    public String getdateandtime() {
        return dateandtime;
    }
}
class Waterlog {
    private double amount;
    private String dateandtime;
    Waterlog(double qunt, String datetime) {
        this.amount = qunt;
        this.dateandtime = datetime;
    }

    public double getamount() {
        return amount;
    }

    public String getdateandtime() {
        return dateandtime;
    }

}
class Physicalact {
    private String activity;
    private String date;
    private String starttime;
    private String endtime;
    private String notes;
    Physicalact(String act, String date1, String sttime, String endtim) {
        this.activity = act;
        this.date = date1;
        this.starttime = sttime;
        this.endtime = endtim;
    }
    public String getactivity() {
        return activity;
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
    public void setnotes(String notes1) {
        notes = notes1;
    }

}
class Weight {
    private double weightinkg;
    private double fatpercent;
    private String date;
    Weight(double weight1, double percent, String date1) {
        this.weightinkg = weight1;
        this.fatpercent = percent;
        this.date = date1;
    }

    public double getweightinkg() {
        return weightinkg;
    }

    public double getfatpercent() {
        return fatpercent;
    }
    public String getdate() {
        return date;
    }
}

class Sleep {
    private String datestarttime;
    private String dateendtime;
    Sleep(String datest, String dateet) {
        this.datestarttime = datest;
        this.dateendtime = dateet;
    }

    public String getdatestarttime() {
        return datestarttime;
    }

    public String getdateendtime() {
        return dateendtime;
    }


}
class Summary {
    Foodlog[] foodarray;
    int foodsize;
    Waterlog[] waterarray;
    int watersize;
    Physicalact[] activityarray;
    int activitysize;
    Sleep[] sleeparray;
    int sleepsize;
    Weight[] weightarray;
    int weightsize;
    Summary() {
        foodarray = new Foodlog[50];
        waterarray = new Waterlog[50];
        activityarray = new Physicalact[50];
        sleeparray = new Sleep[50];
        weightarray = new Weight[50];
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
    public void addactivityarray(Physicalact actobj1) {
        activityarray[activitysize++] = actobj1;
    }
    public void addsleeparray(Sleep slpobj1) {
        sleeparray[sleepsize++] = slpobj1;
    }
    public void addweightarray(Weight wobj1) {
        weightarray[weightsize++] = wobj1;
    }

    public String tostring(String argdate) {
        String s = "";
        for (int i = 0; i < foodsize; i++) {
            String[] datsplit = foodarray[i].getdateandtime().split(" ");
            if (datsplit[0].equals(argdate)) {
                s += foodarray[i].getfoodname();
            } else {
                s += "\n" + "** no food item **";
            }
        }

        for (int i = 0; i < watersize; i++) {
            String[] watsplit = waterarray[i].getdateandtime().split(" ");
            if (watsplit[0].equals(argdate)) {
                s += "\n" + waterarray[i].getamount();
            } else {
                s += "\n" + "** no water quantity **";

            }
        }

        for (int i = 0; i < activitysize; i++) {
            if (activityarray[i].getdate().equals(argdate)) {
                s += "\n" + activityarray[i].getactivity();
            } else {
                s += "\n" + "** no activity **";
            }
        }

        for (int i = 0; i < weightsize ; i++) {
            if (weightarray[i].getdate().equals(argdate)) {
                s += "\n" + weightarray[i].getweightinkg();
            } else {
                s += "\n" + "** no weight **";
            }

        }

        for (int i = 0; i < sleepsize; i++) {
            String[] slesplit = sleeparray[i].getdatestarttime().split(" ");
            if (slesplit[0].equals(argdate)) {
                s += "\n" + sleeparray[i].getdatestarttime() + " to " + sleeparray[i].getdateendtime();
            } else {
                s += "\n" + "** no sleep time **";
            }
        }

        return s;
    }
}

class Solution {
    public static void main(String[] args) {
        SimpleDateFormat uni1 = new SimpleDateFormat("dd/MM/yyyy");
        Date uni2 = new Date();

        Scanner scn = new Scanner(System.in);
        Summary summobj = new Summary();
        while (scn.hasNext()) {
            String[] input = scn.nextLine().split(" ", 2);
            switch (input[0]) {
            case "addfood":
                String[] foodsplit = input[1].split(",");
                Foodlog foodobj = new Foodlog(foodsplit[0], Double.parseDouble(foodsplit[1]), foodsplit[2]);
                summobj.addfoodarray(foodobj);
                break;
            case "addwater" :
                String[] watersplit = input[1].split(",");
                Waterlog waterobj = new Waterlog(Double.parseDouble(watersplit[0]), watersplit[1]);
                summobj.addwaterarray(waterobj);
                break;
            case "addactivity":
                String[] activitysplit = input[1].split(",");
                Physicalact activityobj = new Physicalact(activitysplit[0], activitysplit[1], activitysplit[2], activitysplit[3]);
                summobj.addactivityarray(activityobj);
                break;
            case "addsleep" :
                String[] sleepsplit = input[1].split(",");
                Sleep sleepobj = new Sleep(sleepsplit[0], sleepsplit[1]);
                summobj.addsleeparray(sleepobj);
                break;
            case "addweight" :
                String[] weightsplit = input[1].split(",");
                Weight weightobj = new Weight(Double.parseDouble(weightsplit[0]), Double.parseDouble(weightsplit[1]), weightsplit[2]);
                summobj.addweightarray(weightobj);
                break;
            case "print" :
                if (input.length == 0) {
                    System.out.println(summobj.tostring(uni1.format(uni2)));
                } else {
                    System.out.println(summobj.tostring(input[1]));
                }

                break;
            default :

            }
        }

    }
}


