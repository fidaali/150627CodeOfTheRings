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
        Splitter.RepeatPattern rp = split.extractRepeat(1);
        int maxSz = 5;
        int currSz = 2;

        while (rp == null && currSz < maxSz) {
            rp = split.extractRepeat(1);
            if (rp != null) {
                System.err.println("" + rp);
                System.exit(1);

                List<Testeur.TestOne> them = Testeur.newListTestOne();
                them.add(new Testeur.TestOne(toEmit, o.w, Blocks._repeatOneLetter(toEmit)::apply));
                them.add(new Testeur.TestOne(toEmit, o.w, new SimpleStrat.Solve_greedy(toEmit)::apply));

                return Testeur.applyBest(them, o);
            }

            currSz++;
        }
        {
            Testeur.TestOne test1 = new Testeur.TestOne(toEmit, o.w, new SimpleStrat.Solve_greedy(toEmit)::apply);

            o.programApplied.append(test1.program());
            o.w.copy(test1.res.w);
            return o;
        }

    }

}
