package com.mybank.dao.insurance;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import com.mybank.dao.insurance.entity.Customer;
import com.mybank.dao.insurance.exceptions.CustomerException;
import com.mybank.dao.insurance.remotes.CustomerDbRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class CustomerTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CustomerDbRepo repo;

    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        customers = new ArrayList<>();
        // Add sample customers
        customers.add(new Customer( 3,"John Doe", "Address", "Active", 1234567890L, "johndoe", "password"));
        customers.add(new Customer(2, "Alice Smith", "Another Address", "InActive", 9876543210L, "alicesmith", "password123"));
        customers.add(new Customer( 1,"Bob Johnson", "Yet Another Address", "Active", 5555555555L, "bobjohnson", "securePassword"));
    }

    @Test
    void testSetterMethods() {
        // Create a customer object
        Customer customer = new Customer();

        // Set values using setter methods
        customer.setCustomerId(123);
        customer.setCustomerName("John Doe");
        customer.setCustomerAddress("123 Main St");
        customer.setCustomerStatus("open");
        customer.setCustomerContact(9876543210L);
        customer.setUsername("johndoe");
        customer.setPassword("password");

        // Verify that values are set correctly
        assertEquals(123, customer.getCustomerId());
        assertEquals("John Doe", customer.getCustomerName());
        assertEquals("123 Main St", customer.getCustomerAddress());
        assertEquals("open", customer.getCustomerStatus());
        assertEquals(9876543210L, customer.getCustomerContact());
        assertEquals("johndoe", customer.getUsername());
        assertEquals("password", customer.getPassword());
    }

    @Test
    void testGetterMethods() {
        // Create a customer object
        Customer customer = new Customer();

        // Set values manually
        customer.setCustomerId(123);
        customer.setCustomerName("John Doe");
        customer.setCustomerAddress("123 Main St");
        customer.setCustomerStatus("open");
        customer.setCustomerContact(9876543210L);
        customer.setUsername("johndoe");
        customer.setPassword("password");

        // Verify that getter methods return the correct values
        assertEquals(123, customer.getCustomerId());
        assertEquals("John Doe", customer.getCustomerName());
        assertEquals("123 Main St", customer.getCustomerAddress());
        assertEquals("open", customer.getCustomerStatus());
        assertEquals(9876543210L, customer.getCustomerContact());
        assertEquals("johndoe", customer.getUsername());
        assertEquals("password", customer.getPassword());
    }


    @Test
    void findByUserName_Success() {
        // Mock the jdbcTemplate to return the sample customer list
        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class)))
                .thenReturn(customers);

        // Call the method under test
        Customer foundCustomer = repo.findByUserName("johndoe");

        // Verify the result
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getCustomerName());
    }



    @Test
    void findByUserName_Failure_DataAccessException() {
        // Mock the jdbcTemplate to throw DataAccessException
        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class)))
                .thenThrow(CustomerException.class);

        // Call the method under test and assert that it throws CustomerException
        assertThrows(CustomerException.class, () -> repo.findByUserName("johndoe"));
    }

    @Test
    void testCustomerException() {
        // Arrange
        String errorMessage = "Test error message";

        // Act
        CustomerException exception = new CustomerException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }




    @Test
    void testFindByUserName_Success() {
        Customer customer = new Customer();
        customer.setUsername("john_doe");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(customers);

        Customer result = repo.findByUserName("john_doe");

        assertEquals(customer, result);
    }



    @Test
    void testFindByCustomerId_Success() {
        Integer customerId = 1;
        String username = "john_doe";

        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class), eq(username))).thenReturn(customerId);

        Integer result = repo.findByCustomerId(username);

        assertEquals(customerId, result);
    }





}

