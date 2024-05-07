package com.mybank.insurance.webservice;

import com.mybank.dao.insurance.entity.Customer;
import com.mybank.dao.insurance.remotes.CustomerDbRepo;
import com.mybank.insurance.webservice.mvc.InsuranceWebController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import javax.servlet.RequestDispatcher;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MvcTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerDbRepo customerRepository;

    @Autowired
    InsuranceWebController controller;

    @Mock
    private MockHttpServletRequest request;



    @Test
    @WithMockUser(username = "testUser")
    public void testCustomerName() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerName("Test Customer");
        when(customerRepository.findByUserName("testUser")).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/ui/name"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Test Customer"));
    }



    @Test
    public void testHandleError() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, 404);
        request.setAttribute(RequestDispatcher.ERROR_MESSAGE, "Not Found");

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8082/error").requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 404)
                .requestAttr(RequestDispatcher.ERROR_MESSAGE, "Not Found"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    @Test
    public void testDash() {
        String result = controller.dash();
        assertEquals("dashboard", result);
    }

    @Test
    public void testLanding() {
        String result = controller.landing();
        assertEquals("index", result);
    }

    @Test
    public void testLoginError() {
        Model model = mock(Model.class);
        String result = controller.loginError(model);
        assertEquals("index", result);
    }



    @Test
    public void testView() {
        String result = controller.view();
        assertEquals("viewInsurance", result);
    }

    @Test
    void testErrorPage() {
        assertEquals("error", controller.errorPage());
    }





}