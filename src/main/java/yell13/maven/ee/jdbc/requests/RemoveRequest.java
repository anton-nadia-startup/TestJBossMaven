package yell13.maven.ee.jdbc.requests;

/**
 * User: Anton Krupnov
 * Date: 18.04.12
 * Time: 1:10
 */
public class RemoveRequest implements Request {

    private String name;

    private RemoveRequest(String name) {
        this.name = name;
    }

    public static RemoveRequest getInstance(String postName) {
        return new RemoveRequest(postName);
    }

    @Override
    public String getSQLRequest() {
        return "DELETE FROM POSTS WHERE name='" + name + "'";
    }
}
