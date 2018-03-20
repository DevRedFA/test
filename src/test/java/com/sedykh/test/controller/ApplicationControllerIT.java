package com.sedykh.test.controller;

import com.sedykh.test.dto.ApplicationDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ApplicationControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private ApplicationDto expectedApplicationDto;

    private static final int CONTRACT_ENTITY_ID = 1;

    private static final long PRODUCT_ENTITY_ID = 3L;

    private static final long TIME = 1244116800000L;

    @Before
    public void init() {
        expectedApplicationDto = ApplicationDto.builder()
                .contactId(CONTRACT_ENTITY_ID)
                .id(PRODUCT_ENTITY_ID)
                .productName("TEST_PRODUCT_3")
                .dateTimeCreated(new Timestamp(TIME))
                .build();
    }

    @Test
    public void should_return_valid_application() {

        //when
        ResponseEntity<ApplicationDto> responseEntity =
                restTemplate.getForEntity("/contact/" + CONTRACT_ENTITY_ID, ApplicationDto.class);
        ApplicationDto content = responseEntity.getBody();

        //then
        assertTrue("Application Entities is not equals", content.equals(expectedApplicationDto));
    }
}
