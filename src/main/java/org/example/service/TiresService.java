package org.example.service;

import org.example.Entity.Tires;
import org.example.Entity.Vehicle;

import java.util.List;

public interface TiresService {

    List<Tires> findAll();
    Tires findOne(String id);
    Tires create(Tires tire);

    Tires update(String id, Tires tires);

    void delete(String id);
}
