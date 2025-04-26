package com.stech.mcc_customer_service.utils;

public interface IMapper<T> {

    T getDTO();

    void setData(T t);
}
