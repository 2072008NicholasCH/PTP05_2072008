package com.example.ptp05_2072008.controller;

import com.example.ptp05_2072008.dao.categoryDao;
import com.example.ptp05_2072008.dao.itemDao;
import com.example.ptp05_2072008.model.Category;
import com.example.ptp05_2072008.model.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class kategoriController {
    private ObservableList<Category> katList;

    @FXML
    public TextField txtId;
    @FXML
    public TextField txtName;
    @FXML
    public Button btnSave;
    public TableView tableView;
    @FXML
    public TableColumn colId;
    @FXML
    public TableColumn colKat;

    private ObservableList <Item> itemList;
    categoryDao katDao = new categoryDao();
    itemDao itemDao = new itemDao();
    @FXML
    private Stage stage;
    @FXML
    private FXMLLoader fxmlLoader;

    public void tampilan(){
        katList = katDao.getData();
        tableView.setItems(katList);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colKat.setCellValueFactory(new PropertyValueFactory<>("nama"));

    }

    public void initialize(){
        tampilan();
    }

    public void addData(ActionEvent actionEvent) {
        if((txtId.getText().equals("") || (txtName.getText().equals("")))){
            alert();
        }else {
            katDao.setData(new Category(Integer.parseInt(txtId.getText()), txtName.getText()));
            reset();
        }
        tampilan();
    }

    public void alert (){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please Fill the Field Properly", ButtonType.OK);
        alert.showAndWait();
    }

    public void reset(){
        txtName.clear();
        txtId.clear();

    }

    public ObservableList<Category> getKatList() {
        return katList;
    }

    public void setKatList(ObservableList<Category> katList) {
        this.katList = katList;
    }
}
