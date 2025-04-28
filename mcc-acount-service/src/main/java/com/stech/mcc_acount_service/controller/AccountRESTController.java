package com.stech.mcc_acount_service.controller;

import com.stech.mcc_acount_service.dto.AccountDTO;
import com.stech.mcc_acount_service.service.interfaces.IAcoountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class AccountRESTController {

    private IAcoountService accountService;

    @GetMapping
    public List<AccountDTO> getAllAccount(){
    return this.accountService.getAll();
    }

    @PostMapping
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO){
        return this.accountService.add(accountDTO);
    }
}
