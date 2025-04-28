package com.stech.mcc_acount_service.client;

import com.stech.mcc_acount_service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="${feign.clients.customer.name}",url = "${feign.clients.customer.url}")
public interface ICustomerRESTClient {

    @PostMapping
    ResponseEntity<CustomerDTO> add(@RequestBody CustomerDTO customerDTO);

    @GetMapping("/cu/{cu}")
    ResponseEntity<CustomerDTO> getByCu(@PathVariable String cu);
}
