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
    
    public static final SolverV2.FunctionV2I _repeatOneLetter(String c){
        return new Sol_repeatOneLetter(c); 
    }    
    
    public static final SolverV2.FunctionV2I setAtCursor(char c){
        return new Sol_setAtCursor(c); 
    }
    public static final SolverV2.FunctionV2I setCursorTo(int c){
        //System.err.println("whant to get to "+c);
        
        if(c<0){ c+=SolverV2.NBZONE;}
        //System.err.println("whant to get to "+c);
        c=c%SolverV2.NBZONE;
        //System.err.println(" really whant to get to "+c);
        
        return new Sol_setCursorTo(c); 
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
            //System.err.println("going to this "+c);            
        }

        @Override
        public SolverV2.Output apply(SolverV2.Output in) {
            int cost = in.w.playerCostFor(c);
            //System.err.println("going from "+in.w.playerZone+" to "+c+" cost is "+cost);
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
    
    private static class Sol_repeatOneLetter implements SolverV2.FunctionV2I {
        
        final String toEmit;

        public Sol_repeatOneLetter(String in) {
            this.toEmit = in;
        }
                

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            int len = toEmit.length() ;
            char c = toEmit.charAt(0);
            Blocks.seGreedy(c).apply(o);
            if(len>=SolverV2.NBLETTER) len=SolverV2.NBLETTER-1;
            
            Blocks.setCursorTo(o.w.playerZone-1).apply(o);
            Blocks.setAtCursor(SolverV2.ALLCHAR[len]).apply(o);
            o.loop("[->.<]");
            
            return o;
        }
    }      
}
