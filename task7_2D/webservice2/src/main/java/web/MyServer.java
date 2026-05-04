package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

public class MyServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // This tells Jetty to serve HTML files from the pages folder
        context.setResourceBase("pages");

        // Servlet mappings
        context.addServlet(WelcomeServlet.class, "/");
        context.addServlet(LoginServlet.class, "/login");
        context.addServlet(RegistrationServlet.class, "/reg");

        // This allows login.html and register.html to open in the browser
        ServletHolder defaultServlet = new ServletHolder("default", DefaultServlet.class);
        defaultServlet.setInitParameter("dirAllowed", "true");
        context.addServlet(defaultServlet, "/*");

        server.setHandler(context);

        server.start();

        System.out.println("Server started successfully.");
        System.out.println("Home: http://localhost:8080/");
        System.out.println("Login page: http://localhost:8080/login.html");
        System.out.println("Registration page: http://localhost:8080/register.html");

        server.join();
    }
}