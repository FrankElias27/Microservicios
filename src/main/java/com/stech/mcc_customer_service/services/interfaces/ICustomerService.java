package com.stech.mcc_customer_service.services.interfaces;

import com.stech.mcc_customer_service.dto.CustomerDTO;
import com.stech.mcc_customer_service.utils.ICrud;

public interface ICustomerService extends ICrud<CustomerDTO> {

    CustomerDTO getByCu(String cu);
}
