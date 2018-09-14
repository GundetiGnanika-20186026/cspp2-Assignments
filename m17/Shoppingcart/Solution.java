import java.util.Scanner;
////////////////////////////////////////////////////////////////////////////
class Item {
	String productname;
	int quantity;
	double unitprice;
	Item(String pname,int qmeasure,double umoney) {
       this.productname = pname;
       this.quantity = qmeasure;
       this.unitprice = umoney;
	}
}
/////////////////////////////////////////////////////////////////////
// class Cartitem{
//    String productname;
//    int
// }









class Shoppingcart {
	Item[] catalogarray;
	Item[] cartarray;
    int sizecatalog;
	int sizecart;
	Shoppingcart(){
		catalogarray = new Item[50];
		cartarray = new Item[50];
		sizecatalog = 0;
		sizecart = 0;

	}
	public void addToCatalog(Item item){
		catalogarray[sizecatalog++] = item;

	}
	// public void addTOCart(Item item){
	// 	cartarray[sizecart++] = item;

 //    }
	// // public void removeFromCart(Item item){

	// }
	// public void showCart(){

	// }
	 public void showCatalog(){
	 for(int i = 0; i < sizecatalog; i++){
			System.out.println(catalogarray[i].productname+" "+catalogarray[i].quantity+" "+catalogarray[i].unitprice);
		}
	}

	// }
	// public double getTotalAmount(){

	// }
	// public double getPayableAmount(){

	// }



}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Shoppingcart obj = new Shoppingcart();
		Scanner scn = new Scanner(System.in);
        while(scn.hasNext()){
        	String[] tokens = scn.nextLine().split(" ",2);
        	switch(tokens[0]){
        		case "Item":
        		String[] items = tokens[1].split(",");
        		Item itemobj = new Item(items[0],Integer.parseInt(items[1]),Double.parseDouble(items[2]));
                obj.addToCatalog(itemobj);
                break;
        		case "catalog":
        		obj.showCatalog();
        		break;

        		default:


        	}
        }
	}
}