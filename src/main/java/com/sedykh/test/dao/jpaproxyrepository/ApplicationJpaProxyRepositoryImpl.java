package com.sedykh.test.dao.jpaproxyrepository;

import com.sedykh.test.controller.exception.ServiceException;
import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.dao.jparepository.ApplicationJpaRepository;
import com.sedykh.test.mapper.ApplicationMapper;
import com.sedykh.test.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Objects;

import static javax.transaction.Transactional.TxType.MANDATORY;

@Repository
@RequiredArgsConstructor
@Transactional(value = MANDATORY)
public class ApplicationJpaProxyRepositoryImpl implements ApplicationJpaProxyRepository {

    @Autowired
    ApplicationJpaRepository applicationJpaRepository;

    public Application findByContractIdWithLatestCreateTime(long contractId) {
        ApplicationEntity applicationEntity = applicationJpaRepository.findByContractIdWithLatestCreateTime(contractId);
        if (Objects.isNull(applicationEntity)) {
            throw new ServiceException(String.format("Entity with id: %d not found", contractId));
        }
        return ApplicationMapper.toApplication(applicationEntity);
    }
}
