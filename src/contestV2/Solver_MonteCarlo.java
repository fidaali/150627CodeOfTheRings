/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2;

import contest.Solver004_greedySimple;
import java.util.Random;

/**
 *
 * @author Jahan
 */
public class Solver_MonteCarlo  implements SolverV2.FunctionV2I{
    
    final String toEmit;    
    final Random rand;    
    class  RandomStrat implements SolverV2.FunctionV2I{        
        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            int len = toEmit.length() ;
            for(int i=1;i<len;i++){
                char c = toEmit.charAt(i);
                int ri=rand.nextInt()&0xFFFFFF;
                ri=SolverV2.normalizeRuneLoc(ri);
                Blocks.setCursorTo(ri).apply(o);          
                Blocks.setAtCursor(c).apply(o);
                Blocks.emitAtCursor.apply(o);
            }
            return o;
        }           
        
    }
    

        public Solver_MonteCarlo(String in) {
            rand=new Random(457457);
            this.toEmit = in;
        }
        
        

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            SolverV2.Output localContext=new SolverV2.Output();             
            localContext.w.copy(o.w);
            
            
            
            return o;
        }    
    
}
