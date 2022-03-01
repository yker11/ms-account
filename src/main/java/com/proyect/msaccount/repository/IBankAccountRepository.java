package com.proyect.msaccount.repository;

import com.proyect.msaccount.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
}
