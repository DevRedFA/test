package com.sedykh.test.controller;

import java.sql.Timestamp;
import com.sedykh.test.model.ApplicationDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

  @GetMapping("/contact/{contactId}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationDto getLastApplication(@PathVariable("contactId") Long contactId) {
    return ApplicationDto.builder()
                         .contactId(1L)
                         .dateTimeCreated(new Timestamp(System.currentTimeMillis()))
                         .id(2L)
                         .productName("productName")
                         .build();
  }

}
