package com.example.ap_assignment_4;

import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class menu{
    private Map<String,Double> items = new HashMap<>();

    menu(){
        items.put("pizza",4.9);
        items.put("coffee",1.0);
        items.put("burger",3.2);
        items.put("french fries",0.5);
        items.put("momos",1.2);
        items.put("cheese rolls",1.5);
        items.put("veg maggie",0.7);
        items.put("cheese pasta",0.6);
        items.put("pepsi",0.4);
        items.put("coke",0.4);
    }

    public ObservableList<MenuItem> getmenuitems(){
        ObservableList<MenuItem> menuItems= FXCollections.observableArrayList();
        for(String name: items.keySet()){
            menuItems.add(new MenuItem(name,items.get(name)));
        }
        return menuItems;

    }

    public void displaymenu(){
        System.out.println("Menu: ");
        System.out.println("--------------");
        for(String item: items.keySet()){
            System.out.println(item + " - $"+items.get(item));
        }
        System.out.println("\n");

    }

    public boolean isavailable(String item){
        return items.containsKey(item);
    }

    public double getprice(String item){
        return items.getOrDefault(item,0.0);
    }

    public void addnewitem(String item,double price){
        items.put(item,price);
        System.out.println(item+" added to the menu at price $"+price);
    }

    public void removeitem(String itemname){
        if(items.containsKey(itemname)){
            items.remove(itemname);
            System.out.println(itemname + " removed from the menu");
        }
        else {
            System.out.println(itemname+ " not found in the menu");
        }
    }

    public void updateitem(String olditem, String newitem){
        if(items.containsKey(olditem)){
            double price = items.get(olditem);
            items.remove(olditem);
            items.put(newitem,price);
            System.out.println("Item name updated from "+olditem+" to "+newitem);
        }
        else {
            System.out.println("Item not found");
        }
    }

    public void updateprice(String itemname, double newprice){
        if(items.containsKey(itemname)){
            items.put(itemname,newprice);
            System.out.println("Price of "+itemname+" updated to $"+newprice);
        }
        else {
            System.out.println("Item not found");
        }
    }


}