import java.util.*;

public class GroceryException {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Prices
    int ricePrice = 55;
    int sugarPrice = 45;
    int oilPrice = 120;

    int riceQty = 0, sugarQty = 0, oilQty = 0;

    while (true) {
        try {

            System.out.println("\n1) Add Rice");
            System.out.println("2) Add Sugar");
            System.out.println("3) Add Oil");
            System.out.println("4) Generate Bill");
            System.out.println("5) Exit");
            System.out.print("Choose option: ");

            if (!sc.hasNextInt()) {      // if user enters chars/symbols
                sc.next();
                throw new InputMismatchException("Bruh 😭 enter only numbers.");
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Rice qty: ");
                    riceQty = readQuantity(sc);
                    break;

                case 2:
                    System.out.print("Enter Sugar qty: ");
                    sugarQty = readQuantity(sc);
                    break;

                case 3:
                    System.out.print("Enter Oil qty: ");
                    oilQty = readQuantity(sc);
                    break;

                case 4:
                    if (riceQty == 0 && sugarQty == 0 && oilQty == 0)
                        throw new Exception("Cart empty macha 😭 add something first!");

                    int total = (riceQty * ricePrice) + (sugarQty * sugarPrice) + (oilQty * oilPrice);

                    System.out.println("\n===== BILL =====");
                    System.out.println("Rice : " + riceQty + " × " + ricePrice);
                    System.out.println("Sugar: " + sugarQty + " × " + sugarPrice);
                    System.out.println("Oil  : " + oilQty + " × " + oilPrice);
                    System.out.println("---------------");
                    System.out.println("TOTAL = ₹" + total);
                    System.out.println("===============");
                    break;

                case 5:
                    System.out.println("Bye daaa 👋");
                    return;

                default:
                    throw new Exception("Invalid option! Choose between 1–5.");
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}

// Separate method for quantity exception handling
public static int readQuantity(Scanner sc) throws Exception {

    if (!sc.hasNextInt()) {    // avoids letters/symbols
        sc.next();
        throw new InputMismatchException("Numbers only da 😭");
    }

    int qty = sc.nextInt();

    if (qty <= 0)              // avoids zero or negative qty
        throw new Exception("Quantity should be > 0!");

    return qty;
}
}
