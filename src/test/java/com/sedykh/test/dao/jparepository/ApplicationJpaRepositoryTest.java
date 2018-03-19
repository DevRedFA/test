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

  public static final long PRODUCT_ENTITY_ID = 3L;

  @Autowired
  private ApplicationJpaRepository jpaRepository;

  private ApplicationEntity applicationEntity;

  private ContractEntity contractEntity;

  private ProductEntity productEntity;

  private static final int CONTRACT_ENTITY_ID = 1;

  @Before
  public void init() {
    contractEntity = ContractEntity.builder()
                                   .id(CONTRACT_ENTITY_ID)
                                   .build();

    productEntity = ProductEntity.builder()
                                 .id(PRODUCT_ENTITY_ID)
                                 .name("TEST_PRODUCT_3")
                                 .build();

    applicationEntity = ApplicationEntity.builder()
                                         .contract(contractEntity)
                                         .id(PRODUCT_ENTITY_ID)
                                         .product(productEntity)
                                         .dateTimeCreated(new Timestamp(1244116800000L))
                                         .build();
  }

  @Test
  public void should_return_valid_entity() {
    //when
    ApplicationEntity result = jpaRepository.findByContractIdWithLatestCreateTime(
        CONTRACT_ENTITY_ID);

    //then
    assertTrue("Application Entities is not equals", result.equals(applicationEntity));
  }
}
