/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2.tests;

import contestV2.ProblemCollection;
import contestV2.ProblemCollection.ProblemCollectionI;
import contestV2.SimpleStrat;
import contestV2.SolverV2;
import contestV2.Testeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class TestPerfs {
    public static void main(String args[]){
        ProblemCollectionI toTest=ProblemCollection.officialToSolve();
        List<SolverV2.SolveurV2I> toApply=new ArrayList<>();
        toApply.add((e)-> new SimpleStrat.Solve_inplace(e)::apply);
        
        
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
            
            System.out.println("Candidat "+sol+"  "+t+" ms");
            System.out.println(" inst "+totInst);
            System.out.println(" step "+totStep);
        }
        
    }
}
