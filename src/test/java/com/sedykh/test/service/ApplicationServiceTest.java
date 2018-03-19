package com.sedykh.test.service;

import com.sedykh.test.dao.jpaproxyrepository.ApplicationJpaProxyRepository;
import com.sedykh.test.model.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Now, this test doesn't check anything, but it is base for future development.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationServiceImpl.class})
public class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @MockBean
    private ApplicationJpaProxyRepository jpaRepository;

    private Application application;

    private static final int CONTRACT_ENTITY_ID = 1;

    private static final long PRODUCT_ENTITY_ID = 3L;

    private static final long TIME = 1244116800000L;

    @Before
    public void init() {

        application = Application.builder()
                .contactId(CONTRACT_ENTITY_ID)
                .id(PRODUCT_ENTITY_ID)
                .productName("TEST_PRODUCT_3")
                .dateTimeCreated(new Timestamp(TIME))
                .build();
    }

    @Test
    public void should_return_valid_object() {
        //given
        when(jpaRepository.findByContractIdWithLatestCreateTime(CONTRACT_ENTITY_ID)).thenReturn(application);

        //when
        Application result = applicationService.findByContractIdWithLatestCreateTime(
                CONTRACT_ENTITY_ID);

        //then
        assertTrue("Application Entities is not equals", result.equals(application));
    }
}
