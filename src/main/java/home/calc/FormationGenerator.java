package home.calc;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 28.05.14
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
public class FormationGenerator {
    private String startData =
            "Защита\t2LD+3CD+2RD, 3LD+3CD+RD, LD+3CD+3RD, 2LD+4CD+RD, LD+4CD+2RD, LD+5CD+RD\n" +
            "Полузащита\t2CM, LM+RM\n" +
            "Нападение\tLF, CF, RF\n" +
            "\n" +
            "Защита\t2LD+2CD+2RD, 2LD+3CD+RD, LD+3CD+2RD, LD+4CD+RD\n" +
            "Полузащита\tLM+CM+RM\n" +
            "Нападение\tLF, CF, RF\n" +
            "\n" +
            "Защита\t2LD+2CD+2RD, 2LD+3CD+RD, LD+3CD+2RD, LD+4CD+RD\n" +
            "Полузащита\t2CM, LM+RM\n" +
            "Нападение\tLF+CF, LF+RF, CF+RF, 2CF\n" +
            "\n" +
            "Защита\t2LD+CD+2RD, 2LD+2CD+RD, LD+2CD+2RD, LD+3CD+RD\n" +
            "Полузащита\t2LM+CM+RM, LM+2CM+RM, LM+CM+2RM\n" +
            "Нападение\tLF, CF, RF\n" +
            "\n" +
            "Защита\t2LD+CD+2RD, 2LD+2CD+RD, LD+2CD+2RD, LD+3CD+RD\n" +
            "Полузащита\tLM+CM+RM\n" +
            "Нападение\tLF+CF, LF+RF, CF+RF, 2CF\n" +
            "\n" +
            "Защита\t2LD+CD+2RD, 2LD+2CD+RD, LD+2CD+2RD, LD+3CD+RD\n" +
            "Полузащита\t2CM, LM+RM\n" +
            "Нападение\tLF+CF+RF\n" +
            "\n" +
            "Защита\tLD+2CD+RD\n" +
            "Полузащита\t2LM+CM+RM, LM+2CM+RM, LM+CM+2RM\n" +
            "Нападение\tLF+CF, LF+RF, CF+RF, 2CF\n" +
            "\n" +
            "Защита\tLD+2CD+RD\n" +
            "Полузащита\t2LM+CM+2RM, 2LM+2CM+RM, LM+2CM+2RM, LM+3CM+RM\n" +
            "Нападение\tLF, CF, RF\n" +
            "\n" +
            "Защита\tLD+2CD+RD\n" +
            "Полузащита\tLM+CM+RM\n" +
            "Нападение\tLF+CF+RF\n" +
            "\n" +
            "Защита\tLD+CD+RD\n" +
            "Полузащита\t2LM+2CM+2RM, 2LM+3CM+RM, LM+3CM+2RM, LM+4CM+RM\n" +
            "Нападение\tLF, CF, RF\n" +
            "\n" +
            "Защита\tLD+CD+RD\n" +
            "Полузащита\t2LM+CM+2RM, 2LM+2CM+RM, LM+2CM+2RM, LM+3CM+RM\n" +
            "Нападение\tLF+CF, LF+RF, CF+RF, 2CF\n" +
            "\n" +
            "Защита\tLD+CD+RD\n" +
            "Полузащита\t2LM+CM+RM, LM+2CM+RM, LM+CM+2RM\n" +
            "Нападение\tLF+CF+RF\n" +
            "\n" +
            "Защита\tLD+CD+RD\n" +
            "Полузащита\tLM+CM+RM\n" +
            "Нападение\tLF+2CF+RF\n" +
            "\n" +
            "Защита\tLD+2CD+RD\n" +
            "Полузащита\t2CM, LM+RM\n" +
            "Нападение\tLF+2CF+RF\n" +
            "\n" +
            "Защита\tLD+CD+RD\n" +
            "Полузащита\t2CM, LM+RM\n" +
            "Нападение\t2LF+CF+2RF, 2LF+2CF+RF, LF+2CF+2RF, LF+3CF+RF";

    public FormationGenerator(){
        System.out.println("Formation Generator");
        String[] formation = startData.split("\n\n");

        for (String form: formation){
//            System.out.println("\nAnalyzing:\n"+form);
            form=form.replace(" ","")
                    .replace("Защита", "")
                    .replace("Полузащита","")
                    .replace("Нападение", "")
                    .replace("\t","")
                    .replace(","," ");
//            System.out.println("=>");
            String[] zone = form.split("\n");
            String[] defence = zone[0].split(" ");
            String[] midle = zone[1].split(" ");
            String[] forward = zone[2].split(" ");
//            System.out.println("Variations:");
            for (String d: defence){
                for (String m: midle){
                    for (String f: forward){
                        d = d
                                .replace("2LD","LD+LD")
                                .replace("2CD","CD+CD")
                                .replace("2RD","RD+RD")
                                .replace("3LD","LD+LD+LD")
                                .replace("3CD","CD+CD+CD")
                                .replace("3RD","RD+RD+RD")
                                .replace("4LD","LD+LD+LD+LD")
                                .replace("4CD","CD+CD+CD+CD")
                                .replace("4RD","RD+RD+RD+RD")
                                .replace("5LD","LD+LD+LD+LD+LD")
                                .replace("5CD","CD+CD+CD+CD+CD")
                                .replace("5RD","RD+RD+RD+RD+RD");
                        m = m
                                .replace("2LM","LM+LM")
                                .replace("2CM","CM+CM")
                                .replace("2RM","RM+RM")
                                .replace("3LM","LM+LM+LM")
                                .replace("3CM","CM+CM+CM")
                                .replace("3RM","RM+RM+RM")
                                .replace("4LM","LM+LM+LM+LM")
                                .replace("4CM","CM+CM+CM+CM")
                                .replace("4RM","RM+RM+RM+RM")
                                .replace("5LM","LM+LM+LM+LM+LM")
                                .replace("5CM","CM+CM+CM+CM+CM")
                                .replace("5RM","RM+RM+RM+RM+RM");
                        f = f
                                .replace("2LF","LF+LF")
                                .replace("2CF","CF+CF")
                                .replace("2RF","RF+RF")
                                .replace("3LF","LF+LF+LF")
                                .replace("3CF","CF+CF+CF")
                                .replace("3RF","RF+RF+RF")
                                .replace("4LF","LF+LF+LF+LF")
                                .replace("4CF","CF+CF+CF+CF")
                                .replace("4RF","RF+RF+RF+RF")
                                .replace("5LF","LF+LF+LF+LF+LF")
                                .replace("5CF","CF+CF+CF+CF+CF")
                                .replace("5RF","RF+RF+RF+RF+RF");
                        String out = "+"+d+"+"+m+"+"+f;
                        out = out
                                .replace("+",", Positions.");
/*                        positions.add(new Positions[] {
                                Positions.GK,
                                Positions.RD, Positions.CD, Positions.CD, Positions.LD,
                                Positions.RM, Positions.CM, Positions.LM,
                                Positions.RF, Positions.CF, Positions.LF
                        });

                        */
                        System.out.print("" +
                                "positions.add(new Positions[] {\n" +
                                "\tPositions.GK"+out+"\n});\n");

                    }
                }
            }



        }

    }
}
