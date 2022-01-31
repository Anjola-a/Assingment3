package src;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class temp {
    public static void main(String []args){
        System.out.println("Hello World");
        // HashMap<IndicatorT, HashSet<LOsT>> m;
        HashMap<String, HashSet<String>> m = new HashMap<String, HashSet<String>>();
    
        m.put("Anjola", new HashSet<String>());
        m.put("Mum", new HashSet<String>());
        m.get("Mum").add("hi");
        
        // x = m.get("DAd");
        System.out.println(m.get("Anjola"));
        System.out.println(m.get("Mum"));

        double a[] = new double[] {0,0,0,0};
        System.out.println(Arrays.toString(a));

     }
}
