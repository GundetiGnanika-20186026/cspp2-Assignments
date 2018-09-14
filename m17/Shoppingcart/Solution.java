import java.util.Scanner;
/**
 * main class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
    System.out.println("totalAmount: " + obj.getTotalAmount());
                break;
            case "payableAmount":
    System.out.println("Payable amount: " + obj.getPayableAmount());
                break;
            case "print":
                obj.printInvoice();
                break;
            default:


            }
        }
    }
}
