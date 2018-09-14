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
		if (checkcatalog(item)) {
			cartarray[sizecart++] = item;
		}
	}

	private boolean checkcatalog(Item given) {
		for (Item i : catalogarray) {
			if (i != null) {
				if (i.productname.equals(given.productname)) {
					if (given.quantity <= i.quantity) {
						i.quantity = i.quantity - given.quantity;
						return true;
					}


				}
			}
		}
		return false;
	}




	public void removeFromCart(Item item) {

	}
	public void showCart() {
		for (int i = 0; i < sizecart; i++) {
			System.out.println(cartarray[i].productname + " " + cartarray[i].quantity);
		}

	}
	public void showCatalog() {
		for (int i = 0; i < sizecatalog; i++) {
			System.out.println(catalogarray[i].productname + " " + catalogarray[i].quantity + " " + catalogarray[i].unitprice);
		}
	}


	public double getTotalAmount() {
		double total = 0;
		for (int i = 0; i < sizecart; i++) {
			total = cartarray[i].quantity * getprice(cartarray[i]);
		}
		return total;

	}

	double getprice(Item given) {
		for (Item i : catalogarray) {
			if (i != null) {
				if (i.productname.equals(given.productname)) {
					if (given.quantity <= i.quantity) {
						i.quantity = i.quantity - given.quantity;
						return i.unitprice;

					}

				}
			}
		}
		return 0.0;
	}


	public void applyCoupen(String cou) {
		if (coupanApplied) {
			System.out.println("Invalid coupon");
			return;
		}
		boolean valid = false;
		for (String s : validCoupans) {
			if (s.equals(cou)) {
				int num = Integer.parseInt(cou.substring(3));
				discount = getTotalAmount() * num / 100;
				coupanApplied = true;
				valid = true;
			}
		}

	}
	// public double getPayableAmount(){

	// }



}
////////////////////////////////////////////////////
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Shoppingcart obj = new Shoppingcart();
		Scanner scn = new Scanner(System.in);
		while (scn.hasNext()) {
			String[] tokens = scn.nextLine().split(" ", 2);
			switch (tokens[0]) {
			case "Item":
				String[] items = tokens[1].split(",");
				Item itemobj = new Item(items[0], items[1], items[2]);
				obj.addToCatalog(itemobj);
				break;
			case "catalog":
				obj.showCatalog();
				break;
			case "add":
				String[] items1 = tokens[1].split(",");
				Item itemobj1 = new Item(items1[0], items1[1]);
				obj.addTOCart(itemobj1);
				break;
			case "show":
				obj.showCart();
				break;
			case "remove":
				String[] items2 = tokens[1].split(",");
				Item itemobj2 = new Item(items2[0], items2[1]);
				obj.removeFromCart(itemobj2);
				break;
			case "coupon":
				obj.applyCoupen(tokens[1]);
				break;

			case "totalAmount":
				obj.getTotalAmount();
				break;
			// case "payableAmount":
			// 	obj.getPayableAmount();
			// 	break;
			case "print":

				break;


			default:


			}
		}
	}
}