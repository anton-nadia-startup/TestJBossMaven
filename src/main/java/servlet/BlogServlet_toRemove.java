package servlet;

import beans.Post;
import impl.PostsStub;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Anton Krupnov
 * Date: 27.01.13
 * Time: 18:57
 */
//@WebServlet("/Blog")
public class BlogServlet_toRemove extends HttpServlet {

    private static final String HTML_START = "<html><body>";
    private static final String HTML_END = "</html></body>";

    @Inject
    PostsStub posts;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(HTML_START);
        writer.println("<table border='1'>");

        posts = new PostsStub();
        for (Post post : posts.getPosts()) {
            writer.println("<tr>");
            printPost(writer, post);
            writer.println("<tr>");
        }

        writer.println("</table>");

        writer.println("<a href='add.jsf'>add</a>");

        writer.println(HTML_END);
    }

    private void printPost(PrintWriter writer, Post post) {
        writer.println("<td><h3>" + post.getSubject() + "</h3></td>");
        writer.println("<td>" + post.getBody() + "</td>");
    }
}
