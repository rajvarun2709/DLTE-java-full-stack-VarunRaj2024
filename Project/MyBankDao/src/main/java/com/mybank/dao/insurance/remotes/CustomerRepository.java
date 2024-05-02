package com.mybank.dao.insurance.remotes;

import com.mybank.dao.insurance.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  {
    Customer signingUp(Customer customer);
    Customer findByUserName(String username);
    Integer findByCustomerId(String customerName);
    void updateAttempts(Customer customer);
    void updateStatus(Customer customer);

}
