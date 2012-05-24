package com.github.anton_nadia_startup.jdbc.requests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Anton Krupnov
 * Date: 18.04.12
 * Time: 0:46
 */
public class SelectRequest implements Request {

    static SelectRequest selectRequest;
    private static List<String[]> result;

    private SelectRequest() { }

    public static SelectRequest getInstance() {
        if (selectRequest == null) {
            selectRequest = new SelectRequest();
        }
        return selectRequest;
    }

    @Override
    public String getSQLRequest() {
        return "SELECT * FROM POSTS";
    }

    public static List<String[]> parse(Object result) throws SQLException {
        ResultSet resultSet = (ResultSet) result;
        List<String[]> items = new ArrayList<String[]>();
        for (;resultSet.next();) {
            String[] item = new String[3];
            item[0] = resultSet.getString(2);
            item[1] = resultSet.getString(3);
            item[2] = resultSet.getString(4);
            items.add(item);
        }
        return items;
    }

    public static void printResult(Object result) {
        List<String[]> strings = (List<String[]>) result;
        int i = 0;
        for (String[] item : strings) {
            i++;
            System.out.println(
                    "Item " + i + ": \t" +
                        "name=" + item[0] + ", " +
                        "text=" + item[1] + ", " +
                        "author=" + item[2]);
        }
    }
}
