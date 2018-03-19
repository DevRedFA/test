package com.sedykh.test.dao.jpaproxyrepository;

import com.sedykh.test.model.Application;

public interface ApplicationJpaProxyRepository {

    Application findByContractIdWithLatestCreateTime(long contractId);
}
