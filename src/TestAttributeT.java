/**
 * Author: Anjola Adewale
 * Revised: 
 * 
 * Description: Test Cases for AttributeT java
 */

package src;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;
import static org.junit.Assert.*;
import src.AttributeT;
import src.IndicatorT;
public class TestAttributeT
{
    private AttributeT Design;
    private AttributeT Tools;
    private AttributeT ProbSolving;
    

    @Before
    public void setUp()
    {
        Design = new AttributeT("Design", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
            IndicatorT.openEnded, IndicatorT.ideaGeneration,
            IndicatorT.healthSafety, IndicatorT.standards});
        Tools = new AttributeT("Tools", new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, 
            IndicatorT.assumpt, IndicatorT.suitableFund, IndicatorT.recogTheory});
        ProbSolving = new AttributeT("ProbSolving", new IndicatorT[] {IndicatorT.modelSelect,
            IndicatorT.estOutcomes, IndicatorT.desProcess});
            

    }
    @After
    public void tearDown()
    {
        Design = null;
        Tools = null;
        ProbSolving = null;
        
    }

    @Test
    public void testgetName()
    {
        assertTrue(Design.getName() == "Design");
        assertTrue(Tools.getName() == "Tools");
        assertTrue(ProbSolving.getName() == "ProbSolving");
        assertFalse(ProbSolving.getName() == "");
    }

    @Test
    public void testgetIndicators()
    {
        ArrayList<IndicatorT> IndD = new ArrayList<IndicatorT>(
            Arrays.asList(IndicatorT.desProcess, IndicatorT.desPrinciples,
            IndicatorT.openEnded, IndicatorT.ideaGeneration,
            IndicatorT.healthSafety, IndicatorT.standards)
        );
        ArrayList<IndicatorT> IndT = new ArrayList<IndicatorT>(
            Arrays.asList(IndicatorT.math, IndicatorT.specEngKnow, 
            IndicatorT.assumpt, IndicatorT.suitableFund, IndicatorT.recogTheory)
        );
        for(IndicatorT i :Design.getIndicators()){
            assertTrue(IndD.contains(i));
        }
        for(IndicatorT i :Tools.getIndicators()){
            assertTrue(IndT.contains(i));
        }
    }

}
