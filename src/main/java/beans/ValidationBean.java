package beans;

import java.util.Arrays;

import interfaces.ValidatorInterface;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class ValidationBean implements ValidatorInterface { 
    private int[] rArea = {1,2,3,4,5};
    private int[] xArea = {-4, -3, -2, -1, 0, 1, 2, 3, 4};

    public boolean validate(String x, String y,String r){
        int parsedX;
        double parsedY;
        int parsedR;
        try{
            parsedX = (int)Math.round(Double.parseDouble(x));
            parsedY = Double.parseDouble(y);
            parsedR = Integer.parseInt(r);
        }catch(Exception ex){
            return false;
        }
        return validateX(parsedX) && validateY(parsedY) && validateR(parsedR);
    }

    public boolean validateX(int x){
        return Arrays.stream(xArea).anyMatch(k  -> k == x);
    }

    public boolean validateY(double y){
        return y>-3 && y<3;
    }

    public boolean validateR(int r){
        return Arrays.stream(rArea).anyMatch(x  -> x == r);
    }
}
