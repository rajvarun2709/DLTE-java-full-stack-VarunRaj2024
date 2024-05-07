package com.mybank.insurance.webservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.dao.insurance.entity.Customer;
import com.mybank.dao.insurance.remotes.CustomerRepository;
import com.mybank.insurance.webservice.security.controller.CustomerSignupAPI;
import com.mybank.insurance.webservice.security.loginhandler.CustomerFailureHandler;
import com.mybank.insurance.webservice.security.loginhandler.CustomerSuccessHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class SecurityTests {
    @Mock
    private CustomerRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CustomerSignupAPI controller;
    @InjectMocks
    private CustomerFailureHandler failureHandler;
    @InjectMocks
    private CustomerSuccessHandler successHandler;
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Test
    public void testSave() throws Exception {
        // Mock customer data
        Customer customer = new Customer();
        customer.setUsername("testUser");
        customer.setPassword("testPassword");

        // Mock the repository response
        when(repository.signingUp(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        // Mock the password encoder response
        when(passwordEncoder.encode(ArgumentMatchers.anyString())).thenReturn("encodedPassword");

        // Set up mockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/profile/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testUser"));
    }
    @Test
    public void testSaveProfile() {
        // Mock customer data
        Customer customer = new Customer();
        customer.setUsername("testUser");
        customer.setPassword("testPassword");

        // Mock repository response
        Mockito.when(repository.signingUp(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        // Mock password encoder response
        Mockito.when(passwordEncoder.encode(ArgumentMatchers.anyString())).thenReturn("encodedPassword");

        // Perform save operation
        Customer savedCustomer = controller.save(customer);

        // Verify that repository method is called with the correct argument
        Mockito.verify(repository).signingUp(customer);

        // Verify that password encoder is called with the correct argument
        Mockito.verify(passwordEncoder).encode("testPassword");

        // Verify the returned customer object
        assertEquals(customer.getUsername(), savedCustomer.getUsername());
        assertEquals("encodedPassword", savedCustomer.getPassword()); // Assuming password was encoded correctly
    }


    // Helper method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    void onAuthenticationSuccess_CustomerClosed() throws ServletException, IOException {
        // Mock authentication
        Customer customer = new Customer();
        customer.setCustomerStatus("closed");
        Authentication authentication = new UsernamePasswordAuthenticationToken(customer, null);

        // Mock request and response
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        // Call the method
        successHandler.onAuthenticationSuccess(request, response, authentication);
    }

    @Test
    public void testAuthenticationFailureAttempts() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        AuthenticationException exception = new LockedException("Max Attempts reached account is suspended");

        String username = "testUser";
        request.setParameter("username", username);
        Customer customer=new Customer();
        customer.setUsername(username);
        customer.setCustomerStatus("open"); // Assuming status allows authentication
        customer.setAttempts(2); // Assuming maximum attempts are 3
        when(repository.findByUserName(username)).thenReturn(customer);

        failureHandler.onAuthenticationFailure(request, response, exception);

        assertEquals("/ui/?error=3 Invalid credentials and remaining attempts=1", response.getRedirectedUrl());
    }

    @Test
    public void testAuthenticationFailureSuspend() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        AuthenticationException exception = new LockedException("Max Attempts reached account is suspended");

        String username = "testUser";
        request.setParameter("username", username);
        Customer customer=new Customer();
        customer.setUsername(username);
        customer.setCustomerStatus("open"); // Assuming status allows authentication
        customer.setAttempts(2); // Assuming maximum attempts are 3
        when(repository.findByUserName(username)).thenReturn(customer);

        failureHandler.onAuthenticationFailure(request, response, exception);

        assertEquals("/ui/?error=3 Invalid credentials and remaining attempts=1", response.getRedirectedUrl());
    }
//

}
