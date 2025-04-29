package com.stech.mcc_credit_disbursement_service.service.impl;

import com.stech.mcc_credit_disbursement_service.client.IAccountRESTClient;
import com.stech.mcc_credit_disbursement_service.dto.AccountDTO;
import com.stech.mcc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.stech.mcc_credit_disbursement_service.dto.DepositDTO;
import com.stech.mcc_credit_disbursement_service.entity.CreditDisbursementEntity;
import com.stech.mcc_credit_disbursement_service.repository.ICreditDisbursementRepository;
import com.stech.mcc_credit_disbursement_service.service.intefaces.ICreditDisbursementService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class CreditDisbursementServiceImpl implements ICreditDisbursementService {

    private  final ICreditDisbursementRepository creditDisbursementRepository;
    private final IAccountRESTClient accountRESTClient;

    @Override
    public List<CreditDisbursementDTO> getAll() {
        return this.creditDisbursementRepository.findAll().stream().map(CreditDisbursementEntity::getDTO).toList();
    }

    @Override
    public CreditDisbursementDTO add(CreditDisbursementDTO creditDisbursementDTO) {
        log.info("Add credit disbursement, {}",creditDisbursementDTO);
        ResponseEntity<AccountDTO> responseEntityDepositInAccount = this.accountRESTClient.depositInAccount(
                DepositDTO.builder()
                        .accountNumber(creditDisbursementDTO.getAccountNumber())
                        .amount(creditDisbursementDTO.getAmount())
                        .customerCu(creditDisbursementDTO.getCustomerCu())
                        .build()
        );
        if(responseEntityDepositInAccount.getStatusCode().is2xxSuccessful()){
            log.info("Deposit in Account successful");
            CreditDisbursementEntity creditDisbursementEntity = new CreditDisbursementEntity();
            creditDisbursementEntity.setData(creditDisbursementDTO);
            return this.creditDisbursementRepository.save(creditDisbursementEntity).getDTO();
        }
        return CreditDisbursementDTO.builder().build();
    }

    @Override
    public CreditDisbursementDTO update(CreditDisbursementDTO creditDisbursementDTO) {
        return null;
    }

    @Override
    public CreditDisbursementDTO delete(CreditDisbursementDTO creditDisbursementDTO) {
        return null;
    }

    @Override
    public CreditDisbursementDTO getById(String id) {
        return null;
    }
}
