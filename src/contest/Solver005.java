/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contest;

/**
 *
 * @author Jahan
 */
public class Solver005 implements SolverInterface{

    String in=null;
    int len=-1;
    
    String[] progs=new String[]{"","-[+<--<<+>---><]"};
    
    @Override
    public void input(String in) {
        this.in=in;
        len=in.length();    
    }

    @Override
    public String output() {
                
        GreedyTools greed=new GreedyTools();
        greed.calcGreedyCost(in);
        int best=        greed.calced.sum;
        int bestProgInt=0;
        //System.out.println("" + greed.calced.sum);
        ProgRand prand=new ProgRand(28884);        
        
        for(int i=1;i<progs.length;i++){
            greed.w.reset();            
             String prog=""+progs[i];
            try{               
                OracleWorld.interpret(prog, greed.w);      
                greed.w.clearInstruction();
                    //System.err.println(""+nbBoucle+" "+prog+" -> "+w.debug_worldState()+" (nbInst) "+w.instruct.length());
                    greed.calcGreedyCost(in);                    
                    int sc=greed.calced.sum+prog.length();                    
                    if(sc<best){
                        bestProgInt=i;
                        best=sc;
                        //System.out.println("Score " + sc); 
                        //System.out.println("prog " + prog); 
                    }                                
            }catch(Exception e){
               // System.err.println(""+i+" "+prog+" "+e);
               // e.printStackTrace();
            }            
        }        
        {
           greed.w.reset();            
             String prog=""+progs[bestProgInt];
            try{               
                OracleWorld.interpret(prog, greed.w);      
                greed.w.clearInstruction();
                    //System.err.println(""+nbBoucle+" "+prog+" -> "+w.debug_worldState()+" (nbInst) "+w.instruct.length());
                    greed.calcGreedyCost(in);                                                                
            }catch(Exception e){
               // System.err.println(""+i+" "+prog+" "+e);
               // e.printStackTrace();
            }                        
        }
        
        
        return progs[bestProgInt]+greed.w.instruct.toString();
    }
    
    public String toString(){
        String res="NO DATA";
        
        return res;
    }
    
}
