package com.example.ap_assignment_4;

import java.util.Scanner;

public class customer extends user{

    private menu menu;
    private cart cart;
    orderhistory history = new orderhistory();
    order order = new order();
    Scanner sc = new Scanner(System.in);

    public customer(String username,menu menu,cart cart,order order){
        super(username);
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }


    public void display(Scanner scanner){
        boolean running = true;
        while (running){
        System.out.println("1. View menu\n2. Search\n" +
                "3. Add items\n4. Remove items\n5. View total\n6. Checkout process\n" +
                "7. View cart\n8. View order status\n9. cancel order\n10. order history\n11. Save cart\n" +
                "12. Load cart\n13. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();


        switch (choice){
            case 1:
                System.out.println("\n");
                menu.displaymenu();
                System.out.println("\n");
                break;

            case 2:
                System.out.println("search the item you're looking for: ");
                String item = scanner.nextLine();
                double price = menu.getprice(item);
                if(menu.isavailable(item)){
                    System.out.println("\n");
                    System.out.println(item + " is available in the menu at $"+ price);
                    System.out.println("\n");
                }
                else System.out.println("Item not found");
                break;

            case 3:
                menu.displaymenu();
                System.out.println("Select the item to add: ");
                String itemname = scanner.nextLine();
                System.out.println("\n");
                cart.additem(itemname);
                System.out.println("\n");
                break;

            case 4:
                System.out.println("Enter the item to remove: ");
                String name = scanner.nextLine();
                cart.removeitem(name);
                break;

            case 5:
                double total = cart.carttotal();
                System.out.println("Your cart total is : $"+total);
                break;

            case 6:
                System.out.println("Enter the item name: ");
                String itemn = scanner.nextLine();
                if(menu.isavailable(itemn)) {
                    System.out.println("Want to add in the cart (Y/N): ");
                    String select = scanner.next();
                    if (select.equals("Y") || select.equals("y")) {
                        double priceitem = menu.getprice(itemn);
                        order order = new order(itemn, priceitem);
                        history.addorder(order);
                        System.out.println(itemn + " added at $" + priceitem);
                        order.checkout();
                        System.out.println("order placed for "+itemn+" at $"+menu.getprice(itemn));
                        history.savehistory(username);
                    } else {
                        System.out.println("Thank you for visiting Byte Me");
                        System.out.println("Visit again :)");
                    }
                }

                else {
                System.out.println(itemn+" not available in the menu. Try again");
                }
                break;

            case 7:
                cart.viewcart();
                break;

            case 8:
                int status;
                if(history==null){
                    status = 0;
                }
                else System.out.println("Placed");
                break;

            case 9:
                history.addorder(order);
                System.out.println("order cancelled");
                break;

            case 10:
                history.showhistory();
                break;

            case 11:
                cart.savecart();
                break;

            case 12:
                cart.loadcart();
                break;

            case 13:
                running = false;
                System.out.println("Exiting...");
                break;

            }
        }
    }
}