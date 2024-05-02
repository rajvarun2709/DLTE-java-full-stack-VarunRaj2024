package com.mybank.dao.insurance.remotes;
import com.mybank.dao.insurance.entity.InsuranceAvailable;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceAvailableRepository {
    List<InsuranceAvailable> callAllInsuranceAvailable() throws SQLSyntaxErrorException;
    public Optional<InsuranceAvailable> apiFindById( int insuranceId) throws SQLException;
}
