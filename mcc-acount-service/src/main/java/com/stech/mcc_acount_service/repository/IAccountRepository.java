package com.stech.mcc_acount_service.repository;

import com.stech.mcc_acount_service.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<AccountEntity,String> {

    Optional<AccountEntity> findByAccountNumberAndCustomerCu(String AccountNumer ,String username);

}
