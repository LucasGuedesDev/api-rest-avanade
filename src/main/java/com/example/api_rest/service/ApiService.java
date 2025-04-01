package com.example.api_rest.service;

import com.example.api_rest.model.Api;
import com.example.api_rest.repository.ApiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    private final ApiRepository apiRepository;

    public ApiService(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public List<Api> getAllApis() {
        return apiRepository.findAll();
    }

    public Optional<Api> getApiById(Long id) {
        return apiRepository.findById(id);
    }

    public Api saveApi(Api api) {
        return apiRepository.save(api);
    }

    public void deleteApi(Long id) {
        apiRepository.deleteById(id);
    }
}
