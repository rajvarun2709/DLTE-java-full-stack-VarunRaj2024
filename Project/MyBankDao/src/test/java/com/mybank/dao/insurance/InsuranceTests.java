package com.mybank.dao.insurance;
import static org.junit.jupiter.api.Assertions.*;
import com.mybank.dao.insurance.entity.InsuranceAvailable;
import org.junit.jupiter.api.Test;

class InsuranceTests {

    @Test
    void testConstructorAndGetters() {
        Integer insuranceId = 1;
        String insuranceType = "Type";
        String insuranceName = "Name";
        String insuranceKeyBenefits = "Benefits";
        Integer insuranceLifetime = 10;

        InsuranceAvailable insuranceAvailable = new InsuranceAvailable(insuranceId, insuranceType, insuranceName, insuranceKeyBenefits, insuranceLifetime);

        assertEquals(insuranceId, insuranceAvailable.getInsuranceId());
        assertEquals(insuranceType, insuranceAvailable.getInsuranceType());
        assertEquals(insuranceName, insuranceAvailable.getInsuranceName());
        assertEquals(insuranceKeyBenefits, insuranceAvailable.getInsuranceKeyBenefits());
        assertEquals(insuranceLifetime, insuranceAvailable.getInsuranceLifetime());
    }

    @Test
    void testToString() {
        Integer insuranceId = 1;
        String insuranceType = "Type";
        String insuranceName = "Name";
        String insuranceKeyBenefits = "Benefits";
        Integer insuranceLifetime = 10;

        InsuranceAvailable insuranceAvailable = new InsuranceAvailable(insuranceId, insuranceType, insuranceName, insuranceKeyBenefits, insuranceLifetime);

        String expectedToString = "InsuranceAvailable{" +
                "insuranceId=" + insuranceId +
                ", insuranceType='" + insuranceType + '\'' +
                ", insuranceName='" + insuranceName + '\'' +
                ", insuranceKeyBenefits='" + insuranceKeyBenefits + '\'' +
                ", insuranceLifetime=" + insuranceLifetime +
                '}';

        assertEquals(expectedToString, insuranceAvailable.toString());
    }
}

