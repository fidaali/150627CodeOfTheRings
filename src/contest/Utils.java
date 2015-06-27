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
public class Utils {
    
    final static char ALLCHAR[]=new char[]{' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    final static int POS(char it){
        if(it==' ') return 0;
        return (it-'A')+1;
    }
    
    public static class ZState{
        private int c=0;
        final static int NBLETTER=27;
    
        public void inc(){
            c++; c=c%NBLETTER;        
        };
        public void dec(){
            c--;c=c&255;        
        };
        
        public char getCurr(){
            return ALLCHAR[c];
        }
        
        public int cost(char dest){
            int p=POS(dest);
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
            
            if(byMinus < byPlus) return -byMinus;
            return byPlus;        
        }
    }
    
    public static class World{
        StringBuilder instruct=new StringBuilder(4000);
        StringBuilder emits=new StringBuilder(4000);
        int playerZone=0;
        
        final static int NBZONE=30;
        
        public ZState[] zone=new ZState[30];
        {
            for(int i=0;i<zone.length;i++){
                zone[i]=new ZState();
            }
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
            playerZone++; playerZone=playerZone%30;        
            instruct.append(">");
        };
        public void decPlayer(){
            playerZone--;playerZone=playerZone&255;    
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
