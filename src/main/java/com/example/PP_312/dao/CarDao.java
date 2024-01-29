package com.example.PP_312.dao;

import com.example.PP_312.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCarList(int count);
}