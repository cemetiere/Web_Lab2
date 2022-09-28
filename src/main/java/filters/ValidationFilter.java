package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import utils.Validator;

public class ValidationFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Validator validator = new Validator();
        String path = "/error";
        ServletContext servletContext = request.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        if (validator.validate(request.getParameter("x"), request.getParameter("y"), request.getParameter("r"))){
            chain.doFilter(request, response);
        } else {
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    } 
}
