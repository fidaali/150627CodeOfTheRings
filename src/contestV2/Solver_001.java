/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contestV2;

import java.util.List;

/**
 *
 * @author Jahan
 */
public class Solver_001 implements SolverV2.FunctionV2I {

    final String toEmit;

    public Solver_001(String in) {
        this.toEmit = in;
    }

    @Override
    public SolverV2.Output apply(SolverV2.Output o) {

        if (toEmit.isEmpty()) {
            return o;
        }

                //System.err.println("## "+toEmit);
        Splitter split = new Splitter(toEmit);
        Splitter.RepeatPattern rp = null;
        int maxSz = 15;
        int currSz = 1;

        while (rp == null && currSz < maxSz) {
            rp = split.extractRepeat(currSz);
            if (rp != null ) {
               // System.out.println("Found Pattern" + rp);

                List<Testeur.TestOne> them = Testeur.newListTestOne();
                them.add(new Testeur.TestOne(toEmit, o.w, new Blocks.Sol_repeatPattern(toEmit,rp.pattern.length(),rp.nbRepeat)::apply));
                them.add(new Testeur.TestOne(toEmit, o.w, new SimpleStrat.Solve_greedy(toEmit)::apply));

                return Testeur.applyBest(them, o);
            }

            currSz++;
        }
        maxSz=3;
        currSz = 1;        
        while (rp == null && currSz < maxSz) {
            rp = split.extractRepeatWithInc(currSz);
            if (rp != null ) {
               // System.out.println("Found Pattern" + rp);

                List<Testeur.TestOne> them = Testeur.newListTestOne();
                them.add(new Testeur.TestOne(toEmit, o.w, new Blocks.Sol_repeatPatternInc(toEmit,rp.pattern.length(),rp.nbRepeat)::apply));
                them.add(new Testeur.TestOne(toEmit, o.w, new SimpleStrat.Solve_greedy(toEmit)::apply));

                return Testeur.applyBest(them, o);
            }

            currSz++;
        }        
        
        {
                List<Testeur.TestOne> them = Testeur.newListTestOne();
                final String[] progs=new String[]{""
                    ,"-[+<--<<+>---]" // for long spell
                        ,"-[+<--<+<+]<" // for short spell
                };       
                them.add(new Testeur.TestOne(toEmit, o.w, new SimpleStrat.Solve_greedyWithProg(toEmit,"")::apply));
                for(String p : progs){
                    them.add(new Testeur.TestOne(toEmit, o.w, new SimpleStrat.Solve_greedyWithProg(toEmit,p)::apply));
                }

                return Testeur.applyBest(them, o);
        }

    }

}
