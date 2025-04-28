package com.stech.mcc_acount_service.util;

public interface IMapper<T> {

    T getDTO();

    void setData(T t);
}
