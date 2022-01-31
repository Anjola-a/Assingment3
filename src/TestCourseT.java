/**
 * Author: 
 * Revised: 
 * 
 * Description:
 */

package src;
import src.CourseT;
import src.LOsT;
import src.IndicatorT;
import src.AttributeT;
import src.Norm;
import src.Services;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
public class TestCourseT
{
    private CourseT S2XB3;
    private CourseT H2FF3;
    private CourseT DES;
    private IndicatorT[] Labs;
    private IndicatorT[] Anatomy;
    private IndicatorT[] Tools;
    private LOsT LO1;
    private LOsT LO2;
    private LOsT LO3;
    private LOsT LO4;
    private LOsT LO6;


    
   @Before
   public void setUp(){

    Norm.setNorms(false, false, false);
    LO1  = new LOsT("Cool", 5, 12, 234, 123);
    LO2 = new LOsT("Topic 2", 21, 92, 234, 103);
    LO3 = new LOsT("Topic 3", 21, 9, 34, 13);
    LO4 = new LOsT("Topic 4", 1, 4, 74, 63);
    LO6 = new LOsT("Test", 1, 4, 2, 3);

    
    Labs = new IndicatorT[]{
        IndicatorT.math, IndicatorT.recogTheory
    };
    Anatomy =  new IndicatorT[]{
        IndicatorT.healthSafety, IndicatorT.standards
    };
    Tools = new IndicatorT[]{IndicatorT.specEngKnow, 
        IndicatorT.assumpt, IndicatorT.suitableFund,
    };   
    
    S2XB3 = new CourseT("Lab course", Labs);
    H2FF3 = new CourseT("Anatomy and Physiology", Anatomy);
    DES = new CourseT("Design", Tools);
    S2XB3.addLO(IndicatorT.recogTheory, LO1);
    H2FF3.addLO(IndicatorT.healthSafety, LO3);
    H2FF3.addLO(IndicatorT.healthSafety, LO4);
    H2FF3.addLO(IndicatorT.standards, LO2);

    DES.addLO(IndicatorT.specEngKnow, LO2);
    DES.addLO(IndicatorT.specEngKnow, LO1);
    DES.addLO(IndicatorT.specEngKnow, LO4);
    

   }

   @After
   public void tearDown()
   {
     LO1 = null;
     LO3 = null;
     LO2 = null;
     LO4 = null;
     LO6 = null;
     H2FF3 = null;
     DES= null;
     S2XB3 = null;
   }


	@Test
    public void testGetName()
    {
        assertTrue(S2XB3.getName()=="Lab course");
    }
    
    @Test
    public void testGetName2()
    {
        assertTrue(H2FF3.getName()=="Anatomy and Physiology");
    }

    @Test
    public void testgetIndicators()
    {
        ArrayList<IndicatorT> IndA = new ArrayList<IndicatorT>( 
            Arrays.asList(IndicatorT.healthSafety, IndicatorT.standards
            )
        );
        IndicatorT[] Aind = H2FF3.getIndicators();
        assertTrue(IndA.contains(Aind[0]));
        assertTrue(IndA.contains(Aind[1]));
    }
    
    @Test
    public void testgetIndicators2()
    {
        ArrayList<IndicatorT> IndL = new ArrayList<IndicatorT>( 
            Arrays.asList(IndicatorT.math, IndicatorT.recogTheory
            )
        );
        IndicatorT[] Lind = S2XB3.getIndicators();
        assertTrue(IndL.contains(Lind[0]));
        assertTrue(IndL.contains(Lind[1]));
    }

    @Test
    public void testgetLOs(){
        ArrayList<LOsT> LO = new ArrayList<LOsT>( 
            Arrays.asList(LO3, LO4
            )
        );
        LOsT[] LOs = H2FF3.getLOs(IndicatorT.healthSafety);
        assertTrue(LO.contains(LOs[0]));
        assertTrue(LO.contains(LOs[1]));

    }

    @Test
    public void testgetLOs2(){
        
        LOsT[] LOs = H2FF3.getLOs(IndicatorT.math);
        assertTrue(LOs.length == 0);
        

    }

    @Test
    public void testgetLOs3(){
        ArrayList<LOsT> LO = new ArrayList<LOsT>( 
            Arrays.asList(LO1
            )
        );
        LOsT[] LOs = S2XB3.getLOs(IndicatorT.recogTheory);
        assertTrue(LO.contains(LOs[0]));
        assertTrue(LOs.length == 1);

    }

    @Test
    public void testAddLOs(){
        // Technically already tested in setUP
        S2XB3.addLO(IndicatorT.math, LO2);
        assertTrue(S2XB3.getLOs(IndicatorT.math)[0] == LO2);
        assertTrue(S2XB3.getLOs(IndicatorT.math).length == 1);
        
    }

    @Test
    public void testdelLOs(){
        ArrayList<LOsT> LO = new ArrayList<LOsT>( 
            Arrays.asList(LO3
            )
        );
        H2FF3.delLO(IndicatorT.healthSafety, LO3);
        LOsT[] LOs = H2FF3.getLOs(IndicatorT.healthSafety);
        assertFalse(LO.contains(LOs[0]));
        assertTrue(LOs.length == 1);
        
    }
    @Test
    public void testdelLOs2(){
        assertTrue(true);
        // // re check
        // H2FF3.delLO(IndicatorT.healthSafety, LO2);
        // LOsT[] LOs = H2FF3.getLOs(IndicatorT.healthSafety);
        // assertFalse(LO.contains(LOs[0]));
        // assertTrue(LOs.length == 1);
        
    }
// 
    @Test
    public void member(){
        LOsT outcomes[] = new LOsT[] {LO1, LO2, LO4};
        assertTrue(DES.member(IndicatorT.specEngKnow, outcomes));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasureException()
    {
       S2XB3.measures();
    }

    @Test
    public void testMeasure()
    {
        for (double i :DES.measures(IndicatorT.assumpt)){
            assertTrue(i == 0);
        }
    }

    @Test
    public void testMeasure2(){
    // {   normals(mesInd)
        // temp 27,108,542, 289, 966
        double expected[] = new double[] {27, 108, 542, 289};
        Norm.setNorms(false, false, false);
        double arr[] = DES.measures(IndicatorT.specEngKnow);
        int c = 0;
        for (double i : arr){
            assertTrue(Math.abs(expected[c] - i) < 0.002);
            c++;
        }
           
    }

    @Test
    public void testMeasure3(){
        Norm.setNorms(false, true, false);
        double expected[] = new double[] {0.027950310559006212, 0.11180124223602485, 0.5610766045548654, 0.2991718426501035};
        
        double arr[] = DES.measures(IndicatorT.specEngKnow);
        int c = 0;
        for (double i : arr){
            assertTrue(Math.abs(expected[c] - i) < 0.0002);
            c++;
        }
           
    }

    @Test
    public void testMeasureAtt1()
    {   AttributeT Know = new AttributeT("Knowledge Base for Engineering", new IndicatorT[] {});
        for (double i :DES.measures(Know)){
            assertTrue(i == 0);
        }
    }

    @Test
    public void testMeasureAtt(){
    
        DES.addLO(IndicatorT.assumpt, LO6);
        AttributeT Know = new AttributeT("Knowledge Base for Engineering", new IndicatorT[] {IndicatorT.specEngKnow, IndicatorT.assumpt});
        double expected[] = new double[] {28, 112, 544, 292};
        
        Norm.setNorms(false, false, false);
        double arr[] = DES.measures(Know);
        int c = 0;
       
        for (double i : arr){
            assertTrue(Math.abs(expected[c] - i) < 0.02);
            c++;
        }
           
    }
      
}
