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
public class Solver002 implements SolverInterface{
    
    Utils.World w=new Utils.World();

    String in=null;
    int len=-1;
    @Override
    public void input(String in) {
        this.in=in;
        len=in.length();
    }

    @Override
    public String output() {
        
        for(int i =0;i<len;i++){
            char c=in.charAt(i);
            
            while(w.zone[0].getCurr()!=c){
                w.incRune();
            }
            w.outRune();
        
        }        
        
        return w.instruct.toString();
    }
    
    public String toString(){
        String res=w.instruct+"\n";
        res+=""+w.emits+"\n";
        res+="TOTAL = "+w.instruct.length();
        
        return res;
    }
    
}
