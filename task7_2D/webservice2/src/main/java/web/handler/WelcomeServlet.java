package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Welcome</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome, server is running!</h1>");
        out.println("<p><a href='/login.html'>Go to Login</a></p>");
        out.println("<p><a href='/register.html'>Go to Registration</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}