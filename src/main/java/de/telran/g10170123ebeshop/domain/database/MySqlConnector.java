package de.telran.g10170123ebeshop.domain.database;

import java.sql.Connection;
import java.sql.DriverManager;

import static de.telran.g10170123ebeshop.constants.Constants.*;

public class MySqlConnector {

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);
            // jdbc:mysql://localhost:3306/Shop_10-1701232-e-be?user=root&password=4Ikkalini

            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USER_NAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}