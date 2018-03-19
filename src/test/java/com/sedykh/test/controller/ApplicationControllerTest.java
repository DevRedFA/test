package com.sedykh.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sedykh.test.dto.ApplicationDto;
import com.sedykh.test.service.ApplicationDtoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ApplicationControllerTest {

    @Autowired
    private ApplicationController applicationController;

    @MockBean
    private ApplicationDtoService applicationDtoService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private ApplicationDto applicationDto;

    @Before
    public void init() {
        applicationDto = ApplicationDto.builder()
                .contactId(1)
                .id(3)
                .productName("PRODUCT_3")
                .dateTimeCreated(new Timestamp(1244109600000L))
                .build();
    }

    @Test
    public void should_return_valid_application() throws Exception {

        //given
        int id = 1;
        String expected = objectMapper.writeValueAsString(applicationDto);
        when(applicationDtoService.findByContractIdWithLatestCreateTime(id)).thenReturn(applicationDto);


        //when
        MvcResult mvcResult = mockMvc.perform(get("/contact/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        //then
        assertEquals(content, expected);
        verify(applicationDtoService, times(1)).findByContractIdWithLatestCreateTime(id);
    }


}
