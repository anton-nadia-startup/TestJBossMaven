package impl;

import beans.Post;
import beans.PostImpl;

//import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Anton Krupnov
 * Date: 27.01.13
 * Time: 18:20
 */
@Named
@ApplicationScoped
public class PostsStub implements Posts {

    private ArrayList<Post> posts = new ArrayList<Post>();
    {
        posts.add(new PostImpl("First post", "First post body"));
        posts.add(new PostImpl("Second post", "Second post body"));

        System.out.println("impl.Posts init end");
    }

    @Override
    public List<Post> getPosts() {
        System.out.println("Get posts called");
        return posts;
    }

    public void addPost(Post post) {
        System.out.println("beans.Post added: " + post);
        posts.add(post);
    }

    public void addHardcodedPost() {
        System.out.println("Hardcoded post added");
        posts.add(new PostImpl("hardCoded", "hardcoded body"));
    }
}
