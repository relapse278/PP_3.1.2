package com.example.PP_312.service;

import com.example.PP_312.model.Car;
import java.util.List;

public interface CarService {
    List<Car> getCarList(int count);
}