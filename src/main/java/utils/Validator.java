package utils;

import java.util.Arrays;

public class Validator {
    private int[] rArea = {1,2,3,4,5};
    private int[] xArea = {-4, -3, -2, -1, 0, 1, 2, 3, 4};

    public Validator(){
    }

    public boolean validate(String x, String y,String r){
        int parsedX;
        double parsedY;
        int parsedR;
        try{
            parsedX = Integer.parseInt(x);
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
