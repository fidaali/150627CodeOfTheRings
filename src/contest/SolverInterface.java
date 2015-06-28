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
public interface SolverInterface {
    
    public void input(String in);
    public String output();
    public String leftOver();
    public void setWorldState(Utils.World w);
    
}
