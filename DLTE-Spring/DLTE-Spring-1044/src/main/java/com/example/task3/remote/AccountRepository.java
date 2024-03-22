package com.example.task3.remote;


import com.example.task3.model.AccountHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountHolder,Long> {

}
