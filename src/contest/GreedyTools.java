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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class GreedyTools {

    public final static int NBLETTER = 27;
    public final static int NBZONE = 30;

    final static char ALLCHAR[] = new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    final static int POS(char it) {
        if (it == ' ') {
            return 0;
        }
        return (it - 'A') + 1;
    }

    public static int firstMinFor(int[] tab) {
        int res = -1;
        int currMin = Integer.MAX_VALUE;

        for (int i = 0; i < tab.length; i++) {
            if (currMin > tab[i]) {
                res = i;
                currMin = tab[i];
            }
        }
        return res;
    }

    public static class ZState {

        private int c = 0;

        public void inc() {
            c++;
            c = c % NBLETTER;
        }

        ;
        public void dec() {
            c--;
            c = (c + NBLETTER) % NBLETTER;
        }

        ;
        
        public char getCurr() {

            //System.err.println("getCurr "+c);
            return ALLCHAR[c];
        }

        public int cost(char dest) {
            //System.err.println("cost from "+ALLCHAR[c]+" to "+dest);

            int p = POS(dest);
            if (p == c) {
                return 0;
            }

            // by ++ dist
            final int byPlus;
            final int byMinus;

            if (p > c) {
                byPlus = p - c;
                byMinus = c - p + NBLETTER;
            } else { // p<c
                byMinus = c - p;
                byPlus = c - p + NBLETTER;
            }

            //System.err.println("byMinus "+byMinus);
            //System.err.println("byPlus "+byPlus);
            if (byMinus < byPlus) {
                return -byMinus;
            }
            return byPlus;
        }
    }

    public static class World {

        StringBuilder instruct = new StringBuilder(4000);
        StringBuilder emits = new StringBuilder(4000);
        int playerZone = 0;

        public ZState[] zone = new ZState[30];

        {
            for (int i = 0; i < zone.length; i++) {
                zone[i] = new ZState();
            }
        }

        public ZState currZone() {
            return zone[playerZone];
        }

        public int pureCostFor(int i, char c) {
            return zone[i].cost(c);
        }

        public int playerCostFor(int i) {
            int p = i;
            int c = playerZone;
            if (p == c) {
                return 0;
            }

            // by ++ dist
            final int byPlus;
            final int byMinus;

            if (p > c) {
                byPlus = p - c;
                byMinus = c - p + NBZONE;
            } else { // p<c
                byMinus = c - p;
                byPlus = c - p + NBZONE;
            }

            if (byMinus < byPlus) {
                return -byMinus;
            }
            return byPlus;
        }

        public void incPlayer() {
            playerZone++;
            playerZone = playerZone % NBZONE;
            instruct.append(">");
        }

        ;
        public void decPlayer() {
            playerZone--;
            playerZone = (playerZone + NBZONE) % NBZONE;
            instruct.append("<");
        }

        ;
        
        public void incRune() {
            zone[playerZone].inc();
            instruct.append("+");
        }

        public void decRune() {
            zone[playerZone].dec();
            instruct.append("-");
        }

        public void outRune() {
            instruct.append(".");
            emits.append(ALLCHAR[zone[playerZone].c]);
        }
    }

    public static class TransitionCost implements Comparable<TransitionCost> {

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

        @Override
        public int compareTo(TransitionCost t) {
            return t.sum - this.sum;
        }

        @Override
        public String toString() {
            return "TransitionCost{" + "trans=" + trans + ", sum=" + sum + ", costs=" + costs + '}';
        }

    } // Transition Cost

    public static final class TotalCost {

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
                sum += tc.sum;
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

    HashMap<String, TransitionCost> transCost = null;

    List<TransitionCost> optimized = new ArrayList<>(5000);
    public TotalCost calced = null;

    public TotalCost calcGreedyCost(String s) {
        TotalCost res = new TotalCost();

        String in = " " + s;
        transCost = new HashMap<>(510);

        int len = s.length();

        int costAt[] = new int[Utils.NBZONE];
        int costFor[] = new int[Utils.NBZONE];
        int totCost[] = new int[Utils.NBZONE];

        World w = new World();

        for (int i = 1; i < len; i++) {
            char c = in.charAt(i);

            for (int z = 0; z < Utils.NBZONE; z++) {
                costAt[z] = w.pureCostFor(z, c);
                costFor[z] = w.playerCostFor(z);
                totCost[z] = Math.abs(costAt[z]) + Math.abs(costFor[z]);
            }

            int theMin = Utils.firstMinFor(totCost);
            int minCost = totCost[theMin];

            String tra = in.substring(i - 1, i + 1);
            //System.err.println(""+tra+" "+minCost);
            if (!transCost.containsKey(tra)) {
                transCost.put(tra, new TransitionCost(tra));
            }
            transCost.get(tra).addCost(minCost);

                //System.out.println(""+Arrays.toString(totCost));
            //System.out.println("Min is "+theMin);
            int rund = costFor[theMin];
            int dist = costAt[theMin];
            while (rund < 0) {
                res.through[w.playerZone]++;
                w.decPlayer();

                rund++;
            }
            while (rund > 0) {
                res.through[w.playerZone]++;
                w.incPlayer();
                rund--;
            }
            res.used[w.playerZone]++;            

            if (dist < 0) {
                while (w.currZone().getCurr() != c) {
                    w.decRune();
                }
            } else if (dist > 0) {
                while (w.currZone().getCurr() != c) {
                    w.incRune();
                }
            }

            w.outRune();

        }

        res.addAll(transCost.values());
        calced = res;
        return res;

    }    // GreedyCalc

}
