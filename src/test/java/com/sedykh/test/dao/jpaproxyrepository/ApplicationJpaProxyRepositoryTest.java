package com.sedykh.test.dao.jpaproxyrepository;

import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.dao.entity.ContractEntity;
import com.sedykh.test.dao.entity.ProductEntity;
import com.sedykh.test.dao.jparepository.ApplicationJpaRepository;
import com.sedykh.test.model.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {ApplicationJpaProxyRepository.class})
public class ApplicationJpaProxyRepositoryTest {

    @Autowired
    private ApplicationJpaProxyRepository jpaProxyRepository;

    @MockBean
    private ApplicationJpaRepository jpaRepository;

    private Application application;

    private ApplicationEntity applicationEntity;

    private static final int CONTRACT_ENTITY_ID = 1;

    private static final long PRODUCT_ENTITY_ID = 3L;

    private static final long TIME = 1244116800000L;

    @Before
    public void init() {

        ContractEntity contractEntity = ContractEntity.builder()
                .id(CONTRACT_ENTITY_ID)
                .build();

        ProductEntity productEntity = ProductEntity.builder()
                .id(PRODUCT_ENTITY_ID)
                .name("TEST_PRODUCT_3")
                .build();


        applicationEntity = ApplicationEntity.builder()
                .contract(contractEntity)
                .id(PRODUCT_ENTITY_ID)
                .product(productEntity)
                .dateTimeCreated(new Timestamp(TIME))
                .build();

        application = Application.builder()
                .contactId(CONTRACT_ENTITY_ID)
                .id(PRODUCT_ENTITY_ID)
                .productName("TEST_PRODUCT_3")
                .dateTimeCreated(new Timestamp(TIME))
                .build();
    }

    @Test
    public void should_return_valid_entity() {
        //given
        when(jpaRepository.findByContractIdWithLatestCreateTime(CONTRACT_ENTITY_ID)).thenReturn(applicationEntity);

        //when
        Application result = jpaProxyRepository.findByContractIdWithLatestCreateTime(
                CONTRACT_ENTITY_ID);

        //then
        assertTrue("Application Entities is not equals", result.equals(application));
    }
}
