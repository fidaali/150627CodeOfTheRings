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
public class TransitionCost implements Comparable<TransitionCost> {

    final String trans;

    private List<Integer> costs = new ArrayList<>(510);
    private int sum = 0;

    public void addCost(int direct) {
        int v = direct;
        costs.add(v);
        sum += v;
    }

    public TransitionCost(String trans) {
        this.trans = trans;
    }
    
    public int getSum(){
        return sum;
    }

    @Override
    public int compareTo(TransitionCost t) {
        return t.sum - this.sum;
    }

    @Override
    public String toString() {
        return "TransitionCost{" + "trans=" + trans + ", sum=" + sum + ", costs=" + costs + '}';
    }

} // Transition Cost    

