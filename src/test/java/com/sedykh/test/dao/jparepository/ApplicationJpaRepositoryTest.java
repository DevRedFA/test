package com.sedykh.test.dao.jparepository;

import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.dao.entity.ContractEntity;
import com.sedykh.test.dao.entity.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ApplicationJpaRepositoryTest {

    @Autowired
    private ApplicationJpaRepository jpaRepository;

    private ApplicationEntity applicationEntity;

    private ContractEntity contractEntity;

    private ProductEntity productEntity;

    private final int APPLICATION_ENTITY_ID = 1;

    @Before
    public void init() {
        contractEntity = ContractEntity.builder()
                .id(1L)
                .build();

        productEntity = ProductEntity.builder()
                .id(3L)
                .name("PRODUCT_3")
                .build();

        applicationEntity = ApplicationEntity.builder()
                .contract(contractEntity)
                .id(APPLICATION_ENTITY_ID)
                .product(productEntity)
                .dateTimeCreated(new Timestamp(1244109600000L))
                .build();
    }

    @Test
    public void should_return_valid_entity() {

        //when
        ApplicationEntity result = jpaRepository.findByContractIdWithLatestCreateTime(APPLICATION_ENTITY_ID);

        //then
        assertTrue("Application Entities is not equals", result.equals(applicationEntity));
    }
}
