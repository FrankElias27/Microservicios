package com.stech.mcc_acount_service.client;

import com.stech.mcc_acount_service.dto.CustomerDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="${feign.clients.customer.name}",url = "${feign.clients.customer.url}")
public interface ICustomerRESTClient {

    Logger logger = LoggerFactory.getLogger(ICustomerRESTClient.class);

    @PostMapping
    @CircuitBreaker(name="${feign.clients.customer.name}",fallbackMethod = "fallbackAdd")
    ResponseEntity<CustomerDTO> add(@RequestBody CustomerDTO customerDTO);

    @GetMapping("/cu/{cu}")
    @CircuitBreaker(name="${feign.clients.customer.name}",fallbackMethod = "fallbackGetByCu")
    ResponseEntity<CustomerDTO> getByCu(@PathVariable String cu);

    default ResponseEntity<CustomerDTO>fallbackAdd(@RequestBody CustomerDTO customerDTO,Throwable throwable) {
        logger.warn("fallbackAdd");
        return new ResponseEntity<>(customerDTO, HttpStatus.SERVICE_UNAVAILABLE);
    }

    default ResponseEntity<CustomerDTO>fallbackGetByCu(String cu , Throwable throwable) {
        logger.warn("fallbackGetByCu");
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
