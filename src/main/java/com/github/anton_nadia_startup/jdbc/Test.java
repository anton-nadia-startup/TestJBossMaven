package com.github.anton_nadia_startup.jdbc;

import junit.framework.TestCase;
import com.github.anton_nadia_startup.jdbc.requests.InsertRequest;
import com.github.anton_nadia_startup.jdbc.requests.RemoveRequest;
import com.github.anton_nadia_startup.jdbc.requests.SelectRequest;

/**
 * User: Anton Krupnov
 * Date: 18.04.12
 * Time: 0:02
 */
public class Test extends TestCase {

    private static final String[] ITEM = new String[]{"Post Name", "Text", "Author"};

    public void test() throws Exception {
        SelectRequest.printResult(DAO.perform(SelectRequest.getInstance()));

        System.out.println("=== INSERT ===");
        DAO.perform(InsertRequest.getInstance(ITEM));

        SelectRequest.printResult(DAO.perform(SelectRequest.getInstance()));

        System.out.println("=== REMOVE ===");
        DAO.perform(RemoveRequest.getInstance(ITEM[0]));

        SelectRequest.printResult(DAO.perform(SelectRequest.getInstance()));
    }
}
