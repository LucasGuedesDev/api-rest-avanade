package com.example.api_rest.service;

import com.example.api_rest.model.Carros;
import com.example.api_rest.repository.CarrosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CarrosService {
    private final CarrosRepository carrosRepository;

    public CarrosService(CarrosRepository carrosRepository) {
        this.carrosRepository = carrosRepository;
    }

    public List<Carros> getAllcars() {
        return carrosRepository.findAll();
    }

    public Optional<Carros> getCarById(Long id) {
        return carrosRepository.findById(id);
    }

    public Carros saveCar(Carros car) {
        return carrosRepository.save(car);
    }

    public Carros updateCar(Long id, Carros car) {
        return carrosRepository.findById(id).map(existingCar -> {
            existingCar.setBrand(car.getBrand());
            existingCar.setModel(car.getModel());
            existingCar.setYear(car.getYear());
            return carrosRepository.save(existingCar);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
    }

    public void deleteCar(Long id) {
        carrosRepository.deleteById(id);
    }
}
