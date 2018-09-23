
import java.util.Scanner;
import java.io.File;
/**
 * solution - main class.
 */
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
            for (int i = 0; i < files.length - 1; i++) {
                System.out.print(files[i].getName() + "    ");
            }
            System.out.print(files[files.length - 1].getName() + " ");
            System.out.println();
            for (int i = 0; i < files.length; i++) {
                System.out.print(files[i].getName());
                for (int j = 0; j < files.length; j++) {
                    SubString1 obj = new SubString1();
                    double result = obj.plagerism(files[i], files[j]);

if (result > maximum && !files[i].getName().equals(files[j].getName())) {
                        maximum = result;
                        file11 = files[i].getName();
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
