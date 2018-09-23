import java.util.Scanner;
import java.io.File;
class SubString1 {
    String s1 = "";
    String s2 = "";
    double res;
    SubString1() {
    }
    public double plagerism(File file1, File file2) {
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
            for (int i = 0; i < s2.length(); i++) {
                for (int j = i + 1; j <= s2.length(); j++) {
                    if (s1.contains(s2.substring(i, j))) {
                        if (s2.substring(i, j).length() > longsub.length()) {
                            longsub = s2.substring(i, j);
                        }
                    }
                }
            }
            if (file1.getName().equals(file2.getName())) {
                res = 100;

                // System.out.print("\t\t");
            } else {
                double num = longsub.length() * 2 * 100;
                double den = s1.length() + s2.length();
                res = Math.round(num / den);


            }
            System.out.format("%13.1f", res);

        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
        return res;

    }

}