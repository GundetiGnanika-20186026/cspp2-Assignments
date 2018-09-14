import java.util.Scanner;
/**
 * Class for item.
 */
class Item {
	String productname;
	int quantity;
	double unitprice;
	/**
	 * Constructs the object.
	 *
	 * @param      pname     The pname
	 * @param      qmeasure  The qmeasure
	 * @param      umoney    The umoney
	 */
	Item(String pname, String qmeasure, String umoney) {
		this.productname = pname;
		this.quantity = Integer.parseInt(qmeasure);
		this.unitprice = Double.parseDouble(umoney);
	}
	/**
	 * Constructs the object.
	 *
	 * @param      pname     The pname
	 * @param      qmeasure  The qmeasure
	 */
	Item(String pname, String qmeasure) {
		this.productname = pname;
		this.quantity = Integer.parseInt(qmeasure);
	}
	/**
	 * equals method.
	 *
	 * @param      other  The other
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean equals(Item other) {
		if (this.productname.equals(other.productname)) {
			return true;

		}
		return false;

	}
}
/**
 * Class for shoppingcart.
 */
class Shoppingcart {
	Item[] catalogarray;
	Item[] cartarray;
	int sizecatalog;
	int sizecart;
	String[] validCoupans = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static boolean coupanApplied = false;
	/**
	 * Constructs the object.
	 */
	Shoppingcart() {
		catalogarray = new Item[50];
		cartarray = new Item[50];
		sizecatalog = 0;
		sizecart = 0;

	}
	/**
	 * Adds to catalog.
	 *
	 * @param      item  The item
	 */
	public void addToCatalog(Item item) {

		catalogarray[sizecatalog++] = item;

	}
	/**
	 * Adds to cartesian.
	 *
	 * @param      item  The item
	 */
	public void addTOCart(Item item) {
		if (!incart(item)) {
			if (checkcatalog(item)) {
				cartarray[sizecart++] = item;
			}
		}
	}
	/**
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
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
	/**
	 *checking the catalog.
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
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

	/**
	 * Removes a from cartesian.
	 *
	 * @param      item  The item
	 */


	public void removeFromCart(Item item) {
		for (int i = 0; i < sizecart; i++) {
			if (item.equals(cartarray[i])) {
				cartarray[i].quantity = cartarray[i].quantity - item.quantity;
			}
		}

	}

	/**
	 * Shows the cartesian.
	 */

	public void showCart() {
		for (Item i : cartarray) {
			if ( i != null ) {
				if (i.quantity != 0) {
					System.out.println(i.productname + " " + i.quantity);
				}

			}
		}

	}
	/**
	 * Shows the catalog.
	 */
	public void showCatalog() {
		for (Item i : catalogarray) {
			if (i != null) {
				System.out.println(i.productname + " " + i.quantity + " " + i.unitprice);
			}
		}
	}

	/**
	 * Gets the total amount.
	 *
	 * @return     The total amount.
	 */
	public double getTotalAmount() {
		double total = 0;
		for (int i = 0; i < sizecart; i++) {
			total += cartarray[i].quantity * getprice(cartarray[i]);
		}
		return total;

	}
	/**
	 * gets the price.
	 *
	 * @param      given  The given
	 *
	 * @return     { description_of_the_return_value }
	 */
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

	/**
	 * applying the coupon.
	 *
	 * @param      cou   The cou
	 */
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
	/**
	 * Gets the payable amount.
	 *
	 * @return     The payable amount.
	 */
	public double getPayableAmount() {
		double total  = getTotalAmount();
		double newtotal = total - discount;
		double tax = newtotal * 15 / 100;
		return newtotal + tax;

	}
	/**
	 * printing the required fields.
	 */
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
