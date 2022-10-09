package servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import beans.DataManagerBean;

public class AreaCheckServlet extends HttpServlet{
    @EJB
    private DataManagerBean dataManagerBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        dataManagerBean.checkAndUpdateData(request, getServletContext());
        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
    }
    
}
