package com.stech.mcc_credit_disbursement_service.repository;

import com.stech.mcc_credit_disbursement_service.entity.CreditDisbursementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditDisbursementRepository extends JpaRepository<CreditDisbursementEntity,String> {
}
