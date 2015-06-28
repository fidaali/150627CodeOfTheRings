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

    public static final SolverV2.FunctionV2I emitAtCursor = (SolverV2.Output in) -> {
        in.programApplied.append(in.w.outRune());
        in.done.append(in.w.currZone().getCurr());
        in.steps++;
        return in;
    };
    
    public static final SolverV2.FunctionV2I setAtCursor(char c){
        return new Sol_setAtCursor(c); 
    }
    
    public static final SolverV2.FunctionV2I seGreedy(char c){
        return new Sol_setGreedy(c); 
    }    
    
    private static class Sol_setGreedy implements SolverV2.FunctionV2I {

        final char c;

        Sol_setGreedy(char c) {
            this.c = c;
        }

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            
        int costAt[] = new int[SolverV2.NBZONE];
        int costFor[] = new int[SolverV2.NBZONE];
        int totCost[] = new int[SolverV2.NBZONE];            
        
            for (int z = 0; z < SolverV2.NBZONE; z++) {
                costAt[z] = o.w.pureCostFor(z, c);
                costFor[z] = o.w.playerCostFor(z);
                totCost[z] = Math.abs(costAt[z]) + Math.abs(costFor[z]);
            }

            int theMin = SolverV2.firstMinFor(totCost);      
            
            (new Sol_setCursorTo(theMin)).apply(o); 
            new Sol_setAtCursor(c).apply(o);      

            return o;
        }

    }    

    private static class Sol_setAtCursor implements SolverV2.FunctionV2I {

        final char c;

        Sol_setAtCursor(char c) {
            this.c = c;
        }

        @Override
        public SolverV2.Output apply(SolverV2.Output in) {
            int cost = in.w.pureCostFor(in.w.playerZone, c);
            while (cost > 0) {
                in.programApplied.append(in.w.incRune());
                in.steps++;
                cost--;
            }
            while (cost < 0) {
                in.programApplied.append(in.w.decRune());
                in.steps++;
                cost++;
            }

            return in;
        }

    }
    
    private static class Sol_setCursorTo implements SolverV2.FunctionV2I {

        final int c;

        Sol_setCursorTo(int c) {
            this.c = c;
        }

        @Override
        public SolverV2.Output apply(SolverV2.Output in) {
            int cost = in.w.playerCostFor(c);
            while (cost > 0) {
                in.programApplied.append(in.w.incPlayer());
                in.steps++;
                cost--;
            }
            while (cost < 0) {
                in.programApplied.append(in.w.decPlayer());
                in.steps++;
                cost++;
            }

            return in;
        }

    }    
}
