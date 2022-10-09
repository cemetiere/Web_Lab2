package utils;


import java.util.logging.Logger;

import interfaces.AbstractFigure;

public class Rectangle implements AbstractFigure{
    private static final Logger log = Logger.getLogger(Rectangle.class.toString());

    @Override
    public boolean checkHit(int x, double y, int r){
        boolean result = x>=0 && y>=0 && y<=((double)r)/2 && x<=r;
        log.info("Checking rectangle: "+result);
        return result;
    }

}
