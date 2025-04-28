package com.stech.mcc_acount_service.service.impl;

import com.stech.mcc_acount_service.dto.AccountDTO;
import com.stech.mcc_acount_service.entity.AccountEntity;
import com.stech.mcc_acount_service.repository.IAccountRepository;
import com.stech.mcc_acount_service.service.interfaces.IAcoountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAcoountService {

    private IAccountRepository accountRepository;

    @Override
    public List<AccountDTO> getAll() {
        return this.accountRepository.findAll().stream().map(AccountEntity::getDTO).toList();
    }

    @Override
    public AccountDTO add(AccountDTO accountDTO) {
        log.info("Add account to account repository {}" , accountDTO);
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setData(accountDTO);
        return this.accountRepository.save(accountEntity).getDTO();
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
}
