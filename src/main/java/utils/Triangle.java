package utils;

import java.util.logging.Logger;

public class Triangle extends AbstractFigure{
    private static final Logger log = Logger.getLogger(Triangle.class.toString());


    public Triangle(){
        log.info("Tringle was successfuly created");
    }

    @Override
    public boolean checkHit(int x, double y, int r){
        boolean result = x<=0 && y>=0 && y<=(x+r);
        log.info("Checking triangle: "+result);
        return result;
    }

}
