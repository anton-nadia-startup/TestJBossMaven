package com.github.anton_nadia_startup.jdbc;

import com.github.anton_nadia_startup.jdbc.requests.InsertRequest;
import com.github.anton_nadia_startup.jdbc.requests.RemoveRequest;
import com.github.anton_nadia_startup.jdbc.requests.Request;
import com.github.anton_nadia_startup.jdbc.requests.SelectRequest;

import java.sql.*;

/**
 * User: Anton Krupnov
 * Date: 17.04.12
 * Time: 23:26
 */
public class DAO {

    private static final String URL = "jdbc:mysql://localhost:3306/default?user=root&password=root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Object perform(Request dbReq) throws Exception {
        Connection connection = null;
        Statement statement = null;
        Object result = 0;
        try {
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();
            if (dbReq instanceof InsertRequest) {
                result = statement.executeUpdate(dbReq.getSQLRequest());
            } else if (dbReq instanceof SelectRequest) {
                result = SelectRequest.parse(statement.executeQuery(dbReq.getSQLRequest()));
            } else if (dbReq instanceof RemoveRequest) {
                result = statement.executeUpdate(dbReq.getSQLRequest());
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

}
