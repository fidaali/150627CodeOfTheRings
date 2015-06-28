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
public class SimpleStrat {
    
    public static class Solve_inplace implements SolverV2.FunctionV2I {
        
        final String toEmit;

        public Solve_inplace(String in) {
            this.toEmit = in;
        }
        
        

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            int len = toEmit.length() ;
            for(int i=0;i<len;i++){
                char c = toEmit.charAt(i);
                Blocks.setAtCursor(c).apply(o);
                Blocks.emitAtCursor.apply(o);
            }
            return o;
        }

    }    
    
}
