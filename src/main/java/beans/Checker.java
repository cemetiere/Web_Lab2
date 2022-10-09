package beans;

import java.util.List;
import java.util.logging.Logger;

import interfaces.AbstractFigure;
import jakarta.ejb.DependsOn;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import utils.Circle;
import utils.Rectangle;
import utils.Triangle;

@Startup
@DependsOn("ClientData")
@Singleton
public class Checker{ 

    private static final Logger log = Logger.getLogger(Checker.class.toString());
    private List<AbstractFigure> figureList = List.of(
        new Circle(),
        new Rectangle(),
        new Triangle()
    );
    public boolean checkHit(int x, double y, int r){
        log.info("Checking x= " + x + " y=" + y + " " + " r="+r);
        return figureList.stream().anyMatch(figure -> figure.checkHit(x, y, r)==true);
    }
}
