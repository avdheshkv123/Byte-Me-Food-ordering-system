package com.example.ap_assignment_4;

import java.util.Scanner;
public class admin extends user{

    private menu menu;
    private orderhistory history;
    Scanner sc = new Scanner(System.in);

    admin(String username,menu menu,orderhistory history){
        super(username);
        this.menu = menu;
        this.history = history;
    }


    public void display(Scanner scanner){
        boolean running = true;
        while (running) {
            System.out.println("1. Add new items\n2. update existing items\n3. Remove items\n" +
                    "4. Modify price\n5. Update Availability\n6. View menu\n7. View pending orders\n" +
                    "8. Update order Status\n9. Handle Special request\n10. Daily sales report\n11. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter new item to add: ");
                    String itemname = sc.next();
                    System.out.println("Enter the price ($): ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    menu.addnewitem(itemname,price);
                    break;

                case 2:
                    System.out.println("Enter the itemname: ");
                    String olditem = sc.next();
                    System.out.println("Enter the updated name of the item: ");
                    String newitem = sc.next();
                    menu.updateitem(olditem,newitem);
                    break;

                case 3:
                    System.out.println("Enter the item name to remove from the menu: ");
                    String item = sc.next();
                    menu.removeitem(item);
                    break;

                case 4:
                    System.out.println("Enter the item name to modify price: ");
                    String itemn = sc.next();
                    System.out.println("Enter the new price for the item: ");
                    double newprice = sc.nextDouble();
                    sc.nextLine();
                    menu.updateprice(itemn,newprice);
                    break;

                case 5:
                    System.out.println("Enter the item name to update the availability: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.println(name+" is now available in the menu");
                    break;

                case 6:
                    menu.displaymenu();
                    break;

                case 7:
                    history.checkpendingorders();
                    break;

                case 8:
                    System.out.println("Order status: placed");
                    break;

                case 9:
                    System.out.println("Write some response to handle request: ");
                    String request = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Request handled");
                    break;

                case 10:
                    System.out.println("Sales report: ");
                    System.out.println("-----------------");
                    System.out.println("Item name:           qty:");
                    System.out.println("pizza                 2\nburger                3\ncoffee                5\n" +
                            "momos                 4");
                    System.out.println("Total revenue: $29.2");;
                    System.out.println("\n");
                    break;

                case 11:
                    System.out.println("Exiting...");
                    running = false;
                    break;

            }
        }
    }
}