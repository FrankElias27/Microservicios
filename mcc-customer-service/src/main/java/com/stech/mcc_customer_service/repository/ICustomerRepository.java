package com.stech.mcc_customer_service.repository;

import com.stech.mcc_customer_service.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity,String> {

    //definir otros methods
    Optional<CustomerEntity> findByCu(String cu);

}
