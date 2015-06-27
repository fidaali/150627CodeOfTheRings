/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class OracleWorld {
    
    
    
    
    public static String interpret(String in){
        Utils.World w=new Utils.World();
        
        int nbMax=4000;
        
        List<Integer> open=new ArrayList<>(4000);
        
        for(int i=0;i<in.length();i++){
            char it=in.charAt(i);
            
            switch(it){
                case '.': {
                    w.outRune();
                } break;
                case '<': {
                    w.decPlayer();
                } break;
                case '>': {
                    w.incPlayer();
                } break;
                    
                case '+': {
                    w.incRune();
                } break;
                    
                case '-': {
                    w.decRune();
                } break;        
                    
                case '[' :{
                    open.add(i);
                }
                
                case ']' :{
                    if(w.currZone().getCurr()==' '){
                        open.remove(open.size()-1);
                    }else{
                        i=open.get(open.size()-1);
                    }
                }
            
            }
        
            nbMax--;
            if(nbMax<=0) throw new RuntimeException("Exces limite ");
        }
        
        
        return w.emits.toString();
    }
    
}
