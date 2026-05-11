package web.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.DateUtilityService;
import web.service.LoginService;
import web.service.MathQuestionService;
import web.service.ScienceQuestionService;

public class RoutingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RoutingServlet() {
        super();
    }

    private void view(HttpServletRequest request, HttpServletResponse response, String jspName)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if (path.equals("/") || path.equals("/login")) {
            view(request, response, "view-login.jsp");
        } else if (path.equals("/q1")) {
            view(request, response, "view-q1.jsp");
        } else if (path.equals("/q2")) {
            view(request, response, "view-q2.jsp");
        } else if (path.equals("/q3")) {
            view(request, response, "view-q3.jsp");
        } else if (path.equals("/date1")) {
            view(request, response, "view-date1.jsp");
        } else if (path.equals("/date2")) {
            view(request, response, "view-date2.jsp");
        } else if (path.equals("/science")) {
            view(request, response, "view-science.jsp");
        } else if (path.equals("/complete")) {
            view(request, response, "view-complete.jsp");
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if (path.equals("/login")) {
            handleLogin(request, response);
        } else if (path.equals("/q1")) {
            handleQuestion1(request, response);
        } else if (path.equals("/q2")) {
            handleQuestion2(request, response);
        } else if (path.equals("/q3")) {
            handleQuestion3(request, response);
        } else if (path.equals("/date1")) {
            handleDateQuestion1(request, response);
        } else if (path.equals("/date2")) {
            handleDateQuestion2(request, response);
        } else if (path.equals("/science")) {
            handleScienceQuestion(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        boolean isValid = LoginService.login(username, password, dob);

        if (isValid) {
            response.sendRedirect("/q1");
        } else {
            request.setAttribute("message", "Invalid login details. Please try again.");
            view(request, response, "view-login.jsp");
        }
    }

    private void handleQuestion1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String answer = request.getParameter("answer");

        Double result = MathQuestionService.q1Addition(number1, number2);

        if (result != null && isCorrectAnswer(result, answer)) {
            response.sendRedirect("/q2");
        } else {
            request.setAttribute("message", "Wrong answer. Please enter valid numbers and try again.");
            view(request, response, "view-q1.jsp");
        }
    }

    private void handleQuestion2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String answer = request.getParameter("answer");

        Double result = MathQuestionService.q2Subtraction(number1, number2);

        if (result != null && isCorrectAnswer(result, answer)) {
            response.sendRedirect("/q3");
        } else {
            request.setAttribute("message", "Wrong answer. Please enter valid numbers and try again.");
            view(request, response, "view-q2.jsp");
        }
    }

    private void handleQuestion3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String answer = request.getParameter("answer");

        Double result = MathQuestionService.q3Multiplication(number1, number2);

        if (result != null && isCorrectAnswer(result, answer)) {
            response.sendRedirect("/date1");
        } else {
            request.setAttribute("message", "Wrong answer. Please enter valid numbers and try again.");
            view(request, response, "view-q3.jsp");
        }
    }

    private void handleDateQuestion1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String answer = request.getParameter("answer");

        boolean correct = DateUtilityService.isCorrectFutureDateAnswer("2026-05-11", 10, answer);

        if (correct) {
            response.sendRedirect("/date2");
        } else {
            request.setAttribute("message", "Wrong answer. Hint: use yyyy-MM-dd format.");
            view(request, response, "view-date1.jsp");
        }
    }

    private void handleDateQuestion2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String answer = request.getParameter("answer");

        boolean correct = DateUtilityService.isCorrectPastDateAnswer("2026-05-11", 7, answer);

        if (correct) {
            response.sendRedirect("/science");
        } else {
            request.setAttribute("message", "Wrong answer. Hint: count 7 days before the given date.");
            view(request, response, "view-date2.jsp");
        }
    }

    private void handleScienceQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String answer = request.getParameter("answer");

        boolean correct = ScienceQuestionService.isCorrectDensityAnswer("80", "20", answer);

        if (correct) {
            response.sendRedirect("/complete");
        } else {
            request.setAttribute("message", "Wrong answer. Hint: Density = Mass / Volume.");
            view(request, response, "view-science.jsp");
        }
    }

    private boolean isCorrectAnswer(double correctAnswer, String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        try {
            double answer = Double.parseDouble(userAnswer.trim());
            return Math.abs(correctAnswer - answer) < 0.01;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}