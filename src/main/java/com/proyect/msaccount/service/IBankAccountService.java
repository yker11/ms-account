package com.proyect.msaccount.service;

import com.proyect.msaccount.model.BankAccount;
import com.proyect.msaccount.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface IBankAccountService {

    public Mono<Customer> getCustomerById(String id);

    public Mono<BankAccount> create(BankAccount bankAccount);

    public Flux<BankAccount> findAll();

    public Mono<BankAccount> findById(String id);

    public Mono<BankAccount> update(BankAccount bankAccount);

    public Mono<Boolean> delete(String id);

    public Mono<Optional<BankAccount>> findBankAccount(String accountNumber);

    public Mono<BankAccount> updateBalance(BankAccount bankAccount);

    public Mono<BankAccount> depositAccount(BankAccount bankAccount);

    public Mono<BankAccount> withdrawalAccount(BankAccount bankAccount);

    public Flux<Customer> getCustomer(String id);
}
