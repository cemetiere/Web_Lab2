package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import utils.Result;
import utils.Checker;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.ClientData;

public class AreaCheckServlet extends HttpServlet{
    private final ClientData data = new ClientData();
    private final Checker checker = new Checker();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        checkAndUpdateData(request);
        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
    }
    
    private void checkAndUpdateData(HttpServletRequest request){
        long start = System.nanoTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = formatter.format(date);
        int x = (int)Math.round(Double.parseDouble(request.getParameter("x")));
        double y = Double.parseDouble(request.getParameter("y"));
        int r = Integer.parseInt(request.getParameter("r"));
        boolean hitFact = checker.checkHit(x, y, r);
        String executionTime = String.format("%.6f", (System.nanoTime() - start) * 10e-9).replace(",", ".");
        Result result = new Result(x, y, r, currentTime, executionTime, hitFact);
        ArrayList<Result> results = data.getData();
        results.add(result);
        request.setAttribute("data", data);
        getServletContext().setAttribute("data", data);
        data.setData(results);
    }
}
