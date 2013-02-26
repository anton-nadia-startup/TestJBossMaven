package com.github.anton_nadia_startup.interfaces;

/**
 * User: anton_krupnov
 * Date: 2/25/13
 * Time: 5:00 PM
 */
public interface Post {

    String getSubject();
    String getText();
    void setSubject(String subject);
    void setText(String text);

}
