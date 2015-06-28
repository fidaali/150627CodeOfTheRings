/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contest;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Jahan
 */
public class ProgRand {
    
    final int seed;
    final Random rand;

    public ProgRand(int seed) {
        this.seed = seed;
        rand=new Random(seed);
    }
    
    char[] progPassive=new char[]{'<','>','-','+','<','>','-','+','[',']'};
    char[] progEmit=new char[]{'<','>','-','+','.'};
    
    
    public int countDiffSpace(Utils.World w){
        int res=0;
        for(int i=0;i<w.zone.length;i++){
            if(w.zone[i].getCurr()!=' '){
                res++;
            }
        }
        return res;
    
    }
    
    public int countDiffLetters(Utils.World w){
        HashSet<Character> it=new HashSet<>(512);
        int res=0;
        
        for(int i=0;i<w.zone.length;i++){
            Character cc=w.zone[i].getCurr();
            if(!it.contains(cc)){
                it.add(cc);
                res++;
            }
        }        
        
        return res;
    }
    
    public String randProg(int maxSz){
        String res="";
        int sz=0;
        while(sz==0)
            sz=(rand.nextInt()&0xFFFF  )%(maxSz+1);
        
        int open=0;
        for(int i=0;i<sz;i++){
            int cp=rand.nextInt()&0xFFFF;
            cp=cp%progPassive.length;
            
            char cpp=progPassive[cp];
            if(cpp=='[') open++;
            if(cpp==']'){
                if(open<=0) continue;
                open--;
            }
            
            res+=progPassive[cp];
        }
        
        for(int i=0;i<open;i++){
            res+="]";
        }
        
        return res;
    }
    
    
}
