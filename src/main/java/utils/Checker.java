package utils;

import java.util.logging.Logger;

public class Checker {
    private Triangle triangle;
    private Rectangle rectangle;
    private Circle circle;
    Logger log = Logger.getLogger(this.getClass().toString());
    public Checker(){
        this.triangle = new Triangle();
        this.rectangle = new Rectangle();
        this.circle = new Circle();
    }
    public boolean checkHit(int x, double y, int r){
        log.info("Checking x= " + x + " y=" + y + " " + " r="+r);
        return triangle.checkHit(x, y, r)||rectangle.checkHit(x, y, r)||circle.checkHit(x, y, r);
    }
}
