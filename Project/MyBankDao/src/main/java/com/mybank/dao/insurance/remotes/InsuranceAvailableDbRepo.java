package com.mybank.dao.insurance.remotes;

        import com.mybank.dao.insurance.entity.InsuranceAvailable;
        import com.mybank.dao.insurance.exceptions.CustomerException;
        import com.mybank.dao.insurance.exceptions.InsuranceAvailableException;
        import com.mybank.dao.insurance.exceptions.InsuranceNotFoundException;
        import oracle.jdbc.OracleTypes;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.dao.*;
        import org.springframework.jdbc.UncategorizedSQLException;
        import org.springframework.jdbc.core.*;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.stereotype.Service;
        import java.sql.*;
        import java.util.*;

/* This service retrieves all the record from the oracle db and returns the list of the records.
 This service also throws the required exception if encountered.*/

@Service
public class InsuranceAvailableDbRepo implements InsuranceAvailableRepository {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    Logger logger = LoggerFactory.getLogger(InsuranceAvailableDbRepo.class);

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<InsuranceAvailable> callAllInsuranceAvailable() throws SQLSyntaxErrorException, InsuranceAvailableException {
        List<InsuranceAvailable> insuranceList = null;
        try {
            insuranceList = jdbcTemplate.query("select * from MYBANK_APP_INSURANCEAVAILABLE", new CardMapper());
            logger.debug(resourceBundle.getString("insurance.list.size"), insuranceList.size());

        } catch (DataAccessException sqlException) {
            logger.error(resourceBundle.getString("insurance.sql.error"), sqlException);
            throw new SQLSyntaxErrorException(sqlException);
        }
        if (insuranceList.size() == 0) {
            logger.warn(resourceBundle.getString("insurance.data.null"));
            throw new InsuranceAvailableException(resourceBundle.getString("insurance.data.null"));
        }
        return insuranceList;
    }



    public Optional<InsuranceAvailable> apiFindById(int insuranceId) throws SQLException {
        CallableStatementCreator creator = con -> {
            CallableStatement statement = con.prepareCall("{call get_insurance_data(?, ?)}");
            statement.setLong(1, insuranceId);
            statement.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            return statement;
        };

        try {
            Map<String, Object> returnedExecution = jdbcTemplate.call(creator, Arrays.asList(
                    new SqlParameter[]{
                            new SqlParameter(Types.NUMERIC),
                            new SqlOutParameter("insuranceData", OracleTypes.CURSOR)
                    }
            ));

            // Retrieving the cursor result
            ArrayList<InsuranceAvailable> availables = (ArrayList<InsuranceAvailable>) returnedExecution.get("insuranceData");

            // Processing the result set, assuming InsuranceAvailable has corresponding constructor and setter methods

//            return Optional.ofNullable(availables.get(0));
            if (availables != null && !availables.isEmpty()) {
                // Processing the result set, assuming InsuranceAvailable has corresponding constructor and setter methods
                return Optional.ofNullable(availables.get(0));
            } else {
                // If availables is null or empty, return Optional.empty()
                return Optional.empty();
            }

        } catch (UncategorizedSQLException e) {
            if (e.getSQLException().getErrorCode()==20001) {
                logger.error(resourceBundle.getString("insurance.20001.error") + e.getSQLException().getMessage());
                throw new InsuranceNotFoundException(resourceBundle.getString("insurance.20001.error") );
            }
            else {
                logger.warn(resourceBundle.getString("insurance.error") + e.toString());
                throw new SQLException(resourceBundle.getString("insurance.error") );
            }
        }
    }

    public class CardMapper implements RowMapper<InsuranceAvailable> {
        @Override
        public InsuranceAvailable mapRow(ResultSet rs, int rowNum) throws SQLException {
            InsuranceAvailable available = new InsuranceAvailable();
            available.setInsuranceId(rs.getInt(1));
            available.setInsuranceType(rs.getString(2));
            available.setInsuranceName(rs.getString(3));
            available.setInsuranceKeyBenefits(rs.getString(4));
            available.setInsuranceLifetime(rs.getInt(5));
            return available;
        }
    }


}
