package com.example.simulation.repositories;

import com.example.simulation.entities.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Integer> {
    List<Transactions> findAll();
}
