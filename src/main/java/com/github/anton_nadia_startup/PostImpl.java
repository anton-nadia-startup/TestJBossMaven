package com.github.anton_nadia_startup;

import com.github.anton_nadia_startup.interfaces.Post;

/**
 * User: anton_krupnov
 * Date: 2/25/13
 * Time: 5:02 PM
 */
public class PostImpl implements Post{

    private String subject;
    private String text;

    public PostImpl() {
    }

    public PostImpl(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
