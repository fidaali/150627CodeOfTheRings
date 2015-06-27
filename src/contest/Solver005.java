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
    
    Utils.World w=new Utils.World();

    String in=null;
    int len=-1;
    
    SuffixTool.CompactSuffixTree suffixTree =null;
    
    @Override
    public void input(String in) {
        this.in=in;
        len=in.length();
        
        suffixTree = new SuffixTool.CompactSuffixTree(new SuffixTool.SimpleSuffixTree(in));        
    }

    @Override
    public String output() {
        
        int costAt[]=new int[Utils.NBZONE];
        int costFor[]=new int[Utils.NBZONE];
        int totCost[]=new int[Utils.NBZONE];
        
        for(int i =0;i<len;i++){
            char c=in.charAt(i);
            
            for(int z=0;z<Utils.NBZONE;z++){
                costAt[z]=w.pureCostFor(z, c);      
                costFor[z]=w.playerCostFor(z);
                totCost[z]=Math.abs(costAt[z])+Math.abs(costFor[z]);
            }

            int theMin=Utils.firstMinFor(totCost);
            
            //System.out.println(""+suffixTree.root);
            
            //System.out.println(""+Arrays.toString(totCost));
            //System.out.println("Min is "+theMin);
            
            int rund=costFor[theMin];
            int dist=costAt[theMin];
            while(rund<0){
                w.decPlayer();
                rund++;
            }
            while(rund>0){
                w.incPlayer();
                rund--;
            }
            
            if(dist<0){
                while(w.currZone().getCurr()!=c){
                    w.decRune();
                }                
            }else if(dist >0){
                while(w.currZone().getCurr()!=c){
                    w.incRune();
                }                  
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
