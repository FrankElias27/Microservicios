package com.stech.mcc_customer_service.services.impl;

import com.stech.mcc_customer_service.dto.CustomerDTO;
import com.stech.mcc_customer_service.entity.CustomerEntity;
import com.stech.mcc_customer_service.repository.ICustomerRepository;
import com.stech.mcc_customer_service.services.interfaces.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository customerRepository;

    @Override
    public CustomerDTO getByCu(String cu) {
        log.info("Get Customer by cu: {}" , cu);
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByCu(cu);
        if(optionalCustomerEntity.isEmpty()) {
            return CustomerDTO.builder().build();
        }
        return optionalCustomerEntity.get().getDTO();
    }

    @Override
    public List<CustomerDTO> getAll() {
        return this.customerRepository.findAll().stream().map(CustomerEntity::getDTO).toList();
    }

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        log.info("Add customer {}" , customerDTO);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setData(customerDTO);
        return this.customerRepository.save(customerEntity).getDTO();
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO delete(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO getById(String id) {
        log.info("Get customer by id {}" , id);
        Optional<CustomerEntity> optionalCustomerEntity = this.customerRepository.findById(id);
        if(optionalCustomerEntity.isEmpty()) {
            return CustomerDTO.builder().build();
        }
        return optionalCustomerEntity.get().getDTO();
    }
}

