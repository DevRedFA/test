package com.sedykh.test.service;

import com.sedykh.test.dao.jpaproxyrepository.ApplicationJpaProxyRepository;
import com.sedykh.test.model.Application;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Service
@RequiredArgsConstructor
@Transactional(value = REQUIRED)
public class ApplicationServiceImpl implements ApplicationService {

  @Autowired
  private ApplicationJpaProxyRepository jpaProxyRepository;

  public Application findByContractIdWithLatestCreateTime(long contractId) {
    return jpaProxyRepository.findByContractIdWithLatestCreateTime(contractId);
  }
}
