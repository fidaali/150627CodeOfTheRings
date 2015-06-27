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
public class Solver001 implements SolverInterface {
    
    String in=null;
    int len=-1;
    
    Utils.ZState z=new Utils.ZState();

    @Override
    public void input(String in) {
        this.in=in;
        len=in.length();
    }

    @Override
    public String output() {
        StringBuilder res=new StringBuilder(4000);
        
        for(int i =0;i<len;i++){
            char c=in.charAt(i);
            
            while(z.getCurr()!=c){
                res.append("+");
                z.inc();
            }
            
            res.append(".");
        
        }
        
        return res.toString();
    }
    
   
    
}
