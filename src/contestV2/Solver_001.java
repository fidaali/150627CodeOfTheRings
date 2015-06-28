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
public class Solver_001 implements SolverV2.FunctionV2I {

            final String toEmit;

            public Solver_001(String in) {
                this.toEmit = in;
            }



            @Override
            public SolverV2.Output apply(SolverV2.Output o) {
                
                if(toEmit.isEmpty()) return o;
                
                //System.err.println("## "+toEmit);
                
                Splitter split=new Splitter(toEmit);
                Splitter.RepeatPattern rp=split.extractRepeat();
                if(rp!=null){
                    Testeur.TestOne test=new Testeur.TestOne(toEmit, o.w,Blocks._repeatOneLetter(toEmit)::apply);     
                    Testeur.TestOne test2=new Testeur.TestOne(toEmit, o.w,new SimpleStrat.Solve_greedy(toEmit)::apply);

                    if(test.instCost()<test2.instCost()){
                        //System.out.println(""+test.program()+" SUCCESS"+" vs "+test2.program());
                        //System.out.println("done "+test.done()+" left "+test.leftOver());
                        o.loop(test.program());     
                        return new Solver_001(test.leftOver()).apply(o);
                    }else{
                        o.programApplied.append(test2.program());
                        o.w.copy(test2.res.w);
                    }
                    return o;                    
                }else{
                    Testeur.TestOne test2=new Testeur.TestOne(toEmit, o.w,new SimpleStrat.Solve_greedy(toEmit)::apply);
                        o.programApplied.append(test2.program());
                        o.w.copy(test2.res.w);
                        return o;
                }
                


            }

        }        