package utils;

import java.util.logging.Logger;

public class Triangle extends AbstractFigure{
    Logger log = Logger.getLogger(this.getClass().toString());


    public Triangle(){
        log.info("Tringle was successfuly created");
    }

    @Override
    public boolean checkHit(int x, double y, int r){
        return x<=0 && y>=0 && y<=(x+r);
    }

}
