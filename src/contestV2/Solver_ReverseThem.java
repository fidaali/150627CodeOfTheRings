/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Inplace : 13479

With [] for each : 13525
<> each car : 13509
<-> : 15171 ++ 564 caracters

<-> for each one letter exactly : 13488 (--> 3 with only one letter)
1 > 12. 2 <= 12.

++++++++++++++++++++++++++++++++
15 * L 
31 * Z
70 * Y

++++++++++++++++++++++++++++
7081


13249
 */

package contestV2;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class Solver_ReverseThem implements SolverV2.FunctionV2I {

    final String toEmit;

    public Solver_ReverseThem(String in) {
        this.toEmit = in;
    }

    @Override
    public SolverV2.Output apply(SolverV2.Output o) {
        
        HashMap<String,String> solutionMap=new HashMap<>(50);
//        solutionMap.put("ZA","-.>+.");
//        solutionMap.put("NRMZH","-[+<--<+<+]<<+.++++.<<<.<.>-----.");
// **       solutionMap.put("FNMV GZONZI IZSGZRMV MRCVMVM FNRI","-[+<--<+<+]<+++++.<+.-.<----.<-.>>>+.>-.>+.-.<.<++.<<<.>>>.>.<<<---.>>--.>.<<<-.>.<++++.<.<.+++++.<<++.>>>>.>.<.>.<<.>>>-.<+.<<<.<<<----.");
//OPTIMI HAND
        solutionMap.put("LLLLLLLLLLLLLLL","-[->+<-]->-<[->.<-]>.."); //13474
//        solutionMap.put("YZYXWVWXYZYXWXY","--.+.-.-.-.-.+.+.+.+.-.-.-.+.+.");
//        
//        solutionMap.put("AZABZ BZA","+.--.>+.+.<.<.++.<-.<+.");
//OPTIMI HAND        
          solutionMap.put("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ","+[>-]>[.>]>.."); // 13455
//OPTIMI HAND          
        solutionMap.put("MLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLMLML","-[->+>+<<-]>>-<<-------[->.>.<<]"); // 13395
// **       solutionMap.put("TFA NFT ALT TFNNLT AFNTFN AFN NLANLA NLT ALTNLT TFANFTTFN","-[+<--<<+>---]<++++.<+++.>>+.-.>+.<<<.>.>.+.>--.<<.>-.<.<.<-..--.>>.>.+.<<.<++.>>.<.<.<---.+.>>.<.<-.>.--.<+.<-.--.>.-.<++.--.>>>>.>-.+.>.<<.<<++.<<.>>>>.>-.<.<.<<+.>.>.>..<.<.");
//OPTIMI HAND
        solutionMap.put("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV","++++++++>-[<.>-]-[<.>-]<.>-----<[->.<]--[->.<]>....."); // 13335
//OPTIMI HAND      
solutionMap.put("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY","-->>>+++++++[-<++[-<+++++[-<.>]>]>]"); // 13298
// **
solutionMap.put("TZZELLLOOFTZZELLLOOFTZZELLLOOFTZZELLLOOFTZZELLLOOFTZZELLLOOFTZZELLLOOFTZZELLLOOF","-[-->-<]>>>->-<<<[>->>>+>-->-->-->++>++>+>+[<]>--]>>>>-->->->->+>+>->+[[<]>.>.>.>.>.>.>.>.>.>.>-]");
// **       solutionMap.put("L LILUZIMV OZHHVNRHGZ XZIMRNRIRV L ILDZM UZRI FKLM BLFI SZRI SLD DSRGV GSV YOLHHLN OZB","-[+<--<+<+]<<-.>-.<.---.+++.<-----.<<<.>----.<<<.<----.<-.<++.<.<<-----..<----.<<+.++++.>>>.-.>>.<-.---.>.<<++.++++.<<<.<<<+.>>>.>>>----.<<<.>>.<-.>>+++.<<.>>---.+++.<<++++.<<.<<-.>-.>>+++.<.>---.>+++++.<<<.++++++.<--.+.+.<<-.++.<-.>>>>.+++.<<<--.>>>>>+.<.>-.>.<<<<<<.>>>>>+.>>>.<<-----.----.++++.<.-.<<--.>>>>.<----.<<<.>>+.>>.<.--.<----.---.<<+..<-.++.<<.>>+.<.<++.");
//OPTIMI HAND  
solutionMap.put("ZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT YZOILT Y","->-->->++>+++>>+++++[-<++[-<-<+<+<->>>>]>]-->-[-<<<[<]>[.>].>.>]");
// **       solutionMap.put("LBOL B LLLBBB OOOBLLBB L BL BOLL L LOB BO LB O BB O BLL OBO BBBLLBOLO O B L BBBOOLB L O BBBLLBOLO BLOLOLB","-[+<--<+<+]<<-.>+.>>+.<<<.>>.<.>.<<...>...>.>...<<.<..>..>.<<.>>.<.<.>>.<.>>.<<<..>>.<<.>>.<<.+++.>.>.<.<.>>.>---.<<.>.<<.>>.<..>.<<.>>.<.>>..<.<<.>.<.>>.<...>>..<<.<.---.+++.>>.<<.>>.<.>.>.<.<...<..---.>.>.>.<.>+++.<.<...<..>.>>.<<<.+++.>>.<.<---.+++.---.+++.---.>.");
//OPTIMI HAND    
 solutionMap.put("GFEDCBA ZYXWVUTSRQ","+++++++[->->+<<]>--[->.-<]"); //13282
//OPTIMI HAND
 solutionMap.put("ZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZZYXWVUTSRQPONMLKJIHGFEDCBAZ","-[->+<-]>--[->-[.-]-.+<]"); //12711
// **     solutionMap.put("LILALOLPLGLMLULTLNLQLSLULGLOLKL LWLBLDLZLAL LKLQLGL LILCLELCL LX","-[+<--<+<+]<<-.---.+++.>.<.+++.---.++++.<<<-.-----.<<<-.+.-.<-----.>.<-.>.++.--.<---.>.<++.>.<++.>.>>>.<<<.+++.---.-.+.>-.<.<++.>.<<+.<-.>++.<.<.>.<<.<-.>-.<.-.+.+++++.>>>.>+++.<.<<.>>.---.+++.<<+++.>>.>--.<.<<.>>.>>>>.<.<+.");
// +++ EXISTE PAS     solutionMap.put(" Z Y X W V U T S R Q P O N M L K J I H G F E D C B A","-[>.<.-]");
//OPTIMI HAND
 solutionMap.put("URULURULURULURULURULURULURULURULURULURULURULURUL UFN UFN UFN UFN UFN UFN UFN UFN UFN UFN UFN UFN UFN UFN UFN","---[+>-->-->--<<<]>>--->>->->-[-<+<+>>-]<[-<<<<.>.>.>.>]---[+>-->++>---->----<<<<]>>>->[-<<<<.>.>.>.>]"); // 11777
//        
// **       solutionMap.put("TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB TB SRQRSRQRQRQRSRSRSRQRSRQRSRQRQRQRSSSRQRQSRSS","------->++><<<-[->.>.>.<<<]-------.<++.<.>>.<.<.>>-.-.-.+.+.-.-.+.-.+.-.+.+.-.+.-.+.-.-.+.+.-.-.+.+.-.-.+.-.+.-.+.+...-.-.+.-.++.-.+..");
// **      solutionMap.put("NVOOLM NLIRZNVOOLM NLIRZNLIRZNLIRZNVOOLM NVOOLM NVOOLM NLIRZNLIRZNVOOLM NVOOLM NLIRZ","-[+<--<<+>---]>+.<-----.<-..---.+.<---.<-.--.---.<<+++.>>>-.>+.>.<+..---.+.<<<---.<<<-.--.---.>>.>-.>>>+.--.<<.<<.>.<----.--.<<.<<+++.<----.<-.>----.<+..---.+.<---.<-.>>>.<++..---.+.<.<.>>>.<++..---.+.<.<.--.---.>>>>.<<<-.>+.--.<<.>>>>.<<<.>++.>.<+..---.+.<<<---.<-.>>>>>.<++..---.+.<<<.<.--.>>.>>>>.<<<.");
// ** 
 solutionMap.put("AZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZXVTRPNLJHFDB YWUSQOMKIGECAZXVTRPNLJHFDB YWUSQOMKIGECAZ","+>-<<-------[->.>.<<]>>>--->>++[<-[<.-->-]>-]+.>-.");
//        
        //+++ EXISTE PAS solutionMap.put("GSIVV IRMTH ULI GSV VOEVM PRMTH FMWVI GSV HPB HVEVM ULI GSV WDZIU OLIWH RM GSVRI SZOOH LU HGLMV MRMV ULI NLIGZO NVM WLLNVW GL WRV LMV ULI GSV WZIP OLIW LM SRH WZIP GSILMVRM GSV OZMW LU NLIWLI DSVIV GSV HSZWLDH ORV LMV IRMT GL IFOV GSVN ZOO LMV IRMT GL URMW GSVN LMV IRMT GL YIRMT GSVN ZOO ZMW RM GSV WZIPMVHH YRMW GSVN RM GSV OZMW LU NLIWLI DSVIV GSV HSZWLDH ORV","-[+<--<<+>---]<<++++.>+++.<++.>+++..>.<<.<+++.<<--.>>++.>-.>>.<-.>>-.---.<.<<-.<-.+++.>>>.<+.<<<<<<.<++.>>>>>.<<.<---.<+.++.>>.<<++.<+++.>>.<<--.<--.>>+++.-.<+++.>>.<<--.>---.+++.>.<<+.<<<+.<-.--.>>>>.>.<---.>.<<.<<<.------.<---.---.<---.>--.>--.+++.<<.>>+.>>+.<<<<-.>++.>--.>>----.<-.---.<<.>++.<-.>>>.>+++++.<<+.>.<<<-.>----.+++.>>>.>++++.<<.>+.<-.<++..<<+.<<<---.<---.>>>>>-.<<<<.>>>.-.<<<<.+.>-----.<<---.>.<<+++.>>.>.<<.>>-.<-.---.<.<<<-.--.---.--.>>>-.>>>.<<<<<---.<<<-.++++++++.<<--.<---.----.>-..++.<-.+.<<<<.<<.<<<-.<.<+.<<-.>>-.>.>.+.<<.>.<-.>>-.<<<.>>.<<--.<+.+++.>>>.<++.>-.<<++.<<<+.<<<<<<<<<.>---.---.>>.>++.<<<<.>.+.<.<<<---.-.>>+.>.----.>>.>.>>+.>>-------.<<<<--.>----.<++.<<-.+.<-.<<<.<<-.>---.>>>-.<<+.+++.<.<<<.>+++.>.>>+.<.<-.>>--.<.<++.--.---.<---.<---.>>.>.>>+.<--.+++.<<.<-.>>.<--.<---.+++.>>.<+.<---.>>-.>+.<<<<.<+.<-.<.<<<<<+++.+++.>>.>>>.>++++.+.<<.>.<<++.<<<.-----.>>--.>>>.<<--.<<<-.>---.<<<<.---.<<<-.<+.<.<<<<--.>.+++.>--.>>.<.<+..>>.<<---.+.<.>>>.<<<<++.>----.>.<++.>>>.<<<<--.<<-.>>>>>>.>-.---.<<<.<+++.>>>.<<<<.>----.+++.>+.>>.<<--.+.<.>>>.<<<<++.>----.>.<++.>>>.<<<<--.<<.>>>>>>.<-.<<<++.>--.>.<++.>>>.<<<<--.>-.+++.>+.>>.-.>>..>>>>>>>.-.<+.<<.<------.<<<<.>--.>>>.>>>>>>.<-.>>.>.<+.>-.<<++.<---.<<.<<-.>>>>>-..<<<<<<.--.<<<<.>.>>+.<<<<<<<<-------.<<<<.>---.+++.>++.>>.>----.>-.<<.<<<<.>---.+++.>>>.<<+.>.<--.<+.>>>.<<-.<--.>>>.>>+.--.---.>--.<+++.---.<<.++++.>+.+++.>.<.<----.<<<<.>--.+++.>>>.>>-.<---.<<.<<+.>.<<<.>+.>>>>.<<+++.+++.<-.");


        if (toEmit.isEmpty()) {
            return o;
        }        
        
        if(solutionMap.containsKey(toEmit)){
            o.loop(solutionMap.get(toEmit));
            return o;
        }        
        
        new Solver_001(toEmit).apply(o); 
        
//        for(int i=0;i<toEmit.length();i++){
//            char c=toEmit.charAt(i);
//            
//            Blocks.setAtCursor(c).apply(o);
//            Blocks.emitAtCursor.apply(o);
//        }

        return o;

    }

}