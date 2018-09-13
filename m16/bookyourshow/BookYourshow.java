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
           if (showslist[i].moviename.equals(argmoviename)&&showslist[i].dateandTime.equals(argdatetime)) {
           	return showslist[i];
           }
		}
		return null;
    }
	// public void book() {

	// }
	// public void print() {

	// }
	// public String[] showAll(){

	// }



}

