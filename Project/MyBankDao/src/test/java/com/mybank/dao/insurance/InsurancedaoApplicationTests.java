//package com.mybank.dao.insurance;
//import com.mybank.dao.insurance.entity.InsuranceAvailable;
//import com.mybank.dao.insurance.exceptions.InsuranceAvailableException;
//import com.mybank.dao.insurance.remotes.InsuranceAvailableDbRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import java.sql.SQLSyntaxErrorException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class InsurancedaoApplicationTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private InsuranceAvailableDbRepo insuranceAvailableDbRepo;
//
//    @Test
//    void callAllInsuranceAvailable_Success() throws SQLSyntaxErrorException {
//        // Mocking the response from the database
//        List<InsuranceAvailable> mockInsuranceList = new ArrayList<>();
//        mockInsuranceList.add(new InsuranceAvailable(1, "health", "varun", "health wins", 10));
//        mockInsuranceList.add(new InsuranceAvailable(2, "home", "vijay", "home free", 20));
//        when(jdbcTemplate.query(anyString(), any(InsuranceAvailableDbRepo.CardMapper.class))).thenReturn(mockInsuranceList);
//
//        // Calling the method under test
//        List<InsuranceAvailable> result = insuranceAvailableDbRepo.callAllInsuranceAvailable();
//        // Verifying the result
////        assertNotEquals("Name1", result.get(1).getInsuranceName());
//        assertEquals(2, result.size());
//        assertEquals("health", result.get(0).getInsuranceType());
//    }
//
////    @Test
//    void callAllInsuranceAvailable_failure() throws SQLSyntaxErrorException{
//        List<InsuranceAvailable> mockInsuranceList = new ArrayList<>();
//        mockInsuranceList.add(new InsuranceAvailable(1, "health", "varun", "health wins", 10));
//        mockInsuranceList.add(new InsuranceAvailable(2, "home", "vijay", "home free", 20));
//        when(jdbcTemplate.query(anyString(), any(InsuranceAvailableDbRepo.CardMapper.class))).thenReturn(mockInsuranceList);
//
//        List<InsuranceAvailable> result = insuranceAvailableDbRepo.callAllInsuranceAvailable();
//        assertEquals("sujay", result.get(1).getInsuranceName());
//        assertEquals(3, result.size());
//        assertNotEquals("health", result.get(0).getInsuranceType());
//
//    }
//
//
//    @Test
////    no data is found after executing the database query.
//    void callAllInsuranceAvailable_NoDataFound() {
//        // Mock
//        when(jdbcTemplate.query(anyString(), any(InsuranceAvailableDbRepo.CardMapper.class))).thenReturn(new ArrayList<>());
//
//        // Calling the method under test and expecting an exception
//        assertThrows(InsuranceAvailableException.class, () -> insuranceAvailableDbRepo.callAllInsuranceAvailable());
//    }
//
//
//
//
//}
//
