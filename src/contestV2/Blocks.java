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

    public static class Sol_emitAtCursor implements SolverV2.SolverV2I {

        @Override
        public SolverV2.Output apply(SolverV2.Output in) {
            in.programApplied.append(in.w.outRune());
            in.done.append(in.w.currZone().getCurr());
            return in;
        }

    }

    public static class Sol_setAtCursor implements SolverV2.SolverV2I {

        final char c;

        Sol_setAtCursor(char c) {
            this.c = c;
        }

        @Override
        public SolverV2.Output apply(SolverV2.Output in) {
            int cost = in.w.playerCostFor(c);
            while (cost > 0) {
                in.programApplied.append(in.w.decRune());
                cost--;
            }
            while (cost < 0) {
                in.programApplied.append(in.w.incRune());
                cost++;
            }

            return in;
        }

    }
}
