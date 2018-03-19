package com.sedykh.test.service;

import com.sedykh.test.dto.ApplicationDto;

public interface ApplicationDtoService {

  ApplicationDto findByContractIdWithLatestCreateTime(long contractId);
}
