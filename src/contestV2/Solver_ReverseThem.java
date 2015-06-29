/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Inplace : 13479

With [] for each : 13525
<> each car : 13509
<-> : 15171 ++ 564 caracters

<-> for each one letter exactly : 13488 (--> 3 with only one letter)
1 > 12. 2 <= 12.

++++++++++++++++++++++++++++++++
15 * L 
31 * Z
70 * Y

 */

package contestV2;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class Solver_ReverseThem implements SolverV2.FunctionV2I {

    final String toEmit;

    public Solver_ReverseThem(String in) {
        this.toEmit = in;
    }

    @Override
    public SolverV2.Output apply(SolverV2.Output o) {
        
        HashMap<String,String> solutionMap=new HashMap<>(50);
        solutionMap.put("ZA","-.>+.");
        solutionMap.put("NRMZH","-------------.++++.-----.>-.<-----.");

        if (toEmit.isEmpty()) {
            return o;
        }        
        
        for(int i=0;i<toEmit.length();i++){
            char c=toEmit.charAt(i);
            
            Blocks.setAtCursor(c).apply(o);
            Blocks.emitAtCursor.apply(o);
        }

        return o;

    }

}