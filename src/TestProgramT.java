/**
 * Author:
 * Revised:
 * 
 * Description:
 */

package src;
import src.Norm;
import src.ProgramT;
import src.CourseT;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

public class TestProgramT
{
    private ProgramT P;
    private CourseT S2XB3;
    private CourseT H2FF3;
    private IndicatorT[] Labs;
    private IndicatorT[] Anatomy;
    private AttributeT ProbSolving;
	

    @Before
    public void setUp()
    {   
        Norm.setNorms(false, false, false);
        ProbSolving = new AttributeT("ProbSolving", new IndicatorT[] {IndicatorT.modelSelect,
        IndicatorT.estOutcomes, IndicatorT.desProcess});
        
        Labs = new IndicatorT[]{
            IndicatorT.modelSelect,
        IndicatorT.estOutcomes, IndicatorT.desProcess
        };
        Anatomy =  new IndicatorT[]{
            IndicatorT.modelSelect,
        IndicatorT.estOutcomes, IndicatorT.desProcess
        };
        P = new ProgramT();
        S2XB3 = new CourseT("Lab course", Labs);
        H2FF3 = new CourseT("Anatomy and Physiology", Anatomy);
        S2XB3.addLO(IndicatorT.desProcess, new LOsT("Select among development doc templates", 50, 5, 2, 30));
        S2XB3.addLO(IndicatorT.desProcess, new LOsT("Topic 2", 7, 8, 5, 10));
        H2FF3.addLO(IndicatorT.modelSelect, new LOsT("Topic 3", 1, 2, 4, 12));
        H2FF3.addLO(IndicatorT.estOutcomes, new LOsT("Test Case", 23, 31, 4, 26));
        P.add(S2XB3);
        P.add(H2FF3);

    }

    @After
   public void tearDown()
   {
     P = null;
     H2FF3 = null;
     S2XB3 = null;
     ProbSolving = null;
     Anatomy = null;
     Labs = null;
   }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasureException1()
    {
        P.measures(IndicatorT.math);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasureException2()
    {
        P.measures();
    }

	@Test
    public void testMeasure()
    {
        double arr[] = P.measures(ProbSolving);
        double exp[] = new double[] {0.36818181818181817, 0.20909090909090908, 0.06818181818181818, 0.35454545454545455};

        int c = 0;
        
        for(double i : arr){
            assertTrue(i== exp[c]);
            assertTrue(Math.abs(exp[c] - i) < 0.002);
            c++;
        }
    }

    @Test
    public void testMeasure2()
    {
        Norm.setNorms(false, true, false);
        double arr[] = P.measures(ProbSolving);
        double exp[] = new double[] {0.8136205899363794, 0.585421888053467, 0.3179744232375811, 1.2829830987725725};
        int c = 0;
        for(double i : arr){
            assertTrue(i== exp[c]);
            assertTrue(Math.abs(exp[c] - i) < 0.002);
            c++;
        }
    }

}
