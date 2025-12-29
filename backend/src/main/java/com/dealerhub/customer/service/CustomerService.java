package com.dealerhub.customer.service;

import com.dealerhub.customer.dto.CreateCustomerRequest;
import com.dealerhub.customer.dto.CustomerResponse;
import com.dealerhub.customer.entity.CustomerEntity;
import com.dealerhub.customer.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CustomerResponse create(CreateCustomerRequest request) {
        CustomerEntity entity = new CustomerEntity();
        entity.fullName = request.fullName;
        entity.email = request.email;
        entity.phone = request.phone;

        repository.persist(entity);
        return toResponse(entity);
    }

    public List<CustomerResponse> listAll() {
        return repository.listAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    private CustomerResponse toResponse(CustomerEntity entity) {
        CustomerResponse response = new CustomerResponse();
        response.id = entity.id;
        response.fullName = entity.fullName;
        response.email = entity.email;
        response.phone = entity.phone;
        response.createdAt = entity.createdAt;
        return response;
    }
}
