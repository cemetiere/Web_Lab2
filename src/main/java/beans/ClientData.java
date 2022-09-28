package beans;
import java.util.ArrayList;

import jakarta.ejb.Stateful;

import utils.Result;

@Stateful
public class ClientData {
    private ArrayList<Result> results = new ArrayList<>();
    public ArrayList<Result> getData(){
        return results;
    }
    public void setData(ArrayList<Result> results){
        this.results = results;
    }
}

