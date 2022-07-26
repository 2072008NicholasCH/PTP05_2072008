package com.example.ptp05_2072008.dao;

import com.example.ptp05_2072008.model.Category;
import com.example.ptp05_2072008.util.utilConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class categoryDao implements interfaceDao <Category>{
    Connection conn = utilConnection.getConnection();
    @Override
    public ObservableList getData() {
        ObservableList<Category> katList;
        katList = FXCollections.observableArrayList();
        String sqlQuerry = "SELECT * FROM kategori;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuerry);
            ResultSet hasilKategori = ps.executeQuery();
            while (hasilKategori.next()){
                int id = hasilKategori.getInt("idKategori");
                String kategoriNama = hasilKategori.getString("kategori");
                Category kategori = new Category(id, kategoriNama);
                katList.add(kategori);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return katList;
    }

    @Override
    public void setData(Category data) {

        String sqlQuerry = "INSERT INTO kategori(idKategori, kategori) VALUES(?, ?);";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuerry);
            ps.setInt(1, data.getId());
            ps.setString(2, data.getNama());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delData(Category data) {

    }

    @Override
    public void upData(Category data) {

    }
}
