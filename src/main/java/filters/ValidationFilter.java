package filters;

import java.io.IOException;

import beans.ValidationBean;
import jakarta.ejb.EJB;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ValidationFilter implements Filter{
    private final String path = "/error";

    @EJB
    private ValidationBean validator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var servletContext = request.getServletContext();
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
