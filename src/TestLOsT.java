/**
 * Author: 
 * Revised: 
 * 
 * Description: 
 */

package src;
import src.LOsT;
import src.IndicatorT;
import src.AttributeT;
import src.Norm;
import src.Services;
import org.junit.*;
import static org.junit.Assert.*;



public class TestLOsT
{
    private LOsT LO1 ;
    private LOsT LO2;
    private LOsT LO6;

    @Before
    public void setUp()
    {
        Norm.setNorms(false, true, false);
        LO1  = new LOsT("Cool", 5, 12, 234, 123);
        LO2 = new LOsT("Topic 2", 21, 92, 234, 103);
        LO6 = new LOsT("Cool", 5, 12, 234, 123);

    }

    @After
   public void tearDown()
   {
     LO1 = null;
     LO6 = null;
     LO2 = null;
   }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1()
    {
        LOsT LO3 = new LOsT("fail", -2, 0, 4, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2()
    {
        LOsT LO3 = new LOsT("fail", 0, 0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException3()
    {
        LOsT LO3 = new LOsT("fail", 0, 0, -3, 0);
    }

    @Test
    public void testGetName()
    {   
        assertTrue(LO1.getName() == "Cool");
        
    }

    @Test
    public void testGetName2()
    {   
        assertTrue(LO2.getName() == "Topic 2");
    }

    @Test
    public void testEquals()
    {
        assertFalse(LO2.equals(LO1));
    }

    @Test
    public void testEquals2()
    {
        assertTrue(LO6.equals(LO1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasureException1()
    {
        AttributeT A = new AttributeT("test", new IndicatorT[] {IndicatorT.modelSelect,
            IndicatorT.estOutcomes, IndicatorT.desProcess});
        LO1.measures(A);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasureException2()
    {
        LO1.measures(IndicatorT.math);
    }

    @Test
    public void testMeasure()
    {
        double arr[] = LO1.measures();
        assertTrue(arr[0]==5);
        assertTrue(arr[1]==12);
        assertTrue(arr[2]==234);
        assertTrue(arr[3]==123);
    }

    @Test
    public void testMeasure2()
    {
        double arr[] = LO2.measures();
        assertTrue(arr[0]==21);
        assertTrue(arr[1]==92);
        assertFalse(arr[2]==34);
        assertTrue(arr[3]==103);
    }


}
