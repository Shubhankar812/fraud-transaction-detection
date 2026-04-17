package com.fraudDetection.Transaction.Repository;

import com.fraudDetection.Transaction.Entity.TransactionDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDB,Long> {
}
