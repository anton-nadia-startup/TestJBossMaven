package com.github.anton_nadia_startup.jdbc.requests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * User: Anton Krupnov
 * Date: 17.04.12
 * Time: 23:29
 */
public class InsertRequest implements Request {

    private String postName;
    private String text;
    private String author;

    private InsertRequest(String postName, String text, String author) {
        this.postName = postName;
        this.text = text;
        this.author = author;
    }

    @Override
    public String getSQLRequest() {
        return "INSERT INTO posts (name, text, author) " +
               "VALUES ('" + postName + "', '" + text + "', '" + author + "')";
    }
    
    public static Request getInstance(String... item) {
        return getInstance(Arrays.asList(item));
    }

    public static Request getInstance(Collection<String> item) {
        Iterator<String> iterator = item.iterator();
        return getInstance(iterator.next(), iterator.next(), iterator.next());
    }

    public static Request getInstance(String postName, String text, String author) {
        return new InsertRequest(postName, text, author);
    }
}
