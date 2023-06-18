package com.rsi.backendowoce.controllers;

import com.rsi.backendowoce.domain.Fruit;
import com.rsi.backendowoce.domain.FruitAppInfoDTO;
import com.rsi.backendowoce.domain.FruitDTO;
import com.rsi.backendowoce.services.FruitService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FruitController {
    FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/fruits")
    @Operation(summary = "Pobierz wszystkie owoce")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();

        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }

//    filtruj owoce po nazwie
    @GetMapping("/fruits/filter/{name}")
    @Operation(summary = "Pobierz wszystkie owoce o danej nazwie")
    public ResponseEntity<List<Fruit>> getAllFruitsByName(@PathVariable String name) {
        List<Fruit> fruits = fruitService.getAllFruits();
        List<Fruit> filteredFruits = fruits.stream()
                .filter(fruit -> fruit.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        return new ResponseEntity<>(filteredFruits, HttpStatus.OK);
    }

    @GetMapping("/fruits/{id}")
    @Operation(summary = "Pobierz owoc po id")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        Fruit fruit = fruitService.getFruitById(id);

        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @PostMapping("/fruits")
    @Operation(summary = "Zapisz owoc")
    public ResponseEntity<Fruit> saveFruit(@RequestBody FruitDTO fruit) {
        Fruit fruitSaved = fruitService.saveFruit(fruit);

        return new ResponseEntity<>(fruitSaved, HttpStatus.OK);
    }

    @PutMapping("/fruits/{id}")
    @Operation(summary = "Zaktualizuj owoc")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Long id, @RequestBody FruitDTO fruit) {
        fruitService.updateFruit(id, fruit);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/fruits/{id}")
    @Operation(summary = "Usuń owoc po id")
    public ResponseEntity<Fruit> deleteFruitById(@PathVariable Long id) {
        fruitService.deleteFruitById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/fruits/count")
    @Operation(summary = "Pobierz liczbę owoców")
    public ResponseEntity<Integer> getFruitsCount() {
        int fruitsCount = fruitService.getFruitsCount();

        return new ResponseEntity<>(fruitsCount, HttpStatus.OK);
    }

    @GetMapping("/fruits/authors")
    @Operation(summary = "Pobierz autorów")
    public ResponseEntity<FruitAppInfoDTO> getAuthors() {
        FruitAppInfoDTO authors = new FruitAppInfoDTO();
        authors.setAuthorsNames("Wiktor Jeżowski, Mateusz Pietrych");

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
