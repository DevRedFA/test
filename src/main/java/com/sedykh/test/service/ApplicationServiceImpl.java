package com.sedykh.test.service;

import com.sedykh.test.dao.jpaproxyrepository.ApplicationJpaProxyRepository;
import com.sedykh.test.model.Application;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(value = Transactional.TxType.MANDATORY)
public class ApplicationServiceImpl implements ApplicationService {

  @Autowired
  private ApplicationJpaProxyRepository jpaProxyRepository;

  public Application findByContractIdWithLatestCreateTime(long contractId) {
    return jpaProxyRepository.findByContractIdWithLatestCreateTime(contractId);
  }
}
