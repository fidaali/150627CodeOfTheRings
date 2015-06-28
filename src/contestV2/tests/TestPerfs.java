/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2.tests;

import contest.OracleWorld;
import contest.Utils;
import contestV2.ProblemCollection;
import contestV2.ProblemCollection.ProblemCollectionI;
import contestV2.SimpleStrat;
import contestV2.SolverV2;
import contestV2.Solver_001;
import contestV2.Testeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class TestPerfs {
    
    public static void checkOracle(List<SolverV2.SolveurV2I> toApply,ProblemCollectionI toTest){
        // Oracle check
        for(SolverV2.SolveurV2I sol : toApply){
            long t0=System.currentTimeMillis();
            
            int totStep=0;
            int totInst=0;
            
            for(String prob : toTest.getProblems()){
                
                Testeur.TestOne t=new Testeur.TestOne(prob, new SolverV2.WorldV2(), sol.apply(prob));
                
                totInst+=t.instCost();
                totStep+=t.stepCost();
                
                String res=OracleWorld.interpret(t.program(), new Utils.World());
                
                if(!res.equals(prob)){
                    System.out.println("ERREUR FATALE");
                    System.out.println(""+prob);
                    System.out.println(""+res);
                    System.out.flush();                    
                    
                    System.err.println("ATTENDU "+prob);
                    System.err.println("OBTENU "+res);                    
                    throw new RuntimeException("Desole, mais ca fonctionne pas !");
                }
            }

            long t1=System.currentTimeMillis();
            long t=t1-t0;
            

        }          
    }
    
    public static void testDetail(ProblemCollectionI toTest,List<SolverV2.SolveurV2I> toApply){                    
        for(SolverV2.SolveurV2I sol : toApply){
            long t0=System.currentTimeMillis();
            
            int totStep=0;
            int totInst=0;
            
            for(String prob : toTest.getProblems()){
                long t2=System.currentTimeMillis();
                
                Testeur.TestOne t=new Testeur.TestOne(prob, new SolverV2.WorldV2(), sol.apply(prob));
                
                long t3=System.currentTimeMillis();
                System.out.println("Candidat "+sol+"  "+(t3-t2)+" ms");
                System.out.println(""+prob);
                System.out.println(""+t.program());
                System.out.println(" inst "+t.instCost());
                System.out.println(" step "+t.stepCost());                
                
                totInst+=t.instCost();
                totStep+=t.stepCost();
            }

            long t1=System.currentTimeMillis();
            long t=t1-t0;
            
            System.out.println("---------------------------------------");
            System.out.println("Candidat "+sol+"  "+t+" ms");
            System.out.println(" inst "+totInst);
            System.out.println(" step "+totStep);
        }      
        
        checkOracle(toApply, toTest);
        
    }
    
    public static void testCollectionStandardSeveral(){
        System.out.println("++++++++ FULL TEST ++++++++");
        
        ProblemCollectionI toTest=ProblemCollection.officialToSolve();
        List<SolverV2.SolveurV2I> toApply=new ArrayList<>();
        
        toApply.add((e)-> new SimpleStrat.Solve_greedy(e)::apply);
        toApply.add((e)-> new Solver_001(e)::apply);
        
        
        for(SolverV2.SolveurV2I sol : toApply){
            long t0=System.currentTimeMillis();
            
            int totStep=0;
            int totInst=0;
            
            for(String prob : toTest.getProblems()){
                
                Testeur.TestOne t=new Testeur.TestOne(prob, new SolverV2.WorldV2(), sol.apply(prob));
                
                totInst+=t.instCost();
                totStep+=t.stepCost();
            }

            long t1=System.currentTimeMillis();
            long t=t1-t0;
            
            System.out.println("---------------------------------------");
            System.out.println("Candidat "+sol+"  "+t+" ms");
            System.out.println(" inst "+totInst);
            System.out.println(" step "+totStep);
        }        
        
        
        checkOracle(toApply, toTest);         
    }
    
    
    public static void testOneLetter(){
        ProblemCollectionI toTest=ProblemCollection.oneLetterPattern();
        List<SolverV2.SolveurV2I> toApply=new ArrayList<>();
        toApply.add((e)-> new SimpleStrat.Solve_greedy(e)::apply);        
        toApply.add((e)-> new Solver_001(e)::apply);

        testDetail(toTest, toApply);
    }
    
    public static void main(String args[]){
        //testOneLetter();
        
        
        ProblemCollectionI toTest=ProblemCollection.officialToSolve();
        List<SolverV2.SolveurV2I> toApply=new ArrayList<>();
        
        toApply.add((e)-> new SimpleStrat.Solve_greedy(e)::apply);
        toApply.add((e)-> new Solver_001(e)::apply);        
        testDetail(toTest, toApply);
       
       //testCollectionStandardSeveral();        
        
    }
}
