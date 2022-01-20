package com.example.simulation.repositories;

import com.example.simulation.entities.Receipt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Integer> {
    List<Receipt> findAll();
    @Query("from Receipt r where r.merchant_id=:merchant_Id")
    Receipt findByMerchantId(@Param("merchant_Id") int merchantId);
}
