package com.stech.mcc_credit_disbursement_service.utils;

public interface IMapper<T> {

    T getDTO();

    void setData(T t);
}
