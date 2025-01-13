package com.example.ap_assignment_4;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class menuscreen {
    private StackPane pane;

    public menuscreen(menu menu) {
        pane = new StackPane();
        pane.setPadding(new Insets(10));

        TableView<MenuItem> table = new TableView<>();
        TableColumn<MenuItem, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MenuItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(nameColumn, priceColumn);
        table.setItems(menu.getmenuitems());

        pane.getChildren().add(table);
    }

    public StackPane getPane(){
        return pane;
    }

}
