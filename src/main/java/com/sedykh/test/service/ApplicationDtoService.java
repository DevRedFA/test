package com.sedykh.test.service;

import com.sedykh.test.model.ApplicationDto;

public interface ApplicationDtoService {

  ApplicationDto findByContractIdWithLatestCreateTime(long contractId);
}
