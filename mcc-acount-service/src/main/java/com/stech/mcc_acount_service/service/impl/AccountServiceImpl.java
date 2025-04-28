package com.stech.mcc_acount_service.service.impl;

import com.stech.mcc_acount_service.client.ICustomerRESTClient;
import com.stech.mcc_acount_service.dto.AccountDTO;
import com.stech.mcc_acount_service.dto.CustomerDTO;
import com.stech.mcc_acount_service.dto.DepositDTO;
import com.stech.mcc_acount_service.entity.AccountEntity;
import com.stech.mcc_acount_service.repository.IAccountRepository;
import com.stech.mcc_acount_service.service.interfaces.IAcoountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAcoountService {

    private IAccountRepository accountRepository;
    private ICustomerRESTClient customerRESTClient;

    @Override
    public List<AccountDTO> getAll() {
        return this.accountRepository.findAll().stream().map(AccountEntity::getDTO).toList();
    }

    @Override
    public AccountDTO add(AccountDTO accountDTO) {

        ResponseEntity<CustomerDTO> responseEntityNewCustomerDTO = this.customerRESTClient.add(accountDTO.getCustomer());
        if(responseEntityNewCustomerDTO.getStatusCode().is2xxSuccessful()) {
        log.info("Customer added succsessfully");
        accountDTO.setCustomer(responseEntityNewCustomerDTO.getBody());

            log.info("Add account to account repository {}" , accountDTO);
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setData(accountDTO);
            return this.accountRepository.save(accountEntity).getDTO();
        }else {
            log.error("Customer add failed");
            return AccountDTO.builder().build();
        }

    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO delete(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO getById(String id) {
        return null;
    }

    @Override
    public AccountDTO depositInAccount(DepositDTO depositDTO) {
        log.info("Deposit into account repository, {}", depositDTO);
        Optional<AccountEntity> optionalAccountEntity = this.accountRepository.findByAccountNumberAndCustomerCu(depositDTO.getAccountNumber(), depositDTO.getCustomerCu());
        if(optionalAccountEntity.isPresent()) {
            // deposit in account
            AccountEntity accountEntity = optionalAccountEntity.get();
            accountEntity.setAccountBalance(accountEntity.getAccountBalance().add(depositDTO.getAmount()));
            return this.accountRepository.save(accountEntity).getDTO();
        }
        return AccountDTO.builder().build();
    }

}
