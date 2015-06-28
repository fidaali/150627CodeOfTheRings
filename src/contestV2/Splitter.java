/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contestV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class Splitter {
    
    final String input;

    public Splitter(String input) {
        this.input = input;
    }
    
    public static class RepeatPattern{
        int nbRepeat;
        String pattern;
        
    }
    
    public RepeatPattern extractRepeat(){
        RepeatPattern res=new RepeatPattern();
        
        char first=input.charAt(0);
        char c=first;
        int nb=0;
        while(c==first && nb+1 < input.length()){
            nb++;
            c=input.charAt(nb);
        }
        if(nb>=4){
            res.pattern=""+first;
            res.nbRepeat=nb;
            return res;
        }
        return null;
    }
    
    
    
    public static class SubCount implements Comparable<SubCount>{
        final String s;
        int count=0;

        public SubCount(String s) {
            this.s = s;
        }      

        @Override
        public int compareTo(SubCount t) {
            return -(this.count-t.count);
        }
        
        
    }
    
    Hashtable<String, SubCount> hash=new Hashtable<>(10000);
    List<SubCount> allSubCount=new ArrayList<>(10000);
    
    public void addUpTo(int nbChar){
        int len=input.length();
        for(int i=0;i<len-(nbChar-1);i++){
            String sub=input.substring(i,i+nbChar);
            if(!hash.containsKey(sub)){
                SubCount sc=new SubCount(sub);
                hash.put(sub, sc);
                allSubCount.add(sc);
                //System.out.println("puting "+sub);
            }
            hash.get(sub).count++;
        }
        
        
    }
    
    public void sort(){
        Collections.sort(allSubCount);
    }
    
    public void debug_out(){
        for(SubCount s : allSubCount){
            System.out.println(""+String.format("%3d", s.count)+" "+s.s);
        
        }
    
    }    
    
    
    
}
