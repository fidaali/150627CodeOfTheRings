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
public class SolverV2 {
    
    public interface SolverV2I{
        public void input(String in,WorldV2 w);     
        public String programProposal();
    }
    
    
    
    public final static int NBLETTER=27;        
    public final static int NBZONE=30;    
    
    final static char ALLCHAR[]=new char[]{' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    final static int convToIndex(char it){
        if(it==' ') return 0;
        return (it-'A')+1;
    }
    
    public static int firstMinFor(int[] tab){
        int res=-1;
        int currMin=Integer.MAX_VALUE;
        
        for(int i=0;i<tab.length;i++){
            if(currMin>tab[i]){
                res=i;
                currMin=tab[i];
            }
        }
        return res;
    }
    
    public static class ZStateV2{
        private int c=0;
        
        public void copy(ZStateV2 it){
            this.c=it.c;
        }
    
        public void inc(){
            c++; c=c%NBLETTER;        
        };
        public void dec(){
            c--;c=(c+NBLETTER)%NBLETTER;        
        };
        
        public char getCurr(){
            
            //System.err.println("getCurr "+c);
            return ALLCHAR[c];
        }
        
        public int cost(char dest){
            //System.err.println("cost from "+ALLCHAR[c]+" to "+dest);
            
            int p=convToIndex(dest);
            if(p==c) return 0;
            
            // by ++ dist
            final int byPlus;
            final int byMinus;
            
            if(p>c){
                byPlus=p-c;
                byMinus=c-p+NBLETTER;
            }
            else{ // p<c
                byMinus=c-p;
                byPlus=c-p+NBLETTER;
            }
            
            //System.err.println("byMinus "+byMinus);
            //System.err.println("byPlus "+byPlus);
            
            if(byMinus < byPlus) return -byMinus;
            return byPlus;        
        }
    }
    
    public static class WorldV2{
        public StringBuilder instruct=new StringBuilder(4000);
        StringBuilder emits=new StringBuilder(4000);
        int playerZone=0;
        
        public void clearInstruction(){
            instruct=new StringBuilder(4000);
            emits=new StringBuilder(4000);            
        }
        
        public void reset(){
            playerZone=0;
            instruct=new StringBuilder(4000);
            emits=new StringBuilder(4000);
            
            for(int i=0;i<zone.length;i++){
                zone[i]=new ZStateV2();
            }            
        }
        
        public void copy(WorldV2 it){
            playerZone=it.playerZone;
            for(int i=0;i<zone.length;i++){
                zone[i].copy(it.zone[i]);
            }              
        }
        
        public String debug_worldState(){
            String res="[";
            for(int i=0;i<zone.length;i++){
                res+=zone[i].getCurr();
            }
            res+="]";
            res=res.replace(" ", "#");
            res+=" "+playerZone;
            return res;
        }
        
        public ZStateV2[] zone=new ZStateV2[30];
        {
            for(int i=0;i<zone.length;i++){
                zone[i]=new ZStateV2();
            }
        }
        
        public ZStateV2 currZone(){
            return zone[playerZone];
        }
    
        public int pureCostFor(int i,char c){
            return zone[i].cost(c);
        }
        
        public int playerCostFor(int i){
            int p=i;
            int c=playerZone;
            if(p==c) return 0;
            
            // by ++ dist
            final int byPlus;
            final int byMinus;
            
            if(p>c){
                byPlus=p-c;
                byMinus=c-p+NBZONE;
            }
            else{ // p<c
                byMinus=c-p;
                byPlus=c-p+NBZONE;
            }
            
            if(byMinus < byPlus) return -byMinus;
            return byPlus;        
        }        
        
        public void incPlayer(){
            playerZone++; playerZone=playerZone%NBZONE;        
            instruct.append(">");
        };
        public void decPlayer(){
            playerZone--;playerZone=(playerZone+NBZONE)%NBZONE;    
            instruct.append("<");
        };
        
        public void incRune(){
            zone[playerZone].inc();
            instruct.append("+");
        }
        
        public void decRune(){
            zone[playerZone].dec();
            instruct.append("-");            
        }
        
        public void outRune(){
            instruct.append(".");
            emits.append(ALLCHAR[zone[playerZone].c]);
        }
    }
    
        
}
