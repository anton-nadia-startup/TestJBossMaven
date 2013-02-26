package com.github.anton_nadia_startup;

import com.github.anton_nadia_startup.interfaces.Post;

import javax.faces.bean.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * User: anton_krupnov
 * Date: 2/25/13
 * Time: 5:07 PM
 */
@ApplicationScoped
public class Posts {

    private Collection<Post> posts = new ArrayList<Post>();
    private Collection<Post> readOnlyPosts = Collections.unmodifiableCollection(posts);

    public Collection<Post> getPosts() {
        return readOnlyPosts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

}
