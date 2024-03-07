package org.example;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.util.ResourceBundle;

public class CreatingTable {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Driver driver =new OracleDriver();

    }
}
