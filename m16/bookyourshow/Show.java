public class Show {
	String moviename;
	String dateandTime;
	String[] seats;
	Patron[] booked;
	Show(final String argmoviename, final String argdateandTime, final String[] argseats) {
		moviename = argmoviename;
		dateandTime = argdateandTime;
		seats = argseats;
		booked = new Patron[argseats.length];
	}
	public String toString() {
		return moviename + "," + dateandTime;
	}



}