package utils;


import java.util.logging.Logger;

public class Circle extends AbstractFigure{
    private static final Logger log = Logger.getLogger(Circle.class.toString());


    public Circle(){
        log.info("Circle was successfuly created");
    }

    @Override
    public boolean checkHit(int x, double y, int r){
        double rr = Math.sqrt(x*x+y*y);
        boolean result = x>=0 && y<=0 && rr<=((double)r)/2;
        log.info("Checking circle: "+result);
        return result;
    }

}
