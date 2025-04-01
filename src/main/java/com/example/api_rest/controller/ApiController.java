package com.example.api_rest.controller;

import com.example.api_rest.model.Api;
import com.example.api_rest.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apis")
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public List<Api> getAllApis() {
        return apiService.getAllApis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Api> getApiById(@PathVariable Long id) {
        Optional<Api> api = apiService.getApiById(id);
        return api.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Api createApi(@RequestBody Api api) {
        return apiService.saveApi(api);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApi(@PathVariable Long id) {
        apiService.deleteApi(id);
        return ResponseEntity.noContent().build();
    }
}
