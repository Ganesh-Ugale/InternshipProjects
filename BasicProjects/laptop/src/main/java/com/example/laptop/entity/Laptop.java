package com.example.laptop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lap_id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "imie")
    private long imie;

    @Column(name = "memory")
    private int memory;

    @Column(name = "storage")
    private int storage;

    @Column(name = "generation")
    private String generation;

    @Column(name = "processor")
    private String processor;

    @Column(name = "price")
    private double price;

    public Laptop(){}

    public Laptop(String brand, String model, long imie, int memory,
                  int storage, String generation, String processor, double price) {
        this.brand = brand;
        this.model = model;
        this.imie = imie;
        this.memory = memory;
        this.storage = storage;
        this.generation = generation;
        this.processor = processor;
        this.price = price;
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

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getImie() {
        return imie;
    }

    public void setImie(long imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", imie=" + imie +
                ", memory=" + memory +
                ", storage=" + storage +
                ", generation='" + generation + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                '}';
    }
}
