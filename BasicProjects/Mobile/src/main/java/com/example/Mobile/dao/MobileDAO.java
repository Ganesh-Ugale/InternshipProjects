package com.example.Mobile.dao;

import com.example.Mobile.entity.Mobile;

import java.util.List;

public interface MobileDAO {

    public void save(Mobile theMobile);
    public Mobile fetchByID(int byID);
    public List<Mobile> fetchAll();
    public void update(int byID);
    public void remove(int byID);

}
