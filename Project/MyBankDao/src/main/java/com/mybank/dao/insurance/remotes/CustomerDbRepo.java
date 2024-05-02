package com.mybank.dao.insurance.remotes;
import com.mybank.dao.insurance.entity.Customer;
import com.mybank.dao.insurance.exceptions.CustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;

@Service
public class CustomerDbRepo implements CustomerRepository,UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    Logger logger= LoggerFactory.getLogger(CustomerDbRepo.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");


    @Override
    public Customer signingUp(Customer customer) {
        customer.setCustomerStatus("open");
        try {
            int count = jdbcTemplate.update("insert into MYBANK_APP_CUSTOMER values(?,?,?,?,?,?,?,?)",new Object[]{
                    customer.getCustomerId(),customer.getCustomerName(),
                    customer.getCustomerAddress(),customer.getCustomerStatus(),customer.getCustomerContact(),
                    customer.getUsername(),customer.getPassword(),customer.getAttempts()
            });
            if (count == 1) {
                return customer;
            } else {
                throw new CustomerException(resourceBundle.getString("customer.fail.signup"));
            }
        } catch (DataAccessException e) {
            throw new CustomerException(resourceBundle.getString("customer.database.error")+ e);
        }
    }

    @Override
    public Customer findByUserName(String username) {
      return findAllUsers().stream().filter(each->each.getUsername().equals(username)).findFirst().orElse(null);

    }

    public List<Customer> findAllUsers(){
        return jdbcTemplate.query("Select * from MYBANK_APP_CUSTOMER",new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public Integer findByCustomerId(String userName) {
        try {
            return jdbcTemplate.queryForObject("SELECT CUSTOMER_ID FROM MYBANK_APP_CUSTOMER WHERE USERNAME = ?", Integer.class, userName);
        } catch (DataAccessException sqlException) {
            logger.error(resourceBundle.getString("customer.id.error") + sqlException.getMessage());
            throw new CustomerException(resourceBundle.getString("customer.id.error")+sqlException.getMessage());
        }
    }


    @Override
    public void updateAttempts(Customer customer) {
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set attempts=? where username=?",
                new Object[]{customer.getAttempts(),customer.getUsername()});
        logger.info(resourceBundle.getString("customer.update"));
    }

    @Override
    public void updateStatus(Customer customer) {
        String status = "InActive";
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set customer_status=? where username=?",
                status, customer.getUsername());
        logger.info(resourceBundle.getString("customer.status"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = findByUserName(username);
        if(customer==null)
            throw new UsernameNotFoundException(username);
        return customer;
    }
}