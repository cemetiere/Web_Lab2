package beans;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import utils.Result;

@SessionScoped
@Startup
@Singleton
public class ClientData {
    private ArrayList<Result> results = new ArrayList<>();
    public ArrayList<Result> getData(){
        return results;
    }
    public void setData(ArrayList<Result> results){
        this.results = results;
    }
    public void addData(Result result){
        results.add(result);
    }

}
