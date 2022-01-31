/**
 *Author: Anjola Adewale
 *Revised: March 29, 2021
 * 
 *Description: Course ADT class

 */

package src;

import java.util.HashMap;
import java.util.HashSet;

/**
* @brief An ADT that represents a course
* @details The course is represented using it's name, 
* and a set list of indicators that map to learnign outocmes
*/

public class CourseT implements Measures{

    protected String name;
    protected HashMap<IndicatorT, HashSet<LOsT>> m;
    
   /**
   * @brief Initializes a course object.
   * @param n Name of the course
   * @param a Sequence of indicators
   */
    public CourseT(String n, IndicatorT[] a){
        name = n;
        m = new  HashMap<IndicatorT, HashSet<LOsT>>();
        for(IndicatorT i: a){
            m.put(i, new HashSet<LOsT>());
        }
    }

   /**
   * @brief Gets the course name
   * @return The name of the course
   */
    public String getName(){
        return name;
    }

   /**
   * @brief Gets the sequence of Indicators
   * @return The sequences of Indicators for the course
   */

    public IndicatorT[] getIndicators(){
        IndicatorT r[] =  new IndicatorT[m.size()]; 
        int b = 0;
        for (IndicatorT i: m.keySet()){
            r[b++] = i;
        }
        return r;
    }

    /**
   * @brief Gets the sequence of learning outcomes for a specicific indicator
   * @param x The specific indicator
   * @return The sequences of learning outcomes for the specified indicator
   */

    public LOsT[] getLOs(IndicatorT x){
        if (m.containsKey(x)){
            return set_to_seq(m.get(x));
            
        }
        LOsT arr[] = {};
        return arr;
    }

   /**
   * @brief Adds a learning outcome to a specified indicator
   * @param x The specific indicator
   * @param b  The learning outcome
   */

    public void addLO(IndicatorT x, LOsT b){
        if(m.containsKey(x)){
            m.get(x).add(b);
        }
        
    }

   /**
   * @brief Deletes a learning outcome from a specified indicator
   * @param x The specific indicator
   * @param b  The learning outcome
   */

    public void delLO(IndicatorT x, LOsT b){
        if(m.containsKey(x)){
            m.get(x).remove(b);
        }
    }

   /**
   * @brief Checks if an Indicator and it's list of learning outcomes
   * is a member of the course
   * @param x The specific indicator
   * @param b The seqeunce of learning outcomes for the indicator
   */

    public boolean member(IndicatorT x, LOsT[] b){
        if(m.containsKey(x)){
            for(LOsT i: b){
                if (!( m.get(x).contains(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

   /**
   * @brief Measures the learning outcomes, however this version is
   * unsupported for the courseT class.
   * @throws UnsupportedOperationException because this version of method
   * is not supported in the class
   */

    public double[] measures()
    {
        throw new  UnsupportedOperationException();
     
    }

    /**
   * @brief Measures the learning outcome in the indicator specified
   * @param ind The specific indicator
   * @returns A sequence of 4 doubles corresponding to the measures
   * of the 4 different categories - below expectations, marginal, 
   *  meetsexpectations and exceeds expectations
   */

    public double[] measures(IndicatorT ind)
    {   
        int l = this.getLOs(ind).length;
        double arr[][] = new double[l][l];
        int c = 0;

        for(LOsT i: this.getLOs(ind)){
            arr[c++] = i.measures();
        }
        double measureInd[] = new double[] {0,0,0,0};
        
        for (double[] j: arr){
            measureInd = sumMeas(measureInd, j);
        }
       
        if (this.getLOs(ind).length == 0){
            double a[] = new double[] {0,0,0,0};
            return a; 
        }
        if (Norm.getNInd()){
            return Services.normal(measureInd);
        }
        return measureInd;
    }

    /**
   * @brief Measures the learning outcome of each indicator of the 
   * specified attritbute
   * @param att The specific Attribute
   * @returns A sequence of 4 doubles corresponding to the measures
   * of the 4 different categories - below expectations, marginal, 
   *  meetsexpectations and exceeds expectations
   */

    public double[] measures(AttributeT att)
    {   
        int l = att.getIndicators().length;
        double arr[][] = new double[l][l];
        int c = 0;
      
        for(IndicatorT i: att.getIndicators()){
            arr[c++] = this.measures(i);
            
        }


        double measureInd[] = new double[] {0,0,0,0};
        for (double[] j: arr){
            measureInd = sumMeas(measureInd, j);
        }
       
        if (att.getIndicators().length == 0){
            double a[] = new double[] {0,0,0,0};
            return a; 
        }
        if (Norm.getNAtt()){
            return Services.normal(measureInd);
        }

        return measureInd;
     
    }

    /**
   * @brief Calculates the sume of two sequences
   * @param a Sequence to be added
   * @param b Sequence to be added
   * @returns A sequence which is the sum of the input sequences
   */

    private double[] sumMeas(double[] a, double[] b)
    {
        double[] ret = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i]+b[i];
        }
        return ret;
     
    }

   /**
   * @brief Converts a set to a sequence
   * @param s Set to be converted to a sequence
   * @returns A sequence of the elements form the set
   */
    private LOsT[] set_to_seq(HashSet<LOsT> s){
        LOsT[] ret = new LOsT[s.size()];
        int x = 0;
        for (LOsT i: s){
            ret[x++] = i;
        }
        return ret;
    }
}
