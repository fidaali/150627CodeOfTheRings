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
    
    public static class ZState{
        private int c=0;
    
        public void inc(){
            c++; c=c%27;        
        };
        public void dec(){
            c--;c=c&255;        
        };
        
        public char getCurr(){
            return ALLCHAR[c];
        }
    }
    
    
    
    
}
