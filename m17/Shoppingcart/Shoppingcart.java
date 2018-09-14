import java.util.Scanner;
////////////////////////////////////////////////////////////////////////////
class Item {
	String productname;
	int quantity;
	double unitprice;
	Item(String pname, String qmeasure, String umoney) {
		this.productname = pname;
		this.quantity = Integer.parseInt(qmeasure);
		this.unitprice = Double.parseDouble(umoney);
	}
	Item(String pname, String qmeasure) {
		this.productname = pname;
		this.quantity = Integer.parseInt(qmeasure);
	}

	public boolean equals(Item other) {
		if (this.productname.equals(other.productname)) {
			return true;

		}
		return false;

	}
}
/////////////////////////////////////////////////////////////////////
class Shoppingcart {
	Item[] catalogarray;
	Item[] cartarray;
	int sizecatalog;
	int sizecart;
	String[] validCoupans = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static boolean coupanApplied = false;
	Shoppingcart() {
		catalogarray = new Item[50];
		cartarray = new Item[50];
		sizecatalog = 0;
		sizecart = 0;

	}
	public void addToCatalog(Item item) {

		catalogarray[sizecatalog++] = item;

	}

	public void addTOCart(Item item) {
		if (!incart(item)) {
			if (checkcatalog(item)) {
				cartarray[sizecart++] = item;
			}
		}
	}
	boolean incart(Item item) {
		for (Item s : cartarray) {
			if (s != null) {
				if (s.equals(item)) {
					s.quantity = s.quantity + item.quantity;
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkcatalog(Item item) {
		for (Item i : catalogarray) {
			if (i != null) {
				if (i.equals(item)) {
					if (item.quantity <= i.quantity) {
						i.quantity = i.quantity - item.quantity;
						return true;
					}


				}
			}
		}
		return false;
	}




	public void removeFromCart(Item item) {
		for (int i = 0; i < sizecart; i++) {
			if (item.equals(cartarray[i])) {
				cartarray[i].quantity = cartarray[i].quantity - item.quantity;
			}
		}

	}



	public void showCart() {
		for (Item i : cartarray) {
			if ( i != null ) {
				if (i.quantity != 0) {
					System.out.println(i.productname + " " + i.quantity);
				}

			}
		}

	}
	public void showCatalog() {
		for (Item i : catalogarray) {
			if (i != null) {
				System.out.println(i.productname + " " + i.quantity + " " + i.unitprice);
			}
		}
	}


	public double getTotalAmount() {
		double total = 0;
		for (int i = 0; i < sizecart; i++) {
			total += cartarray[i].quantity * getprice(cartarray[i]);
		}
		return total;

	}

	double getprice(Item given) {
		for (Item i : catalogarray) {
			if (i != null) {
				if (i.equals(given)) {
					return i.unitprice;

				}

			}
		}
		return 0.0;

	}


	public void applyCoupen(String cou) {
		boolean valid = false;
		for (String s : validCoupans) {
			if (s.equals(cou)) {
				valid = true;
			}
		}
		if (!valid) {
			System.out.println("Invalid coupon");
			return;
		}
		if (coupanApplied) {
			return;
		}
		for (String s : validCoupans) {
			if (s.equals(cou)) {
				int num = Integer.parseInt(cou.substring(3));
				discount = getTotalAmount() / 100 * num;
				coupanApplied = true;

			}
		}

	}
	public double getPayableAmount() {
		double total  = getTotalAmount();
		double newtotal = total - discount;
		double tax = newtotal * 15 / 100;
		return newtotal + tax;

	}
	void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (Item s : cartarray) {
			if (s != null) {
				if (s.quantity != 0) {
					System.out.println(s.productname + " " + s.quantity + " " + getprice(s));
				}
			}
		}
		double total  = getTotalAmount();
		double newtotal = total - discount;
		double tax = newtotal * 15 / 100;
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}



}
////////////////////////////////////////////////////
