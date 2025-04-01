package com.example.api_rest.controller;

import com.example.api_rest.model.Carros;
import com.example.api_rest.service.CarrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    private final CarrosService carrosService;

    public CarrosController(CarrosService carrosService) {
        this.carrosService = carrosService;
    }

    @GetMapping
    public List<Carros> getAllCars() {
        return carrosService.getAllcars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carros> getCarById(@PathVariable Long id) {
        Optional<Carros> api = carrosService.getCarById(id);
        return api.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carros createCar(@RequestBody Carros api) {
        return carrosService.saveCar(api);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carros> updateCar(@PathVariable Long id, @RequestBody Carros api) {
        Carros updatedCar = carrosService.updateCar(id, api);
        return ResponseEntity.ok(updatedCar);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carrosService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
