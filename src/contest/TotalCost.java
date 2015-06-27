/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jahan
 */
    public final class TotalCost {

        int through[] = new int[Utils.NBZONE];
        int used[] = new int[Utils.NBZONE];
        int UsedThrough[] = new int[Utils.NBZONE];

        List<TransitionCost> it = new ArrayList<>(512);
        int sum = 0;

        public void addAll(Collection<TransitionCost> them) {
            it.clear();
            it.addAll(them);
            Collections.sort(it);

            for (TransitionCost tc : it) {
                sum += tc.getSum();
            }
            
            for(int i=0;i<through.length;i++){
                UsedThrough[i]=used[i]-through[i];
            }
        }

        @Override
        public String toString() {
            String res = "";

            for (TransitionCost tc : it) {
                res += "" + tc + "\n";
            }

            res += "Total " + sum+"\n";
            res+="THRO"+Arrays.toString(through)+"\n";
            res+="USED"+Arrays.toString(used)+"\n";
            res+="DIFF"+Arrays.toString(UsedThrough)+"\n";
            return res;
        }
    }
