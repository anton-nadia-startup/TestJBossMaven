package com.github.anton_nadia_startup.handlers;

import com.github.anton_nadia_startup.PostImpl;
import com.github.anton_nadia_startup.Posts;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * User: anton_krupnov
 * Date: 2/26/13
 * Time: 10:50 AM
 */
@SuppressWarnings("UnusedDeclaration")
@Named
@ApplicationScoped
public class AddPostHandler {

    private Posts posts;
    private String subject = "default";
    private String text = "default";

    public Posts getPosts() {
        return posts;
    }

    @Inject
    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public void addPost() {
        posts.addPost(new PostImpl(subject, text));
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
