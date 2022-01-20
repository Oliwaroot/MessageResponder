package com.example.simulation.repositories;

import com.example.simulation.entities.Sales;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Integer> {
    List<Sales> findAll();
    @Query("from Sales s where s.merchant_id=:merchant_Id")
    Sales findByMerchantId(@Param("merchant_Id") int merchantId);
}
