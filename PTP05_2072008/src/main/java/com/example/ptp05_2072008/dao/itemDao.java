package com.example.ptp05_2072008.dao;

import com.example.ptp05_2072008.model.Category;
import com.example.ptp05_2072008.model.Item;
import com.example.ptp05_2072008.util.utilConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class itemDao implements interfaceDao<Item>{
    Connection conn = utilConnection.getConnection();
    @Override
    public ObservableList getData() {
        ObservableList<Item> itemList;
        itemList = FXCollections.observableArrayList();
        String sqlQuerry = "SELECT i.idItem, i.nama, i.price, i.description, k.idKategori, k.kategori as namaKategori FROM item i JOIN kategori k ON i.kategori_idKategori = k.idKategori ORDER BY i.idItem ASC;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuerry);
            ResultSet hasilItem = ps.executeQuery();
            while(hasilItem.next()){
                int idItem = hasilItem.getInt("idItem");
                String namaItem = hasilItem.getString("nama");
                double priceItem = hasilItem.getDouble("price");
                String descItem = hasilItem.getString("description");
                int idKat = hasilItem.getInt("idKategori");
                String namaKat = hasilItem.getString("namaKategori");
                Category kategori = new Category(idKat, namaKat);
                Item item = new Item(idItem, namaItem, priceItem, descItem, kategori);
                itemList.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemList;
    }

    @Override
    public void setData(Item data) {
        String sqlQuerry = "INSERT INTO item (idItem, nama, price, description, kategori_idKategori) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuerry);
            ps.setInt(1, data.getId());
            ps.setString(2, data.getNama());
            ps.setDouble(3, data.getPrice());
            ps.setString(4, data.getDesc());
            ps.setInt(5, data.getCategory().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delData(Item data) {
        String sqlQuerry = "DELETE FROM item WHERE idItem = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuerry);
            ps.setInt(1, data.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void upData(Item data) {
        String sqlQuerry = "UPDATE item SET nama = ?, price = ?, description = ?, kategori_idKategori = ? WHERE idItem = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuerry);
            ps.setString(1, data.getNama());
            ps.setDouble(2, data.getPrice());
            ps.setString(3, data.getDesc());
            ps.setInt(4, data.getCategory().getId());
            ps.setInt(5, data.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
