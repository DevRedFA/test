package com.sedykh.test.service;

import com.sedykh.test.mapper.ApplicationMapper;
import com.sedykh.test.model.Application;
import com.sedykh.test.dto.ApplicationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationDtoServiceImpl implements ApplicationDtoService {

  @Autowired
  private ApplicationService applicationService;

  public ApplicationDto findByContractIdWithLatestCreateTime(long contractId) {
    Application application = applicationService.findByContractIdWithLatestCreateTime(contractId);
    return ApplicationMapper.toApplicationDto(application);
  }
}
