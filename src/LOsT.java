package src;


public class LOsT implements Measures{

    protected String name;
    protected int n_blw;
    protected int n_mrg;
    protected int n_mts;
    protected int n_exc;

    public LOsT(String n, int a, int b, int c, int d)
    {
      if (a < 0 || b < 0 || c < 0 || d < 0){
          throw new IllegalArgumentException("Measures can not be less than zer0");
      }

      if (a == 0 && b == 0 && c == 0 && d == 0){
        throw new IllegalArgumentException("Measures can not be equal than zer0");
    }
      name = n;
      n_blw = a;
      n_mrg = b;
      n_mts = c;
      n_exc = d;
    }

    public String getName()
    {
      return name;
    }

    public boolean equals(LOsT L)
    {
      return name == L.getName();
    }

    public boolean equals(Object o) {
  
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
  
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof LOsT)) {
            return false;
        }
          LOsT l = (LOsT) o;

         return name == l.getName();
    }
    
    public double[] measures()
    {
        double[] arr = {n_blw*1.0, n_mrg*1.0, n_mts*1.0, n_exc*1.0};
     if(!(Norm.getNLOs())) {
        
         return arr;
     }
        return(Services.normal(arr));
     
    }

    public double[] measures(IndicatorT ind)
    {
        throw new  UnsupportedOperationException();
    }

    public double[] measures(AttributeT att)
    {
        throw new  UnsupportedOperationException();
     
    }
 
}
