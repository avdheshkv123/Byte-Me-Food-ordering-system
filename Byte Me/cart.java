package com.example.ap_assignment_4;

import java.io.*;
import java.util.ArrayList;

public class cart{
    ArrayList<String> cart = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    private menu menu;

    cart(menu menu){
        this.menu = menu;
    }


    public void viewcart(){
        if(cart.isEmpty()){
            System.out.println("There is nothing to see here!!!");
            System.out.println("\n");
        }
        else {
            System.out.println("Items in the cart: ");
            for (String item : cart) {
                System.out.println(item);
            }
            System.out.println("\n");
        }
    }


    public double carttotal(){
        if(items.isEmpty()) {
            System.out.println("Total is nill since no item is in the cart");
        }
        double total = 0;
        for(String item: items){
            total+=menu.getprice(item);
        }
        return total;
    }

    public void additem(String itemname){
        if(menu.isavailable(itemname)) {
            items.add(itemname);
            cart.add(itemname);
            System.out.println(itemname + " added to your cart");
        }
        else {
            System.out.println("Item is not available");
        }
    }


    public void removeitem(String item){
        if(cart.contains(item)){
            cart.remove(item);
            System.out.println("Item removed");
            System.out.println("\n");
        }
        else System.out.println("Item not found in the cart");
        System.out.println("\n");
    }

    public void savecart(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cart.txt"))){
            for(String item: cart){
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
            System.out.println("Cart saved successfully");
        }
        catch (IOException e){
            System.err.println("Error saving cart"+e.getMessage());
        }
    }

    public void loadcart(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("cart.txt"))){
            System.out.println("Cart loaded successfully");
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find saved card");
        }
        catch (IOException e){
            System.err.println("Error in loading cart"+e.getMessage());
        }
        cart.clear();
    }

}