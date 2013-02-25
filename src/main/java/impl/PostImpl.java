package impl;

import interfaces.Post;

/**
 * User: Anton Krupnov
 * Date: 27.01.13
 * Time: 18:21
 */
public class PostImpl implements Post {

    private String subject;
    private String body;

    public PostImpl(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getBody() {
        return body;
    }

}
