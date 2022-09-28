package utils;


import java.util.logging.Logger;

public class Circle extends AbstractFigure{
    Logger log = Logger.getLogger(this.getClass().toString());


    public Circle(){
        log.info("Circle was successfuly created");
    }

    @Override
    public boolean checkHit(int x, double y, int r){
        double rr = Math.sqrt(x*x+y*y);
        return x>=0 && y<=0 && rr<=r;
    }

}
