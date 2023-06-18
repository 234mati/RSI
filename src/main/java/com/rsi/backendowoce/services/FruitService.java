package com.rsi.backendowoce.services;

import com.rsi.backendowoce.domain.Fruit;
import com.rsi.backendowoce.domain.FruitDTO;
import com.rsi.backendowoce.exceptions.FruitAlreadyExistsException;
import com.rsi.backendowoce.exceptions.FruitNotFoundException;
import com.rsi.backendowoce.exceptions.NonPositivePriceException;
import com.rsi.backendowoce.exceptions.NonPositiveWeightException;
import com.rsi.backendowoce.repositories.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService implements IFruitService {
    FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getFruitById(Long id) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if (fruitData.isPresent()) {
            return fruitData.get();
        } else {
            throw new FruitNotFoundException("Fruit with id '" + id + "' does not exist");
        }
    }

    private void validateFruit(Fruit fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null");
        }

        if (fruit.getPrice() < 0.0) {
            throw new NonPositivePriceException("Fruit price cannot be negative");
        }

        if (fruit.getWeight() < 0.0) {
            throw new NonPositiveWeightException("Fruit weight cannot be negative");
        }

        if (fruit.getName() == null || fruit.getName().isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be empty");
        }

        if (fruitRepository.existsByNameAndColorAndWeightAndPrice(fruit.getName(), fruit.getColor(), fruit.getWeight(), fruit.getPrice())) {
            throw new FruitAlreadyExistsException("Fruit with name '" + fruit.getName() + "' already exists");
        }
    }

    private FruitDTO mapFruitToDTO(Fruit fruit) {
        FruitDTO fruitDTO = new FruitDTO();
        fruitDTO.setName(fruit.getName());
        fruitDTO.setColor(fruit.getColor());
        fruitDTO.setWeight(fruit.getWeight());
        fruitDTO.setPrice(fruit.getPrice());
        return fruitDTO;
    }

    private Fruit mapFruitDTOToFruit(FruitDTO fruitDTO) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitDTO.getName());
        fruit.setColor(fruitDTO.getColor());
        fruit.setWeight(fruitDTO.getWeight());
        fruit.setPrice(fruitDTO.getPrice());
        return fruit;
    }

    @Override
    public Fruit saveFruit(Fruit fruit) {
        validateFruit(fruit);
        return fruitRepository.save(fruit);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        Optional<Fruit> fruitData = fruitRepository.findById(fruit.getId());

        if (fruitData.isPresent()) {
            validateFruit(fruit);
            Fruit _fruit = fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setColor(fruit.getColor());
            _fruit.setPrice(fruit.getPrice());
            fruitRepository.save(_fruit);
        } else {
            throw new FruitNotFoundException("Fruit with id '" + fruit.getId() + "' does not exist");
        }
    }

    @Override
    public Fruit saveFruit(FruitDTO fruit) {
        Fruit fruitToSave = mapFruitDTOToFruit(fruit);
        return saveFruit(fruitToSave);
    }

    @Override
    public void updateFruit(Long id, FruitDTO fruit) {
        Fruit fruitToUpdate = mapFruitDTOToFruit(fruit);
        fruitToUpdate.setId(id);
        updateFruit(fruitToUpdate);
    }

    @Override
    public void deleteFruitById(Long id) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if (fruitData.isPresent()) {
            fruitRepository.deleteById(id);
        } else {
            throw new FruitNotFoundException("Fruit with id '" + id + "' does not exist");
        }
    }

    @Override
    public int getFruitsCount() {
        return fruitRepository.findAll().size();
    }
}
