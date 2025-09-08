package com.example.laptop.dao;

import com.example.laptop.entity.Laptop;

public interface LaptopDAO {

    public void save(Laptop theLaptop);
    public Laptop findByID(int id);
    public Laptop findByIMIE(long imie);
    public void update(int id);
    public void remove(int id);

}
