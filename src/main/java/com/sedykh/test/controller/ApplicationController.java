package com.sedykh.test.controller;

import com.sedykh.test.dto.ApplicationDto;
import com.sedykh.test.service.ApplicationDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationDtoService applicationDtoService;

    @GetMapping("/contact/{contactId}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationDto getLastApplication(@PathVariable("contactId") Long contactId) {
        return applicationDtoService.findByContractIdWithLatestCreateTime(contactId);
    }
}
