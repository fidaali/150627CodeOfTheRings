/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import contest.GreedyTools;
import contest.GreedyTools2;
import contest.OracleWorld;
import contest.Solver002;
import contest.Solver003;
import contest.Solver004_greedySimple;
import contest.Solver005;
import contest.Solver006;
import contest.SolverInterface;
import contest.SubStringFrequency;
import contest.Utils;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jahan
 */
public class NewEmptyJUnitTest {

    static final String longSpell = "THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public void interpret() {

        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }
        {
            String in = "+..........................";
            String out = OracleWorld.interpret(in,new Utils.World());

            System.out.println("" + out);
        }
        {
            String in = "+>-[<.>-]";
            String out = OracleWorld.interpret(in,new Utils.World());

            System.out.println("" + out);
        }
    }
    
    //@Test
    public void transCostTest(){
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }
         //assertEquals("Text", "Text");

        GreedyTools gt=new GreedyTools();

        String bigIn = "THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";

        gt.calcGreedyCost(bigIn);
        System.out.println(gt.calced);
        
        GreedyTools2 gt2=new GreedyTools2();
        gt2.prepareOptimize(gt.calced, new ArrayList<>());
        
    }

    public void SubStringTest() {

        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }

//        {
//            SubStringFrequency sf = new SubStringFrequency("MAMANAZAIBOKO");
//            for (int i = 0; i < 2; i++) {
//                sf.addUpTo(i + 1);
//            }
//            sf.sort();
//
//            sf.debug_out();
//        }

        {
            SubStringFrequency sf = new SubStringFrequency(longSpell);
            for (int i = 0; i < 4; i++) {
                sf.addUpTo(i + 1);
            }
            sf.sort();

            sf.debug_out();
        }

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void Solver002() {
         //assertEquals("Text", "Text");

        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }

        SolverInterface solv = new Solver002();

        solv.input("" + longSpell);

        solv.output();

        System.out.println("" + solv);

    }

    //@Test
    public void Solver003() {

        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }
         //assertEquals("Text", "Text");

        SolverInterface solv = new Solver003();

        String bigIn = "THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";

        solv.input("" + bigIn);

        solv.output();

        System.out.println("" + solv);

    }

    //@Test
    public void Solver004() {

        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }
         //assertEquals("Text", "Text");

        SolverInterface solv = new Solver004_greedySimple();

        String bigIn = "THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";

        solv.input("" + bigIn);

        solv.output();

        System.out.println("" + solv);

    }

    //@Test
    public void Solver005() {

        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }

        long t0 = System.currentTimeMillis();

         //assertEquals("Text", "Text");
        SolverInterface solv = new Solver005();

        String bigIn = "THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";

        solv.input("" + bigIn);

        String out = solv.output();

        long t1 = System.currentTimeMillis();

        double t = t1 - t0;
        System.out.println("Time in milli " + t);

        System.out.println("" + out);
        System.out.println("Resp len " + out.length());
        System.out.println("" + OracleWorld.interpret(out,new Utils.World()));

    }
    
    @Test
    public void Solver006(){
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }        
    
        {
            String bigIn = "";
            for(int i=0;i<70;i++){
                bigIn+="Z";
            }

            Solver006 solv=new Solver006() ;

            solv.input(bigIn);
            if(solv.applicable()){
                System.err.println("is applicable");
                String out = solv.output();
                assertEquals(""+bigIn, OracleWorld.interpret(out,new Utils.World()));
                System.out.println("Prog = "+out);
            }else{
                throw new RuntimeException("Supposed to be applicable");
            }
        }
    }

}
