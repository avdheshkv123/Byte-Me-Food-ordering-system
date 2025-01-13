package com.example.ap_assignment_4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainapp extends Application {

    @Override
    public void start(Stage stage) {
        menu menu = new menu();

        ListView<String> menuList = new ListView<>();
        ObservableList<MenuItem> menuItems = menu.getmenuitems();
        for (MenuItem menuItem : menuItems) {
            menuList.getItems().add(menuItem.getName() + " - $" + menuItem.getPrice());
        }

        ListView<String> pendingOrdersList = new ListView<>();
        pendingOrdersList.getItems().add("pizza");
        pendingOrdersList.getItems().add("burger");
        pendingOrdersList.getItems().add("coffee");

        //layout
        Tab menuTab = new Tab("Menu");
        menuTab.setContent(menuList);
        menuTab.setClosable(false);

        Tab ordersTab = new Tab("Pending Orders");
        ordersTab.setContent(pendingOrdersList);
        ordersTab.setClosable(false);

        TabPane tabPane = new TabPane(menuTab, ordersTab);

        BorderPane pane = new BorderPane();
        pane.setCenter(tabPane);

        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Canteen Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
