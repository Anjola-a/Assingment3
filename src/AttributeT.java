/**
 * Author: Anjola Adewale
 * Date: March 23, 2021
 * 
 * Description: CHANGE ME
 */

package src;
import java.util.HashSet; 

public class AttributeT{

    protected String name;
    protected HashSet<IndicatorT> s = new HashSet<IndicatorT>();

    public AttributeT(String n, IndicatorT[] arrS)
    {
      name = n;
      for(IndicatorT i: arrS)

      {
         if (!(s.contains(i))){
            s.add(i);
         }   
      }
    } 

    public String getName()
    {
      return name;
    }

    public IndicatorT[] getIndicators()
    {
      IndicatorT arr[] = new IndicatorT[s.size()];
      int i = 0;
      for(IndicatorT ind: s){
        arr[i++] = ind;
      }
      return arr;
    }
    

    
}