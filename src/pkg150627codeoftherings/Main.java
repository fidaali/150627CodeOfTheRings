/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 Welcome to the first 24 hour optimization challenge.
 Please note that the available 24 hours does not reflect the difficulty of the challenge. Also it does not mean that you will have to code 24 hours in a row.

 It is in fact quite simple to obtain a 100% score. However, we have made it possible for you to submit a solution several times across the next 24 hours, so that you may attempt to improve your code at any moment.

 For this question, you will be asked to output a single line as a solution. Your rank for this challenge will be evaluated by the length of your output, which you will want to minimize.

 The players with the shortest output across all validator test cases at the end of the 24 hours will be the winners.
 The program:
 The aim of this game is to help Bilbo escape a forest by sending him a sequence of instructions that will make him spell out a given sentence using magic stones.

 Your program receives a string of uppercase characters – the magic phrase Bilbo needs to spell out – and must output a sequence of characters, each representing an action for Bilbo to perform.
 These actions will have Bilbo move around in the forest, interacting with the different stones.

 The forest Bilbo is trapped works as follows:
 The forest contains 30 zones.
 Bilbo can move left and right through the zones which are all aligned. He does this when he receives a less-than < or greater-than > sign.
 The last zone is connected to the first zone, effectively creating a looping area.
 Each zone contains a magic stone upon which is inscribed a rune with which Bilbo can interact.

 Runes work as follows:
 Every rune is represented by a letter of the alphabet (A-Z) or an empty space.
 All runes start out as a space.
 Bilbo can change the value of the letter on the rune by rolling back and forth through the possibilities. He does this when he receives a plus + or minus - character.
 The letter after Z is space. The letter after space is A.
 Bilbo can trigger a rune. This will add the displayed letter to the phrase he is spelling out. He does this when he receives a dot . character.
 One rune can be triggered several times.

 YOU WIN IF THE MAGIC PHRASE IS SPELLED OUT CORRECTLY AT THE END OF BILBO'S MOVE SEQUENCE.

 You lose if:
 At the end of Bilbo's move sequence, the wrong message is displayed.
 Bilbo performs 4000 moves or more in the forest.
 You do not supply Bilbo with a valid sequence of actions.
 
 Example:

 If Bilbo needs to spell out the word AB, you could give him the instructions +.+.. He will:
 Make the first rune go from space to A.
 Trigger the A.
 Make rune go from A to B.
 Trigger the B.
 Alternatively, you could also give him the instructions +.>++. to achieve the same result. Experiment with different tactics!
 For expert CodinGamers (don't bother with this until you've really tried the rest): Loops.
 These actions are also available:
 [: If the current rune contains a space, skip all instructions up to the matching closing bracket ], otherwise continue normally.
 ]: If the current rune contains a space, continue normally, otherwise perform the instructions starting from the matching opening bracket [.
 This makes it possible to have Bilbo perform more actions with less characters for your program to output.

 For example, AAAAAAAAAAAAAAAAAAAAAAAAAA (A x26) can be achieved with a simple
 +.......................... as well as with +>-[<.>-].

 Experiment with different techniques, if you have the guts!


 */
package pkg150627codeoftherings;

import contest.GreedyTools;
import contest.OracleWorld;
import contest.ProgRand;
import contest.Solver004_greedySimple;
import contest.SolverInterface;
import contest.Utils;
import org.omg.CORBA.INTERNAL;

/**
 *
 * @author Jahan
 */
public class Main {
    
    public static void exploreProgramation() {
        String[] progs=new String[]{""
            //,"-[>+.<-]" //ABCDEFGHIJKLMNOPQRSTUVWXYZ
           // ,"++++[>++.<-]" //BDFH
            //    ,"+++[>+.-<-]" //H
                //,"-[->+<-]>-."
                //,-[->+<-] M
                //,"-[->+<-]->-<[->.<-]"
                //,"+[>-]>[.>]>.." ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ (31)
                //,"-[->+<-]>[->+>+<<]"
                //,"-[->+>+<<-]>>-<<-------[->.>.<<]" //MLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLML
                //,"++++++++>-[<.>-]-[<.>-]<."// H 53
                //,"++++++++>->++[-<[<.>-]->]" H 52 (HZ)
               // ,"++++++++>-[<.>-]-[<.>-]<.>-----<[->.<]--[->.<]>....."// H 53 V 38
               // ,"--<-[->.<]--<-[->.<]><----------[->.<]>." // 70 Y
               // ,"-->++>+++++>+++++++[-<[-<[-<.>]++>]+++++>]" // 70 Y
               // ,"-->>>+++++++[-<++[-<+++++[-<.>]>]>]"// 70 Y
               // ,"+++++++[->->+<<]>--[->.-<]"
               // ,"-[.-]-." // alphabet 11 x + Z
               // ,"-[->+<-]>--[->-[.-]-.+<]" // alphabet 11 x + Z
              //  ,"-[>.<.-]" not used :'(
              //  ,"---[+>-->-->--<<<]>>--->>->->-[-<+<+>>-]" URULL (setup)
                ,"---[+>-->-->--<<<]>>--->>->->-[-<+<+>>-]<[-<<<<.>.>.>.>]---[+>-->++>---->----<<<<]>>>->[-<<<<.>.>.>.>]" //URUL (L*)
        };  
        
        int nbBoucle = progs.length-1;
        Utils.World w=new Utils.World();
        for( String prog : progs) {
           System.out.println(""+prog);
            try {
                w.reset();
                String res=OracleWorld.interpret(prog, w);
                System.out.println("state |"+w.debug_worldState());
                System.out.println("res |"+res +" "+res.length());

            } catch (Exception e) {
               // System.err.println(""+i+" "+prog+" "+e);
                 e.printStackTrace();
            }

        }            
    }

    public static void exploreRingLeader() {
        //final String longSpell = "THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE";
        final String longSpell = "BABCDEDCBABCDCB";
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("" + e.getStackTrace()[0]);
        }
         //assertEquals("Text", "Text");

        GreedyTools greed = new GreedyTools();
        greed.calcGreedyCost(longSpell);
        int best = greed.calced.sum;
        System.out.println("" + greed.calced.sum);
        ProgRand prand = new ProgRand(28884);

        while (true) {
            greed.w.reset();
            String prog = "" + prand.randProg(30);
            try {

                OracleWorld.interpret(prog, greed.w);
                if (prand.countDiffSpace(greed.w) > 10) {

                    //System.err.println(""+nbBoucle+" "+prog+" -> "+w.debug_worldState()+" (nbInst) "+w.instruct.length());
                    greed.calcGreedyCost(longSpell);

                    int sc = greed.calced.sum + prog.length();

                    if (sc < best) {
                        best = sc;
                        System.out.println("Score " + sc);
                        System.out.println("prog " + prog);
                    }

                }

            } catch (Exception e) {
               // System.err.println(""+i+" "+prog+" "+e);
                // e.printStackTrace();
            }
        }

    }
    
    public static void exploreInitialStateFixed() {
    String[] progs=new String[]{"",
        "-[+<--<<+>---]" // for long spell
            ,"-[+<--<+<+]<" // for short spell
            ,"+<++[[[-]-[<+]]<]" // ^Quality = 29  diff letter : 26
            ,"--[>[->]-[<]>->>-]++" // ^Quality = 30  diff letter : 26
            ,"-[>>+[-<+>>+<]<]" // [ZABCDEFGHIJKLMNOPQRSTUVWXYZ###] 27 (nbInst) 3322
            ,"+[>->-[->]>-]" // [Z#ZR####AACNA##OAQUN##UOWXVM#T] 5 (nbInst) 1571 ^Quality = 13  diff letter : 14
            ,"--[>+[+>]>-]" // || [PS##D#F#ZNW#TLXO#OR#IV#OR#IV#O] 3 (nbInst) 2450 ^Quality = 14  diff letter : 15
            ,"-[[>-<+<]<-<<-]" // || [MBJ#QAH#SAG#Z#FT#GDN#PCIX#EEO#] 13 (nbInst) 2584 ^Quality = 17  diff letter : 20
    };     
        
        
      Utils.World w = new Utils.World();
        System.err.println("" + w.debug_worldState());

        //ProgRand prand=new ProgRand(28884);
        ProgRand prand = new ProgRand(28884 ^ 8388911);

        final int nbProgSz = 30;
        final int maxLetter = 60;

        int nbBoucle = progs.length-1;
        while (nbBoucle >= 0) {
            w.reset();
            String prog = "" + progs[nbBoucle];
            try {

                OracleWorld.interpret(prog, w);
                int quality = prog.length();
                int scoreDiffLetter = prand.countDiffLetters(w);                

                if (true) {
                    

                    if (true) {
                        nbBoucle--;

                        System.err.print("" + nbBoucle + " " + prog + " || " + w.debug_worldState() + " (nbInst) " + w.instruct.length());
                        System.err.println(" ^Quality = " + prog.length() + "  diff letter : " + prand.countDiffLetters(w));

                    }

                }

            } catch (Exception e) {
               // System.err.println(""+i+" "+prog+" "+e);
                // e.printStackTrace();
            }

        }       
        
    }

    public static void exploreInitialState() {

        String allA = "";

        System.out.println("Main");

        Utils.World w = new Utils.World();
        System.err.println("" + w.debug_worldState());

        //ProgRand prand=new ProgRand(28884);
        ProgRand prand = new ProgRand(28884 ^ 8388911);

        final int nbProgSz = 30;
        final int maxLetter = 60;
        int[] bestQuality = new int[maxLetter];

        int nbBoucle = 10000;
        while (nbBoucle > 0) {
            w.reset();
            String prog = "" + prand.randProg(30);
            try {

                OracleWorld.interpret(prog, w);
                int quality = prog.length();
                int scoreDiffLetter = prand.countDiffLetters(w);                

                if (prand.countDiffSpace(w) > 1 && scoreDiffLetter > 10) {
                    

                    if (bestQuality[quality] < scoreDiffLetter) {
                        bestQuality[quality] = scoreDiffLetter;
                        nbBoucle--;

                        System.err.print("" + nbBoucle + " " + prog + " || " + w.debug_worldState() + " (nbInst) " + w.instruct.length());
                        System.err.println(" ^Quality = " + prog.length() + "  diff letter : " + prand.countDiffLetters(w));

                    }

                }

            } catch (Exception e) {
               // System.err.println(""+i+" "+prog+" "+e);
                // e.printStackTrace();
            }

        }

//+>-[<.>-]        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //exploreInitialState();
        //exploreRingLeader();
        //exploreInitialStateFixed();
        
        exploreProgramation();
    }

}
