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
public class Blocks {

    public static final SolverV2.SolverV2I emitAtCursor = (SolverV2.Output in) -> {
        in.programApplied.append(in.w.outRune());
        in.done.append(in.w.currZone().getCurr());
        in.steps++;
        return in;
    };
    
    public static final SolverV2.SolverV2I setAtCursor(char c){
        return new Sol_setAtCursor(c); 
    }

    private static class Sol_setAtCursor implements SolverV2.SolverV2I {

        final char c;

        Sol_setAtCursor(char c) {
            this.c = c;
        }

        @Override
        public SolverV2.Output apply(SolverV2.Output in) {
            int cost = in.w.playerCostFor(c);
            while (cost > 0) {
                in.programApplied.append(in.w.decRune());
                in.steps++;
                cost--;
            }
            while (cost < 0) {
                in.programApplied.append(in.w.incRune());
                in.steps++;
                cost++;
            }

            return in;
        }

    }
}