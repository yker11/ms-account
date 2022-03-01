package com.proyect.msaccount.service;

import com.proyect.msaccount.model.BankAccount;
import com.proyect.msaccount.repository.IBankAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
public class BankAccountServiceImpl implements IBankAccountService{



    @Autowired
    IBankAccountRepository bankAccountRepository;

    @Override
    public Mono<BankAccount> create(BankAccount bankAccount) {
        return null;
    }

    @Override
    public Flux<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public Mono<BankAccount> findById(String id) {
        return bankAccountRepository.findById(id);
    }

    @Override
    public Mono<BankAccount> update(BankAccount bankAccount) {
        return null;
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return null;
    }

    @Override
    public Mono<Optional<BankAccount>> findBankAccount(String accountNumber) {
        return null;
    }

    @Override
    public Mono<BankAccount> updateBalance(BankAccount bankAccount) {
        return null;
    }

    @Override
    public Mono<BankAccount> depositAccount(BankAccount bankAccount) {
        return null;
    }

    @Override
    public Mono<BankAccount> withdrawalAccount(BankAccount bankAccount) {
        return null;
    }
}
