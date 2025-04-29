package com.stech.mcc_credit_disbursement_service.controller;

import com.stech.mcc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.stech.mcc_credit_disbursement_service.service.intefaces.ICreditDisbursementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-disbursements")
@AllArgsConstructor
public class CreditDisbursementRESTController {

    private final ICreditDisbursementService creditDisbursementService;

    @GetMapping
    public List<CreditDisbursementDTO> getAllCreditDisbursements() {
        return this.creditDisbursementService.getAll();
    }

    @PostMapping
    public CreditDisbursementDTO addCreditDisbursement(@RequestBody CreditDisbursementDTO dto) {
        return this.creditDisbursementService.add(dto);
    }
}
