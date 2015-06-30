/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contestV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class SolverV2 {

    public static char incLetter(char d) {
        int c = convToIndex(d);

        c++;
        c = c % NBLETTER;

        return ALLCHAR[c];
    }

    ;
        public static char decLetter(char d) {
        int c = convToIndex(d);

        c--;
        c = (c + NBLETTER) % NBLETTER;
        return ALLCHAR[c];
    }

    public static int incLetter(int c) {
        c++;
        c = c % NBLETTER;

        return c;
    }

    ;
        public static int decLetter(int c) {
        c--;
        c = (c + NBLETTER) % NBLETTER;
        return c;
    }

    public static int normalizeLetter(int c) {
        while (c < 0) {
            c = (c + NBLETTER) % NBLETTER;
        }
        c = c % NBLETTER;

        return c;
    }

    public static int normalizeRuneLoc(int c) {
        while (c < 0) {
            c = (c + NBZONE) % NBZONE;
        }
        c = c % NBZONE;

        return c;
    }

    public static class Output {

        final StringBuilder done = new StringBuilder(512);
        final StringBuilder programApplied = new StringBuilder(512);
        final WorldV2 w = new WorldV2();

        int steps = 0;

        public Output() {
        }

        public Output(WorldV2 w) {
            this.w.copy(w);
        }

        public void loop(String loop) {
            programApplied.append(loop);

            int nbMax = 4000;

            List<Integer> open = new ArrayList<>(4000);
            boolean ignore = false;
            for (int i = 0; i < loop.length(); i++) {
                char it = loop.charAt(i);

                switch (it) {
                    case '.': {
                        if (!ignore) {
                            w.outRune();
                            done.append(w.currZone().getCurr());
                        }
                        steps++;
                    }
                    break;
                    case '<': {
                        if (!ignore) {
                            w.decPlayer();
                        }
                        steps++;
                    }
                    break;
                    case '>': {
                        if (!ignore) {
                            w.incPlayer();
                        }
                        steps++;
                    }
                    break;

                    case '+': {
                        if (!ignore) {
                            w.incRune();
                        }
                        steps++;
                    }
                    break;

                    case '-': {
                        if (!ignore) {
                            w.decRune();
                        }
                        steps++;
                    }
                    break;

                    case '[': {
                        if (!ignore) {

                            open.add(i);
                            if (w.currZone().getCurr() == ' ') {
                                ignore = true;
                            }
                        }
                    }
                    break;

                    case ']': {

                        if (w.currZone().getCurr() == ' ' || ignore) {
                            open.remove(open.size() - 1);
                        } else {
                            i = open.get(open.size() - 1);
                        }

                        ignore = false;
                    }
                    break;

                }

                if (nbMax <= steps) {
                    throw new RuntimeException("Exces limite ");
                }
            }

        }
    }

    public interface FunctionV2I {

        public Output apply(Output in);
    }

    public interface SolveurV2I {

        public FunctionV2I apply(String in);

    }

    public final static int NBLETTER = 27;
    public final static int NBZONE = 30;

    final static char ALLCHAR[] = new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    final static int convToIndex(char it) {
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

    public static class ZStateV2 {

        private int c = 0;

        public void copy(ZStateV2 it) {
            this.c = it.c;
        }

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

            int p = convToIndex(dest);
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

    public static class WorldV2 {

        int playerZone = 0;

        public void reset() {
            playerZone = 0;
            for (int i = 0; i < zone.length; i++) {
                zone[i] = new ZStateV2();
            }
        }

        public void copy(WorldV2 it) {
            playerZone = it.playerZone;
            for (int i = 0; i < zone.length; i++) {
                zone[i].copy(it.zone[i]);
                costMatrix[i] = it.costMatrix[i];
            }
        }

        public String debug_worldState() {
            String res = "[";
            for (int i = 0; i < zone.length; i++) {
                res += zone[i].getCurr();
            }
            res += "]";
            res = res.replace(" ", "#");
            res += " " + playerZone;
            return res;
        }

        public ZStateV2[] zone = new ZStateV2[30];

        {
            for (int i = 0; i < zone.length; i++) {
                zone[i] = new ZStateV2();
            }
        }

        public ZStateV2 currZone() {
            return zone[playerZone];
        }

        public int pureCostFor(int i, char c) {
            return zone[i].cost(c);
        }

        int[] costMatrix = new int[SolverV2.NBZONE];
        boolean[] jumpLeft = new boolean[SolverV2.NBZONE];
        boolean[] jumpRight = new boolean[SolverV2.NBZONE];

        public final void calcCostMatrix() {

            for (int i = 0; i < SolverV2.NBZONE; i++) {
                costMatrix[i] = Integer.MAX_VALUE;
                jumpLeft[i] = false;
                jumpRight[i] = false;
            }

            int gor = playerZone;
            int gol = playerZone;
            int dist = 0;
            costMatrix[playerZone] = dist++;

            int jr = playerZone;
            int jl = playerZone;

            for (int i = 0; i < SolverV2.NBZONE / 2; i++) {
                gor++;
                gol--;
                gor = normalizeRuneLoc(gor);
                gol = normalizeRuneLoc(gol);

                costMatrix[gor] = Math.min(costMatrix[gor], dist);
                costMatrix[gol] = Math.min(costMatrix[gol], dist);

                if ((this.zone[gor].c == 0) && (jr == playerZone)) {
                    jr = gor;
                }
                if ((this.zone[gol].c == 0) && (jl == playerZone)) {
                    jl = gol;
                }

                dist++;
            }
            //if(jr!=playerZone || jl != playerZone){
            //    System.out.println("JUMP ACTIVE "+jr+" "+jl);
            // }

            if (costMatrix[jr] > 3) {
                //System.out.println("JUMP ACTIVE R " + jr);
                gor = jr;
                gol = jr;
                dist = 3;

                for (int i = 0; i < SolverV2.NBZONE / 2; i++) {

                    gor = normalizeRuneLoc(gor);
                    gol = normalizeRuneLoc(gol);

                    if (costMatrix[gor] > dist) {
                        jumpRight[gor] = true;
                    }
                    if (costMatrix[gol] > dist) {
                        jumpRight[gol] = true;
                    }
                    costMatrix[gor] = Math.min(costMatrix[gor], dist);
                    costMatrix[gol] = Math.min(costMatrix[gol], dist);

                    gor++;
                    gol--;
                    dist++;
                }

            }

            if (costMatrix[jl] > 3) {
                //System.out.println("JUMP ACTIVE L " + jl);
                gor = jl;
                gol = jl;
                dist = 3;

                for (int i = 0; i < SolverV2.NBZONE / 2; i++) {

                    gor = normalizeRuneLoc(gor);
                    gol = normalizeRuneLoc(gol);

                    if (costMatrix[gor] > dist) {
                        jumpLeft[gor] = true;
                    }
                    if (costMatrix[gol] > dist) {
                        jumpLeft[gol] = true;
                    }
                    costMatrix[gor] = Math.min(costMatrix[gor], dist);
                    costMatrix[gol] = Math.min(costMatrix[gol], dist);
                    gor++;
                    gol--;
                    dist++;
                }
            }

//            System.out.println("" + debug_worldState());
//            System.out.println("cost " + Arrays.toString(costMatrix));
//            for (int i = 0; i < NBZONE; i++) {
//                System.out.print("|" + playerCostFor(i) + "(" + costMatrix[i] + ")" + jumpLeft[i] + "|" + jumpRight[i]);
//            }
//            System.out.println();

//           for(int i=0;i<NBZONE;i++){                
//            if(Math.abs(playerCostFor(i))!=costMatrix[i]){
//            //System.out.flush();
//            throw new RuntimeException("Diff constatee");
//                }
//            }
            //System.out.println();
        }

        public int playerCostFor(int i) {
            int p = i;
            int c = playerZone;
            if (p == c) {
                return 0;
            }

            // by ++ dist
            final int byPlusF;
            final int byMinusF;

            if (p > c) {
                int byPlus;
                int byMinus;
                byPlus = p - c;
                byMinus = c - p;
                byMinus = normalizeRuneLoc(byMinus);
                byPlus = normalizeRuneLoc(byPlus);

                byPlusF = byPlus;
                byMinusF = byMinus;
            } else { // p<c
                int byPlus;
                int byMinus;
                byMinus = c - p;
                byPlus = p - c;
                byMinus = normalizeRuneLoc(byMinus);
                byPlus = normalizeRuneLoc(byPlus);

                byPlusF = byPlus;
                byMinusF = byMinus;
            }

            if (byMinusF < byPlusF) {
                return -byMinusF;
            }
            return byPlusF;
        }

        public char incPlayer() {
            playerZone++;
            playerZone = playerZone % NBZONE;

            return '>';
        }

        ;
        public char decPlayer() {
            playerZone--;
            playerZone = (playerZone + NBZONE) % NBZONE;

            return '<';
        }

        ;
        
        public char incRune() {
            zone[playerZone].inc();
            return '+';
        }

        public char decRune() {
            zone[playerZone].dec();
            return '-';
        }

        public char outRune() {
            return '.';
        }
    }

}
