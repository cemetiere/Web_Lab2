package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.ejb.DependsOn;
import jakarta.ejb.EJB;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import utils.Result;

@Startup
@DependsOn("Checker")
@Stateless
public class DataManagerBean {
    @EJB
    private ClientData data;
    @EJB
    private Checker checker;

    public void checkAndUpdateData(HttpServletRequest request, ServletContext context){
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
        data.addData(result);
        context.setAttribute("data",data.getData());
    }
}
