package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        boolean result = registrationService.register(
                firstName,
                lastName,
                email,
                phone,
                username,
                password,
                confirmPassword
        );

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Registration Result</title></head>");
        out.println("<body>");

        if (result) {
            out.println("<h1 id='result'>Registration successful</h1>");
            out.println("<p>User has been registered successfully.</p>");
        } else {
            out.println("<h1 id='result'>Registration failed</h1>");
            out.println("<p>Please check your details and try again.</p>");
        }

        out.println("<a href='/register.html'>Back to Registration</a>");

        out.println("</body>");
        out.println("</html>");
    }
}