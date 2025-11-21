import java.util.ArrayList;
import java.util.Scanner;

// Product Class
class Product {
private String name;
private double price;

Product(String name, double price) {
    this.name = name;
    this.price = price;
}

public String getName() { return name; }
public double getPrice() { return price; }
}

// Cart Item Class
class CartItem {
Product product;
int quantity;

CartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
}

public double getTotal() {
    return product.getPrice() * quantity;
}
}

// Billing System Class
class BillingSystem {
ArrayList cart = new ArrayList<>();

public void addItem(Product p, int qty) {
    cart.add(new CartItem(p, qty));
    System.out.println("✔ Added " + qty + " x " + p.getName());
}

public void showBill() {
    double total = 0;
    System.out.println("\n===== 🛒 GROCERY SHOP BILL =====");

    System.out.printf("%-15s %-10s %-10s\n", "Item", "Qty", "Total");
    System.out.println("------------------------------------");

    for (CartItem item : cart) {
        System.out.printf("%-15s %-10d %-10.2f\n",
            item.product.getName(),
            item.quantity,
            item.getTotal());

        total += item.getTotal();
    }

    System.out.println("------------------------------------");
    System.out.printf("TOTAL BILL: ₹ %.2f\n", total);
    System.out.println("====================================\n");
}
}

// Main Class
public class GroceryBilling {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
BillingSystem bill = new BillingSystem();

    // Sample products (You can add more)
    Product rice = new Product("Rice", 55.0);
    Product sugar = new Product("Sugar", 45.0);
    Product oil = new Product("Oil", 120.0);
    Product milk = new Product("Milk", 30.0);

    while (true) {
        System.out.println("\n1) Add Rice");
        System.out.println("2) Add Sugar");
        System.out.println("3) Add Oil");
        System.out.println("4) Add Milk");
        System.out.println("5) Generate Bill");
        System.out.println("6) Exit");
        System.out.print("Choose: ");

        int choice = sc.nextInt();
        if (choice == 6) break;

        switch (choice) {
            case 1:
                System.out.print("Enter quantity: ");
                bill.addItem(rice, sc.nextInt());
                break;

            case 2:
                System.out.print("Enter quantity: ");
                bill.addItem(sugar, sc.nextInt());
                break;

            case 3:
                System.out.print("Enter quantity: ");
                bill.addItem(oil, sc.nextInt());
                break;

            case 4:
                System.out.print("Enter quantity: ");
                bill.addItem(milk, sc.nextInt());
                break;

            case 5:
                bill.showBill();
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
    sc.close();
}
}
