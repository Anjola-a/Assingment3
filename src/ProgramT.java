package src;

import java.util.HashSet;

public class ProgramT extends HashSet<CourseT> implements Measures{
    
    private HashSet<CourseT> s = this;

    public double[] measures()
    {
        throw new  UnsupportedOperationException();
     
    }

    public double[] measures(IndicatorT ind)
    {
        throw new  UnsupportedOperationException();
    }

    public double[] measures(AttributeT att)
    {
        double measureInd[] = new double[] {0,0,0,0};

        for(CourseT c: s){
            measureInd = sumMeas(measureInd,c.measures(att));
        }
        return Services.normal(measureInd);
     
    }
    
    private double[] sumMeas(double[] a, double[] b)
    {
        double[] ret = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i]+b[i];
        }
        return ret;
     
    }

}
