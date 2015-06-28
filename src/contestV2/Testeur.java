/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2;

/**
 *
 * @author Jahan
 */
public class Testeur {
    
    public static class TestOne{
        public final String toSolve;    
        public final SolverV2.Output res;
        final SolverV2.SolverV2I to;

        public TestOne(String toSolve, SolverV2.WorldV2 w,SolverV2.SolverV2I to) {
            this.toSolve = toSolve;
            this.res = new SolverV2.Output(w);
            this.to=to;
            
            to.apply(res);
        }
        
        public String leftOver(){
            String d=done();
            if(!toSolve.startsWith(d)) throw new RuntimeException("Emit differe de demande !");
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
