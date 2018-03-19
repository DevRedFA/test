package com.sedykh.test.service;

import com.sedykh.test.model.Application;

public interface ApplicationService {

  Application findByContractIdWithLatestCreateTime(long contractId);
}
