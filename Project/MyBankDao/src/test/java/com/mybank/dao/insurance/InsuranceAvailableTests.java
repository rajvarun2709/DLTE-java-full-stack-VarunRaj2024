package com.mybank.dao.insurance;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.mybank.dao.insurance.entity.InsuranceAvailable;
import com.mybank.dao.insurance.exceptions.InsuranceNotFoundException;
import com.mybank.dao.insurance.remotes.CustomerRepository;
import com.mybank.dao.insurance.remotes.InsuranceAvailableDbRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class InsuranceAvailableTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    // Mock repository

    @InjectMocks
    private InsuranceAvailableDbRepo services;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    void testApiFindById_Success() throws SQLException {
        // Mock the behavior of jdbcTemplate.call to return a result similar to the example
        Map<String, Object> mockResult = new HashMap<>();
        ArrayList<Object> test = new ArrayList<>();
        test.add(1L);
        test.add("jeevan");
        test.add("KeyBenifits");
        test.add(10);
        mockResult.put("insuranceData",test);
        when(jdbcTemplate.call(any(CallableStatementCreator.class), any(List.class))).thenReturn(mockResult);

        Optional<InsuranceAvailable> result = services.apiFindById(1);
        assertTrue(result.isPresent());

    }

    @Test
    void testApiFindById_Failure() throws SQLException {
        // Mock the behavior of jdbcTemplate.call to return a result similar to the example
        Map<String, Object> mockResult = new HashMap<>();
        ArrayList<Object> test = new ArrayList<>();
        test.add(1L);
        test.add("jeevan");
        test.add("KeyBenifits");
        test.add(10);
        mockResult.put("insuranceData",test);
        when(jdbcTemplate.call(any(CallableStatementCreator.class), any(List.class))).thenReturn(mockResult);

        Optional<InsuranceAvailable> result = services.apiFindById(1);
        assertNotEquals(result.get(),test.get(1));

    }



    @Test
    void testConstructorAndGetMessage() {
        String errorMessage = "Insurance not found!";
        InsuranceNotFoundException exception = new InsuranceNotFoundException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testCardMapper() throws SQLException {
        InsuranceAvailableDbRepo.CardMapper cardMapper = new InsuranceAvailableDbRepo().new CardMapper();
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        when(mockResultSet.getInt(1)).thenReturn(1);
        when(mockResultSet.getString(2)).thenReturn("Type1");
        when(mockResultSet.getString(3)).thenReturn("Name1");
        when(mockResultSet.getString(4)).thenReturn("Benefits1");
        when(mockResultSet.getInt(5)).thenReturn(10);

        InsuranceAvailable insuranceAvailable = cardMapper.mapRow(mockResultSet, 1);

        assertNotNull(insuranceAvailable);
        assertEquals(1, insuranceAvailable.getInsuranceId());
        assertEquals("Type1", insuranceAvailable.getInsuranceType());
        assertEquals("Name1", insuranceAvailable.getInsuranceName());
        assertEquals("Benefits1", insuranceAvailable.getInsuranceKeyBenefits());
        assertEquals(10, insuranceAvailable.getInsuranceLifetime());
    }


}




