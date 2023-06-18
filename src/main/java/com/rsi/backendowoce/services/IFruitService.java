package com.rsi.backendowoce.services;

import com.rsi.backendowoce.domain.Fruit;
import com.rsi.backendowoce.domain.FruitDTO;

import java.util.List;

public interface IFruitService {
    List<Fruit> getAllFruits();
    Fruit getFruitById(Long id);
    Fruit saveFruit(Fruit fruit);
    void updateFruit(Fruit fruit);
    Fruit saveFruit(FruitDTO fruit);
    void updateFruit(Long id, FruitDTO fruit);
    void deleteFruitById(Long id);
    int getFruitsCount();
}
