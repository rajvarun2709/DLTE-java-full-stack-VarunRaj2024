package com.example.task3.services;
import com.example.task3.model.AccountHolder;
import com.example.task3.remote.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public AccountHolder callSave(AccountHolder accountHolder){
        return accountRepository.save(accountHolder);
    }
    public List<AccountHolder> callFindAll(){
        return (List<AccountHolder>) accountRepository.findAll();
    }
}
