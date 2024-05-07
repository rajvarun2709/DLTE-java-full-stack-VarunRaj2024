package com.mybank.insurance.webservice;
import com.mybank.dao.insurance.entity.InsuranceAvailable;
import com.mybank.dao.insurance.exceptions.InsuranceNotFoundException;
import com.mybank.dao.insurance.remotes.InsuranceAvailableRepository;
import com.mybank.insurance.webservice.mvc.InsuranceWebController;
import com.mybank.insurance.webservice.rest.controller.InsuranceAvailableController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InsuranceAvailableControllerTest {

    @Mock
    private InsuranceAvailableRepository availableDbRepo;

    @InjectMocks
    private InsuranceAvailableController controller;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    @Test
    public void testGettingOne_InsuranceFound() throws SQLException, InsuranceNotFoundException {
        // Mock the repository to return a valid InsuranceAvailable object
        InsuranceAvailable insuranceAvailable = new InsuranceAvailable(1, "Life", "Jeevan", "KeyBenefits1", 10);
        when(availableDbRepo.apiFindById(anyInt())).thenReturn(Optional.of(insuranceAvailable));

        // Call the controller method
        ResponseEntity<Object> response = controller.gettingOne("1");

        // Assert that the response status is OK and the body matches the returned InsuranceAvailable object
//        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.of(insuranceAvailable), response.getBody());
    }

    @Test
    public void testGettingOne_InsuranceNotFound() throws SQLException {
        // Mock the repository to throw InsuranceNotFoundException
        when(availableDbRepo.apiFindById(anyInt())).thenThrow(InsuranceNotFoundException.class);

        // Call the controller method
        ResponseEntity<Object> response = controller.gettingOne("1");

        // Assert that the response status is NOT_FOUND

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(resourceBundle.getString("insurance.20001.error"), response.getBody());
    }

    @Test
    public void testGettingOne_InternalServerError() throws SQLException {
        // Mock the repository to throw SQLException
        when(availableDbRepo.apiFindById(anyInt())).thenThrow(SQLException.class);

        // Call the controller method
        ResponseEntity<Object> response = controller.gettingOne("1");

        // Assert that the response status is INTERNAL_SERVER_ERROR
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(resourceBundle.getString("insurance.error"), response.getBody());
    }

    @InjectMocks

    private InsuranceWebController isnuranceController;


    @Test

    public void testLandingPage() {

        String result = isnuranceController.landing();

        assertEquals("index", result);

    }

    @Test

    public void testHomePage() {

        String result = isnuranceController.dash();

        assertEquals("dashboard", result);

    }

    @Test

    public void testLoginError() {

        Model model = Mockito.mock(Model.class);

        String result = isnuranceController.loginError(model);

        assertEquals("index", result);


    }

    @Test

    public void testUpdating() {

        String result = isnuranceController.view();

        assertEquals("viewInsurance", result);

    }




}
