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

/**
 *
 * @author Jahan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main");
    }
    
}
