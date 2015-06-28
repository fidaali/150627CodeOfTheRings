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
    
    public static class Solve_greedyWithProg implements SolverV2.FunctionV2I {
        
        final String toEmit;
        final String patch;

        public Solve_greedyWithProg(String in,String patch) {
            this.toEmit = in;
            this.patch=patch;
        }
        
        

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            o.loop(patch);
            int len = toEmit.length() ;
            for(int i=0;i<len;i++){
                char c = toEmit.charAt(i);
                Blocks.seGreedy(c).apply(o);
                Blocks.emitAtCursor.apply(o);
            }
            return o;
        }
    }    
    
    public static class Solve_greedy implements SolverV2.FunctionV2I {
        
        final String toEmit;

        public Solve_greedy(String in) {
            this.toEmit = in;
        }
        
        

        @Override
        public SolverV2.Output apply(SolverV2.Output o) {
            int len = toEmit.length() ;
            for(int i=0;i<len;i++){
                char c = toEmit.charAt(i);
                Blocks.seGreedy(c).apply(o);
                Blocks.emitAtCursor.apply(o);
            }
            return o;
        }
    }     
    

    public static class Solve_repeatOneLetter implements SolverV2.FunctionV2I {

            final String toEmit;

            public Solve_repeatOneLetter(String in) {
                this.toEmit = in;
            }



            @Override
            public SolverV2.Output apply(SolverV2.Output o) {
                Testeur.TestOne test=new Testeur.TestOne(toEmit, o.w,Blocks._repeatOneLetter(toEmit)::apply);
                Testeur.TestOne test2=new Testeur.TestOne(toEmit, o.w,new Solve_greedy(toEmit)::apply);
                
                if(test.instCost()<test2.instCost()){
                    //System.out.println(""+test.program()+" SUCCESS"+" vs "+test2.program());
                    //System.out.println("done "+test.done()+" left "+test.leftOver());
                    o.loop(test.program());     
                    return new Solve_repeatOneLetter(test.leftOver()).apply(o);
                }else{
                    o.programApplied.append(test2.program());
                    o.w.copy(test2.res.w);
                }
                return o;
            }

        }        
    
    
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
