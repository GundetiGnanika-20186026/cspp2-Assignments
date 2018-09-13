public class BookYourshow {
	Show[] showslist;
	int size;
    BookYourshow() {
    	showslist = new Show[10];
    	size = 0;
    }

	public void addAShow(final Show obj) {
		showslist[size] = obj;
		size++;

    }
	public Show getAShow(final String argmoviename,final String argdatetime) {
		for(int i = 0; i < size; i++) {
		if(showslist[i] != null) {
           if (showslist[i].moviename.equals(argmoviename)&&showslist[i].dateandTime.equals(argdatetime)) {
           	return showslist[i];
           }
       }
   }

		return null;
    }
    public void bookAShow(String argmoviename,String argdatetime,Patron obj,String[] argseats) {
        for(int i = 0; i < size; i++) {
        if(showslist[i] != null) {
           if (showslist[i].moviename.equals(argmoviename)&&showslist[i].dateandTime.equals(argdatetime)) {
           	    for(String seatnum : argseats) {
           	    	for(int j = 0; j < showslist[i].seats.length;j++){
           	    		if(showslist[i].seats[j].equals(seatnum)) {
           	    			showslist[i].seats[j] = "N/A";
           	    			showslist[i].booked[i] = obj;
           	    		}

           	    	}
           	    }
           }
       }
		}
	}
	public void printTicket(String argmoviename,String argdatetime,String mobilenum) {
    boolean res = false;

    for(int i = 0; i < size; i++) {
    	if(showslist[i] != null) {
           if (showslist[i].moviename.equals(argmoviename)&&showslist[i].dateandTime.equals(argdatetime)) {
               for(int j =0;j<showslist[i].booked.length;j++) {
               	if(showslist[i].booked[j] != null) {
               	if(showslist[i].booked[j].mobile.equals(mobilenum)) {
               		res = true;
                 }
               	}
               }

           }
       }
       }
       if(res){
       	System.out.println(mobilenum+" "+argmoviename+" "+argdatetime);
       } else {
       	System.out.println("invalid");
       }
	}
	public void showAll(){
		for(Show s:showslist) {
			if(s != null) {

		}
	}

	}



}

