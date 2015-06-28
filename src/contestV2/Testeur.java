/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class Testeur {
    
    public static List<TestOne> newListTestOne(){
        return new ArrayList<>(20);
    }
    
    public static SolverV2.Output applyBest(List<TestOne> all,SolverV2.Output o){
        int[] ic=new int[all.size()];
        
        for(int i=0;i<ic.length;i++){
            System.out.println("compare "+all.get(i).program()+" "+all.get(i).instCost());            
            ic[i]=all.get(i).instCost();
        }
        
        int ind=SolverV2.firstMinFor(ic);
        
        o.loop(all.get(ind).program());     
        return new Solver_001(all.get(ind).leftOver()).apply(o);        
    }
    
    public static class TestOne{
        public final String toSolve;    
        public final SolverV2.Output res;
        final SolverV2.FunctionV2I to;

        public TestOne(String toSolve, SolverV2.WorldV2 w,SolverV2.FunctionV2I to) {
            this.toSolve = toSolve;
            this.res = new SolverV2.Output(w);
            this.to=to;
            
            to.apply(res);
        }
        
        public String leftOver(){
            String d=done();
            if(!toSolve.startsWith(d)) throw new RuntimeException("Emit differe de demande !"+" emis = "+d+" demande "+toSolve);
            return toSolve.substring(d.length());
        }
        
        public String done(){
            return res.done.toString();
        }
        
        public int stepCost(){
            return res.steps;
        }
        
        public int instCost(){
            return res.programApplied.length();
        }
        
        public String program(){
            return res.programApplied.toString();
        }
        
        
        
        
    }
    
}
