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
    
    
    
    
    public static String interpret(String in,Utils.World w){
        
        int nbMax=4000;
        
        List<Integer> open=new ArrayList<>(4000);
        
        boolean ignore=false;
        
        for(int i=0;i<in.length();i++){
            char it=in.charAt(i);
            
            switch(it){
                case '.': {
                    if(!ignore) w.outRune();
                } break;
                case '<': {
                    if(!ignore) w.decPlayer();
                } break;
                case '>': {
                    if(!ignore) w.incPlayer();
                } break;
                    
                case '+': {
                    if(!ignore) w.incRune();
                } break;
                    
                case '-': {
                    if(!ignore) w.decRune();
                } break;        
                    
                case '[' :{
                    open.add(i);
                    if(w.currZone().getCurr()==' '){
                        ignore=true;
                    }
                } break;
                
                case ']' :{

                    
                    if(w.currZone().getCurr()==' ' || ignore){
                        open.remove(open.size()-1);
                    }else{
                        i=open.get(open.size()-1);
                    }
                    
                    ignore=false;                    
                } break;
            
            }
        
            nbMax--;
            if(nbMax<=0) throw new RuntimeException("Exces limite ");
        }
        
        
        return w.emits.toString();
    }
    
}
