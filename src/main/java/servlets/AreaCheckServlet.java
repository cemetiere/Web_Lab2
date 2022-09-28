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
    private ClientData data = new ClientData();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        checkAndUpdateData(request);
        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
    }


    protected void checkAndUpdateData(HttpServletRequest request){
        long start = System.nanoTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = formatter.format(date);
        Checker checker = new Checker();
        int x = (int)Math.round(Double.parseDouble(request.getParameter("x")));
        double y = Double.parseDouble(request.getParameter("y"));
        int r = Integer.parseInt(request.getParameter("r"));
        boolean hitFact = checker.checkHit(x, y, r);
        String executionTime = String.format("%.6f", (System.nanoTime() - start) * 10e-9).replace(",", ".");
        Result result = new Result(x, y, r, currentTime, executionTime, hitFact);
        ArrayList<Result> results = data.getData();
        results.add(result);
        getServletContext().setAttribute("data", data);
        data.setData(results);
    }
}
