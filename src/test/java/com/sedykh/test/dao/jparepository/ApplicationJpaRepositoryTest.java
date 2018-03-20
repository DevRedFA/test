package com.sedykh.test.dao.jparepository;

import static org.junit.Assert.assertTrue;

import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.dao.entity.ContractEntity;
import com.sedykh.test.dao.entity.ProductEntity;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class ApplicationJpaRepositoryTest {

    @Autowired
    private ApplicationJpaRepository jpaRepository;

    private ApplicationEntity expectedApplicationEntity;

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

        expectedApplicationEntity = ApplicationEntity.builder()
                .contract(contractEntity)
                .id(PRODUCT_ENTITY_ID)
                .product(productEntity)
                .dateTimeCreated(new Timestamp(TIME))
                .build();
    }

    @Test
    public void should_return_valid_entity() {
        //when
        ApplicationEntity result = jpaRepository.findByContractIdWithLatestCreateTime(
                CONTRACT_ENTITY_ID);

        //then
        assertTrue("Application Entities is not equals", result.equals(expectedApplicationEntity));
    }
}
