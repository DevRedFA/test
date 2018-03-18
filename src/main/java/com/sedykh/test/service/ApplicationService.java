package com.sedykh.test.service;

import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.dao.jpaproxyrepository.ApplicationJpaProxyRepository;
import com.sedykh.test.mapper.ApplicationMapper;
import com.sedykh.test.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(value = Transactional.TxType.MANDATORY)
public class ApplicationService {

    @Autowired
    ApplicationJpaProxyRepository jpaProxyRepository;

    Application findByContractIdWithLatestCreateTime(long contractId) {
        return jpaProxyRepository.findByContractIdWithLatestCreateTime(contractId);
    }
}
