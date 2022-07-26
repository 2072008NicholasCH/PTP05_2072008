package com.example.ptp05_2072008.model;

public class Item {
    private int id;
    private String nama;
    private double price;
    private String desc;
    private Category category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item(int id, String nama, double price, String desc, Category category) {
        this.id = id;
        this.nama = nama;
        this.price = price;
        this.desc = desc;
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
