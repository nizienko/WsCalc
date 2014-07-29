package home.calc;


/**
 * User: def
 * Date: 5/22/14
 * Time: 12:45 AM
 */
public class Activities {


    public Activities() {

    }


    public String getOppositePosition(String position) {
        if (position.equals("GK")) return position;
        String oppositePosition = "";
        if (position.substring(0, 1).equals("L")) oppositePosition = "R";
        else if (position.substring(0, 1).equals("R")) oppositePosition = "L";
        else oppositePosition = "C";
        if (position.substring(1, 2).equals("D")) oppositePosition = oppositePosition + "F";
        else if (position.substring(1, 2).equals("F")) oppositePosition = oppositePosition + "D";
        else oppositePosition = oppositePosition + "M";
        return oppositePosition;
    }

}
