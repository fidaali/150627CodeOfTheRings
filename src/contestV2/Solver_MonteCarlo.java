/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2;

import java.util.Random;

/**
 *
 * @author Jahan
 */
public class Solver_MonteCarlo  implements SolverV2.FunctionV2I{
    
    final String toEmit;    
    final Random rand;       

        public Solver_MonteCarlo(String in) {
            rand=new Random(457457);
            this.toEmit = in;
        }
        
        

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            for(int i=0;i<toEmit.length();i++){
                new Blocks.Sol_recurGreedy(toEmit, i,4).apply(o);
            
            }
            
            
            
            return o;
        }    
    
}
