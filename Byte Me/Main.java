package com.example.ap_assignment_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu menu = new menu();
        cart cart = new cart(menu);
        order order = new order();
        orderhistory history = new orderhistory();

        System.out.println("------ Welcome to the 'Byte ME' - a food ordering system ------");
        System.out.println("Select the user type\n1. Admin\n2. Customer\n3. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        admin ad = new admin("admin",menu,history);
        customer c = new customer("customer",menu,cart,order);
        switch (choice) {
            case 1:
                System.out.println("Enter username: ");
                String username = sc.next();
                if(ad.check_credentials(username)) {
                    System.out.println("Login successfully as Admin!!!");
                    ad.display(sc);
                }
                else {
                    System.out.println("Invalid login credentials. Try again");
                }
                break;


            case 2:
                System.out.println("Enter username: ");
                String Username = sc.next();
                if(c.check_credentials(Username)) {
                    System.out.println("Login successfully as Customer!!!\n");
                    System.out.println("Your order history");
                    history.loadhistory(Username);
                    c.display(sc);
                }
                else {
                    System.out.println("Invalid login credentials. Try again");
                }
                break;

            case 3:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

    }
}