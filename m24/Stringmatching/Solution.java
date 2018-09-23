
import java.util.Scanner;
import java.io.File;


class SubString1{
    String s1 = "";
    String s2 = "";
    double res;
    SubString1() {
    }
    public double plagerism(File file1, File file2){
        try {
            Scanner scn = new Scanner(file1);
            while (scn.hasNext()) {
                s1 += scn.nextLine();
            }
            scn = new Scanner(file2);
            while (scn.hasNext()) {
                s2 += scn.nextLine();
            }
            String longsub = "";
            for(int i = 0;i<s2.length();i++){
                for(int j = i+1;j<=s2.length();j++){
                    if(s1.contains(s2.substring(i,j))){
                        if (s2.substring(i,j).length() > longsub.length()){
                            longsub = s2.substring(i,j);
                        }
                    }
                }
            }
            if(file1.getName().equals(file2.getName())){
                res = 100;

                // System.out.print("\t\t");
            }
            else {
                double num = longsub.length()*2*100;
                double den = s1.length()+s2.length();
                res = Math.round(num/den);


            }
             System.out.format("%13.1f",res);

        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
        return res;

    }

}
public final  class Solution {
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
        try {
            Scanner linescan = new Scanner(System.in);

            String dirname = linescan.nextLine();
            //System.out.println(dirname);
            File new1 = new File(dirname);
            File[] files = new1.listFiles();
            double maximum = 0;
            String file11 = "";
            String file22 = "";

            System.out.print("             ");
            for(int i = 0;i < files.length - 1;i++) {
                System.out.print(files[i].getName() + "    ");
            }
            System.out.print(files[files.length - 1].getName() + " ");
            System.out.println();
            for (int i = 0; i < files.length; i++) {
                System.out.print(files[i].getName());
                    for (int j = 0; j < files.length; j++) {
                        SubString1 obj = new SubString1();
                        double result = obj.plagerism(files[i],files[j]);

                        if(result > maximum && !files[i].getName().equals(files[j].getName())){
                            maximum = result;
                            file11=files[i].getName();
                            file22 = files[j].getName();

                        }

                    }
                    System.out.print(" ");
                    System.out.println();

            }
            System.out.println("Maximum similarity is between "
             + file11 + " " + "and" + " " + file22);
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
}
}