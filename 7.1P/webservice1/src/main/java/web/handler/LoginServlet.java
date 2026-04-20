package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        boolean result = LoginService.login(username, password, dob);
        String loginStatus = result ? "success" : "fail";

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head><title>" + loginStatus + "</title></head>");
        writer.println("<body>");
        writer.println("<h2>Login Status: " + loginStatus + "</h2>");
        writer.println("</body>");
        writer.println("</html>");
    }
}