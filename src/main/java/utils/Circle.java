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
        boolean result = x>=0 && y<=0 && rr<=((double)r)/2;
        log.info("Checking circle: "+result);
        log.info("Checking x>=0: "+(x>=0));
        log.info("Checking y<=0: "+(y<=0));
        log.info("rr = Math.sqrt(x*x+y*y): "+Math.sqrt(x*x+y*y));
        log.info("Checking rr<=((double)r)/2: "+(rr<=((double)r)/2));
        return result;
    }

}
