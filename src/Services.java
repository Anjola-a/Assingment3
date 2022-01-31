package src;

public class Services{

    public static double[] normal(double[] x){
        int sum = 0;
        for(double i: x){
            sum += i;
        }
        
        int c = 0;
        double out[] = new double[x.length];
        for(double i: x){
            out[c++] = (i*1.0)/sum;
        }
        return out;
    }

}