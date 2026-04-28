package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome ...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("Login view ...");
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("Login form ...");

        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
        System.out.println("DOB = " + dob);

        if (LoginService.login(username, password, dob)) {
            return new RedirectView("/q1", true);
        } else {
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
            return new RedirectView("/login", true);
        }
    }

    @GetMapping("/q1")
    public String q1View() {
        System.out.println("Q1 view ...");
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("Q1 form ...");

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        System.out.println("Q1 number1 = " + number1);
        System.out.println("Q1 number2 = " + number2);
        System.out.println("Q1 user answer = " + resultUser);

        Double calculatedResult = MathQuestionService.q1Addition(number1, number2);
        System.out.println("Q1 calculated answer = " + calculatedResult);

        try {
            double userAnswer = Double.parseDouble(resultUser.trim());

            if (calculatedResult != null && Math.abs(calculatedResult - userAnswer) < 0.001) {
                return new RedirectView("/q2", true);
            } else {
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
                return new RedirectView("/q1", true);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Please enter valid numbers.");
            return new RedirectView("/q1", true);
        }
    }

    @GetMapping("/q2")
    public String q2View() {
        System.out.println("Q2 view ...");
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("Q2 form ...");

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        System.out.println("Q2 number1 = " + number1);
        System.out.println("Q2 number2 = " + number2);
        System.out.println("Q2 user answer = " + resultUser);

        Double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
        System.out.println("Q2 calculated answer = " + calculatedResult);

        try {
            double userAnswer = Double.parseDouble(resultUser.trim());

            if (calculatedResult != null && Math.abs(calculatedResult - userAnswer) < 0.001) {
                return new RedirectView("/q3", true);
            } else {
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
                return new RedirectView("/q2", true);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Please enter valid numbers.");
            return new RedirectView("/q2", true);
        }
    }

    @GetMapping("/q3")
    public String q3View() {
        System.out.println("Q3 view ...");
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("Q3 form ...");

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        System.out.println("Q3 number1 = " + number1);
        System.out.println("Q3 number2 = " + number2);
        System.out.println("Q3 user answer = " + resultUser);

        Double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
        System.out.println("Q3 calculated answer = " + calculatedResult);

        try {
            double userAnswer = Double.parseDouble(resultUser.trim());

            if (calculatedResult != null && Math.abs(calculatedResult - userAnswer) < 0.001) {
                redirectAttributes.addFlashAttribute("message", "Congratulations! You completed the STEM game.");
                return new RedirectView("/", true);
            } else {
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
                return new RedirectView("/q3", true);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Please enter valid numbers.");
            return new RedirectView("/q3", true);
        }
    }
}