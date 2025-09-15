package com.example.Mobile.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mobile")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "imei")
    private long imei;

    @Column(name = "price")
    private double price;

    @Column(name = "processor")
    private String processor;

    @Column(name = "type")
    private String type;

    @Column(name = "ram(GB)")
    private int ram;

    @Column(name = "storage(GB)")
    private int storage;

    public Mobile() {}

    public Mobile(String brand, String model, long imei, double price, String processor, String type, int ram, int storage) {
        this.brand = brand;
        this.model = model;
        this.imei = imei;
        this.price = price;
        this.processor = processor;
        this.type = type;
        this.ram = ram;
        this.storage = storage;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", imei=" + imei +
                ", price=" + price +
                ", processor='" + processor + '\'' +
                ", type='" + type + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                '}';
    }
}
