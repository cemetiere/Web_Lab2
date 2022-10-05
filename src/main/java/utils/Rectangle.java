package utils;


import java.util.logging.Logger;

public class Rectangle extends AbstractFigure{
    private static final Logger log = Logger.getLogger(Rectangle.class.toString());

    public Rectangle(){
        log.info("Rectangle was successfuly created");
    }

    @Override
    public boolean checkHit(int x, double y, int r){
        boolean result = x>=0 && y>=0 && y<=((double)r)/2 && x<=r;
        log.info("Checking rectangle: "+result);
        return result;
    }

}
