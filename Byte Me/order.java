package com.example.ap_assignment_4;

import java.util.Scanner;

public class order{
    private String itemname;
    private double itemprice;
    private String Status;
    Scanner sc = new Scanner(System.in);

    order(){

    }
    order(String itemname,double itemprice){
        this.itemprice = itemprice;
        this.itemname = itemname;
        this.Status = "placed";
    }

    public void checkout(){
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your card number: ");
        String cardnumber = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Your order is out for delivery\nOrder details-\nName: "+name+" address: "+address);
    }

    public boolean iscompleted(){
        return "completed".equalsIgnoreCase(Status);
    }

    public String toString(){
        return "Order: "+itemname+" , price: "+itemprice+" Status: "+Status;
    }
}