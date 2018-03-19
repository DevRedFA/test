package com.sedykh.test.dao.jpaproxyrepository;

import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.dao.jparepository.ApplicationJpaRepository;
import com.sedykh.test.mapper.ApplicationMapper;
import com.sedykh.test.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.MANDATORY;

@Repository
@RequiredArgsConstructor
@Transactional(value = MANDATORY)
public class ApplicationJpaProxyRepository {

    @Autowired
    ApplicationJpaRepository applicationJpaRepository;

    public Application findByContractIdWithLatestCreateTime(long contractId) {
        ApplicationEntity applicationEntity = applicationJpaRepository.findByContractIdWithLatestCreateTime(contractId);
        return ApplicationMapper.toApplication(applicationEntity);
    }
}
