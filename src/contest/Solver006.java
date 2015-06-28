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
public class Solver006 implements SolverInterface {

    String in = null;
    int len = -1;

    String[] progs = new String[]{"",};

    GreedyTools greed = new GreedyTools();

    public String genOneLetterRepeatProg(char l, int nb) {
        String res = "";

        res += putLetterOnEmpty(l);
        res += "<";

        int putLet = nb % (Utils.NBLETTER - 1);
        int rest = nb - putLet;

        if (putLet > 0) {
            res += putLetterOnEmpty(Utils.ALLCHAR[putLet]);
        }
        
        res+="[>.<-]";

        while (rest > 0) {
            nb = rest;

            putLet = nb % (Utils.NBLETTER - 1);
            rest = nb - putLet;

            if (putLet > 0) {
                res += putLetterOnEmpty(Utils.ALLCHAR[putLet]);
            }
        }

        return res;

    }

    public String putLetterOnEmpty(char lettre) {
        Utils.ZState zs = new Utils.ZState();
        int cost = zs.cost(lettre);
        String res = "";

        while (cost < 0) {
            res += "-";
            cost++;
        }
        while (cost > 0) {
            res += "+";
            cost--;
        }
        return res;
    }

    public boolean applicable() {

        int nbOne = isOneLetter();
        if (nbOne > 0) {
            char letter = in.charAt(0);
            System.out.println("detected single letter " + letter + " " + nbOne + "  time");
            out = genOneLetterRepeatProg(letter, nbOne);
            return true;

        }

        return false;

    }

    String out = "";

    private int isOneLetter() {
        char it = in.charAt(0);
        int count = 1;
        for (int i = 1; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c != it) {
                return -1;
            }

            count++;
        }
        return count;
    }

    @Override
    public void input(String in) {
        this.in = in;
        len = in.length();
    }

    @Override
    public String output() {

        return out;

    }

    public String toString() {
        String res = "NO DATA";

        return res;
    }

}
