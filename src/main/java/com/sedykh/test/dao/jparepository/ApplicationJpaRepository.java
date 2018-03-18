package com.sedykh.test.dao.jparepository;

import com.sedykh.test.dao.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationJpaRepository extends JpaRepository<ApplicationEntity, Long> {

    @Query(value = "SELECT * FROM applications " +
            "LEFT JOIN products ON products.id = applications.product_id " +
            "WHERE applications.contract_id = ? ORDER BY applications.DATE_TIME_CREATED DESC," +
            " applications.id DESC LIMIT 1", nativeQuery = true)
    ApplicationEntity findByContractIdWithLatestCreateTime(long contractId);
}
