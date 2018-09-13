/**
 * Class for book yourshow.
 */
public class BookYourshow {
    Show[] showslist;
    int size;
    /**
     * Constructs the object.
     */
    BookYourshow() {
        showslist = new Show[10];
        size = 0;
    }
    /**
     * Adds a show.
     *
     * @param      obj   The object
     */
    public void addAShow(final Show obj) {
        showslist[size] = obj;
        size++;

    }
    /**
     * Gets a show.
     *
     * @param      argmoviename  The argmoviename
     * @param      argdatetime   The argdatetime
     *
     * @return     A show.
     */
    public Show getAShow(final String argmoviename, final String argdatetime) {
        for (int i = 0; i < size; i++) {
            if (showslist[i] != null) {
                if (showslist[i].moviename.equals(argmoviename) && showslist[i].dateandTime.equals(argdatetime)) {
                    return showslist[i];
                }
            }
        }

        return null;
    }
    /**
     * { function_description }
     *
     * @param      argmoviename  The argmoviename
     * @param      argdatetime   The argdatetime
     * @param      obj           The object
     * @param      argseats      The argseats
     */
    public void bookAShow(String argmoviename, String argdatetime, Patron obj, String[] argseats) {
        if (size == 0) {
            System.out.println("No show");
            return;
        }
        if (getAShow(argmoviename, argdatetime) == null) {
            System.out.println("No show");
        }
        for (int i = 0; i < size; i++) {
            if (showslist[i] != null) {
                if (showslist[i].moviename.equals(argmoviename) && showslist[i].dateandTime.equals(argdatetime)) {
                    for (String seatnum : argseats) {
                        for (int j = 0; j < showslist[i].seats.length; j++) {
                            if (showslist[i].seats[j].equals(seatnum)) {
                                showslist[i].seats[j] = "N/A";
                                showslist[i].booked[i] = obj;
                            }

                        }
                    }
                }
            }
        }
    }
    /**
     *
     * @param      argmoviename  The argmoviename
     * @param      argdatetime   The argdatetime
     * @param      mobilenum     The mobilenum
     */
    public void printTicket(String argmoviename, String argdatetime, String mobilenum) {
        boolean res = false;

        for (int i = 0; i < size; i++) {
            if (showslist[i] != null) {
                if (showslist[i].moviename.equals(argmoviename) && showslist[i].dateandTime.equals(argdatetime)) {
                    for (int j = 0; j < showslist[i].booked.length; j++) {
                        if (showslist[i].booked[j] != null) {
                            if (showslist[i].booked[j].mobile.equals(mobilenum)) {
                                res = true;
                            }
                        }
                    }

                }
            }
        }
        if (res) {
            System.out.println(mobilenum + " " + argmoviename + " " + argdatetime);
        } else {
            System.out.println("Invalid");
        }
    }
    /**
     * Shows all shows.
     */
    public void showAll() {
        for (Show s : showslist) {
            if (s != null) {
                String res = s.moviename + "," + s.dateandTime + ",[";
                for (int i = 0; i < s.seats.length - 1; i++) {
                    res += s.seats[i] + ",";
                }
                res += s.seats[s.seats.length - 1] + "]";
                System.out.println(res);

            }
        }

    }



}

