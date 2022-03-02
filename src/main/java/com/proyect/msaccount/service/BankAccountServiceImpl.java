package com.proyect.msaccount.service;

import com.proyect.msaccount.model.BankAccount;
import com.proyect.msaccount.model.Customer;
import com.proyect.msaccount.repository.IBankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class BankAccountServiceImpl implements IBankAccountService{

    public static final String HASH_KEY = "BankAccount";
    WebClient webClientCustomer;

    @Autowired
    IBankAccountRepository bankAccountRepository;

    @Autowired
    private RedisTemplate<String, BankAccount> redisTemplate;
    private HashOperations hashOperations;

    public BankAccountServiceImpl(RedisTemplate<String, BankAccount> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    String uri = "http://localhost:8090/api";

    public BankAccountServiceImpl() {
        this.webClientCustomer = WebClient.builder().baseUrl(this.uri).build();
    }

    @Override
    public Mono<Customer> getCustomerById(String id){
        return webClientCustomer.get().uri(this.uri + "/ms-customer/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @Override
    public Mono<BankAccount> create(BankAccount bankAccount) {
        return webClientCustomer.get().uri(this.uri + "/ms-customer/{id}", bankAccount.getIdClient())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class)
                .flatMap(cust -> {
                    BankAccount ba = new BankAccount();
                    ba.setCustomer(bankAccount.getCustomer());
                    ba.setAccountNumber(bankAccount.getAccountNumber());
                    ba.setBalance(bankAccount.getBalance());
                    ba.setAmount(bankAccount.getAmount());
                    ba.setCreateDate(new Date());
                    ba.setMovements(bankAccount.getMovements());
                    ba.setIdClient(cust.getId());
                    return bankAccountRepository.save(ba);
                });
    }

    @Override
    public Flux<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public Mono<BankAccount> findById(String id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount findBankAccountById(int id) {
        return (BankAccount) hashOperations.get(HASH_KEY, id);
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

    @Override
    public Flux<Customer> getCustomer(String id) {
        Flux<Customer> customerFlux = webClientCustomer
                .get()
                .uri("http://localhost:8090/api/ms-customer/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Customer.class);
        return customerFlux;
    }
}
