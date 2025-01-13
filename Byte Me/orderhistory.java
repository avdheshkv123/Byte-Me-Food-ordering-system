package com.example.ap_assignment_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class orderhistory{

    private ArrayList<order> orderhistory = new ArrayList<>();

    public ObservableList<order> getpendingorders(){
        ObservableList<order> pendingorders = FXCollections.observableArrayList();
        for(order o: orderhistory){
            if(!o.iscompleted()){
                pendingorders.add(o);
            }
        }
        return pendingorders;

    }


    public void addorder(order order){

        orderhistory.add(order);
    }


    public void checkpendingorders() {

        System.out.println("There is no pending orders");
    }


    public void showhistory() {
            if (orderhistory.isEmpty()) {
                System.out.println("No order placed yet :)");
            } else {
                for (order item : orderhistory) {
                    System.out.println(item);
                }
            }
    }

    public void savehistory(String username){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(username+"order_history.txt"))){
            for(order o: orderhistory){
                bufferedWriter.write(o.toString());
                bufferedWriter.newLine();
            }
            System.out.println("order history saved");

        } catch(IOException e){
            System.err.println("Error in saving order history"+e.getMessage());
        }
    }

    public void loadhistory(String username) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(username + "order_history.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing order history for the user");
        } catch (IOException e) {
            System.err.println("Error in reading order history"+e.getMessage());
        }
    }

}