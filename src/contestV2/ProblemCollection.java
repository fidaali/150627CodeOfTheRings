/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contestV2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class ProblemCollection {

    public interface ProblemCollectionI {

        List<String> getProblems();
    }

    public static final ProblemCollectionI generateRepeatLetter(char letterMin, char letterMax, int min, int max) {
        final List<String> res = new ArrayList<>();

        for (int sz = min; sz <= max; sz++) {
            for (char c = letterMin; c <= letterMax; c++) {
                String it = "";
                for (int i = 0; i < sz; i++) {
                    it += c;
                }
                res.add(it);
            }

        }

        return () -> res;
    }
    
    public static final ProblemCollectionI symetrical(ProblemCollectionI in){
        final List<String> res = new ArrayList<>();
        
        for(String s : in.getProblems()){
            String r="";
            
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                int v=SolverV2.convToIndex(c);
                v=-v;
                char x=SolverV2.ALLCHAR[SolverV2.normalizeLetter(v)];
                r+=x;
            }
        
            res.add(r);
        }
        return ()->res;
    }

    public static final ProblemCollectionI officialToSolve() {
        final List<String> res = new ArrayList<>();

        res.add("AZ");
        res.add("MINAS");
        res.add("UMNE TALMAR RAHTAINE NIXENEN UMIR");
        res.add("OOOOOOOOOOOOOOO");
        res.add("BABCDEDCBABCDCB");
        res.add("ZAZYA YAZ");
        res.add("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        res.add("NONONONONONONONONONONONONONONONONONONONO");
        res.add("GUZ MUG ZOG GUMMOG ZUMGUM ZUM MOZMOZ MOG ZOGMOG GUZMUGGUM");
        res.add("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        res.add("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        res.add("GAAVOOOLLUGAAVOOOLLUGAAVOOOLLUGAAVOOOLLUGAAVOOOLLUGAAVOOOLLUGAAVOOOLLUGAAVOOOLLU");
        res.add("O OROFARNE LASSEMISTA CARNIMIRIE O ROWAN FAIR UPON YOUR HAIR HOW WHITE THE BLOSSOM LAY");
        res.add("ALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG BALROG B");
        res.add("OYLO Y OOOYYY LLLYOOYY O YO YLOO O OLY YL OY L YY L YOO LYL YYYOOYLOL L Y O YYYLLOY O L YYYOOYLOL YOLOLOY");
        res.add("TUVWXYZ ABCDEFGHIJ");
        res.add("ABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZAABCDEFGHIJKLMNOPQRSTUVWXYZA");
        res.add("OROZOLOKOTONOFOGOMOJOHOFOTOLOPO ODOYOWOAOZO OPOJOTO OROXOVOXO OC");
        res.add(" A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
        res.add("FIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFO FUM FUM FUM FUM FUM FUM FUM FUM FUM FUM FUM FUM FUM FUM FUM");
        res.add("GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY GY HIJIHIJIJIJIHIHIHIJIHIJIHIJIJIJIHHHIJIJHIHH");
        res.add("MELLON MORIAMELLON MORIAMORIAMORIAMELLON MELLON MELLON MORIAMORIAMELLON MELLON MORIA");
        res.add("ZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZACEGIKMOQSUWY BDFHJLNPRTVXZACEGIKMOQSUWY BDFHJLNPRTVXZA");
        res.add("THREE RINGS FOR THE ELVEN KINGS UNDER THE SKY SEVEN FOR THE DWARF LORDS IN THEIR HALLS OF STONE NINE FOR MORTAL MEN DOOMED TO DIE ONE FOR THE DARK LORD ON HIS DARK THRONEIN THE LAND OF MORDOR WHERE THE SHADOWS LIE ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM IN THE LAND OF MORDOR WHERE THE SHADOWS LIE");

        return () -> res;
    }

}
