package com.mybank.dao.insurance.remotes;

import com.mybank.dao.insurance.entity.InsuranceAvailable;
import org.springframework.stereotype.Repository;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Repository
public interface InsuranceAvailableRepository {
    List<InsuranceAvailable> callAllInsuranceAvailable() throws SQLSyntaxErrorException;
}
