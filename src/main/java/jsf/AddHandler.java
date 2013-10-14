package jsf;

import beans.PostImpl;
import impl.PostsStub;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * User: Anton Krupnov
 * Date: 27.01.13
 * Time: 23:33
 */
@ManagedBean
@ViewScoped
public class AddHandler {

    private String subject;
    private String body;

    @Inject
    PostsStub postsStub;

    public String getSubject() {
        System.out.println("Get subject: " + subject);
        return subject;
    }

    public String getBody() {
        System.out.println("Get body: " + body);
        return body;
    }

    public void setSubject(String subject) {
        System.out.println("Set subject: " + subject);
        this.subject = subject;
    }

    public void setBody(String body) {
        System.out.println("Set body: " + body);
        this.body = body;
    }

    public void add() {
        System.out.println("Handler is adding post with subject: " + subject + " and body: " + body);
        if (subject != null && body != null) {
            postsStub.addPost(new PostImpl(subject, body));
            subject = null;
            body = null;
        }
    }

}
