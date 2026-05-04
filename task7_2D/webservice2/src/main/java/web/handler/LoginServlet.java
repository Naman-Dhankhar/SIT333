package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean result = loginService.login(username, password);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Login Result</title></head>");
        out.println("<body>");

        if (result) {
            out.println("<h1 id='result'>Login successful</h1>");
            out.println("<p>Welcome, " + username + ".</p>");
        } else {
            out.println("<h1 id='result'>Login failed</h1>");
            out.println("<p>Invalid username or password.</p>");
        }

        out.println("<a href='/login.html'>Back to Login</a>");

        out.println("</body>");
        out.println("</html>");
    }
}