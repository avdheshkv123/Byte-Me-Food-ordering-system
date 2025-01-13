package com.example.ap_assignment_4;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class ordersscreen {
    private StackPane pane;

    public ordersscreen(orderhistory orderHistory) {
        pane = new StackPane();
        pane.setPadding(new Insets(10));

        TableView<order> table = new TableView<>();

        TableColumn<order, String> itemColumn = new TableColumn<>("Item Name");
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<order, String> pricecolumn = new TableColumn<>("price");
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(itemColumn, pricecolumn);
        table.setItems(orderHistory.getpendingorders());

        pane.getChildren().add(table);
    }

    public StackPane getPane() {
        return pane;
    }
}
