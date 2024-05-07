package com.mybank.insurance.webservice.rest.controller;
import com.mybank.dao.insurance.exceptions.CustomerException;
import com.mybank.dao.insurance.exceptions.InsuranceNotFoundException;
import com.mybank.dao.insurance.remotes.InsuranceAvailableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.ResourceBundle;
@RestController
@RequestMapping("/insurance")
public class InsuranceAvailableController {
    @Autowired
    private  InsuranceAvailableRepository availableDbRepo;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("app");
    Logger logger = LoggerFactory.getLogger(InsuranceAvailableController.class);
    @GetMapping("/getid/{numbers}")
    public ResponseEntity<Object> gettingOne(@PathVariable("numbers") String number1){
        try {
            if (!isValidStartLimit(number1)) {
                return ResponseEntity.badRequest().body(resourceBundle.getString("enter.proper.limits"));
            }
            Integer number=Integer.valueOf(number1);
            return ResponseEntity.ok(availableDbRepo.apiFindById(number));
        }catch (InsuranceNotFoundException availedException) {
            logger.error(resourceBundle.getString("insurance.20001.error") + availedException);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceBundle.getString("insurance.20001.error"));
        }catch (SQLException exception){
            logger.error(resourceBundle.getString("insurance.error") + exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resourceBundle.getString("insurance.error"));
        }catch (CustomerException customerException){
            logger.error(resourceBundle.getString("insurance.inactive")+customerException);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resourceBundle.getString("insurance.inactive"));
        }
    }
    private boolean isValidStartLimit(String number1){
        return number1 != null && !number1.isEmpty() && number1.matches("^(0|[1-9][0-9]*)$");
    }


}


