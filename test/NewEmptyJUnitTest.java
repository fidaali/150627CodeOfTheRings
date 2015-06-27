/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import contest.OracleWorld;
import contest.Solver002;
import contest.Solver003;
import contest.Solver004_greedySimple;
import contest.SolverInterface;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     //@Test
    public void Solver002() {
         //assertEquals("Text", "Text");
        
        try{
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println(""+e.getStackTrace()[0]);
        }
        
         SolverInterface solv=new Solver002();
         
         String bigIn="THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";
         
         solv.input(""+bigIn);
         
         solv.output();
         
         System.out.println(""+solv);
         
        
    }
    
     @Test
    public void Solver003() {
        
        try{
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println(""+e.getStackTrace()[0]);
        }        
         //assertEquals("Text", "Text");
        
         SolverInterface solv=new Solver003();
         
         String bigIn="THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";
         
         solv.input(""+bigIn);
         
         solv.output();
         
         System.out.println(""+solv);
         
        
    }    
    
     @Test
    public void Solver004() {
        
        try{
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println(""+e.getStackTrace()[0]);
        }        
         //assertEquals("Text", "Text");
        
         SolverInterface solv=new Solver004_greedySimple();
         
         String bigIn="THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";
         
         solv.input(""+bigIn);
         
         solv.output();
         
         System.out.println(""+solv);
         
        
    }        
    
    @Test
    public void interpret(){
        
        try{
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println(""+e.getStackTrace()[0]);
        }         
        {
            String in ="+..........................";
            String out= OracleWorld.interpret(in);

            System.out.println(""+out);
        }
        {
            String in ="+>-[<.>-]";
            String out= OracleWorld.interpret(in);

            System.out.println(""+out);        
        }
    }
}
