package home.calc;

import home.calc.utils.Positions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * User: def
 * Date: 5/22/14
 * Time: 7:41 PM
 */
public class Lineup {
    private Boolean correct = true;
    private ArrayList<PlayerOnPosition> lineUp;
    private Integer g = 0;
    private Integer d = 0;
    private Integer m = 0;
    private Integer f = 0;
    private Integer leader;
    private Integer leaderBonus;

    public Lineup() {
        lineUp = new ArrayList<PlayerOnPosition>();
    }


    public String getType(){
        return d+"-"+m+"-"+f;
    }


    public ArrayList<PlayerOnPosition> getPlayers(){
        return lineUp;
    }


    public void addPlayer(Positions position, Player player){
        for (PlayerOnPosition p: lineUp){
            if (p.getPlayer().equals(player)){
                correct = false;
            }
        }
        if (correct){
            this.lineUp.add(new PlayerOnPosition(position, player));
            if (position.toString().contains("G")){
                g++;
            }
            else if (position.toString().contains("D")){
                d++;
            }
            else if (position.toString().contains("M")){
                m++;
            }
            else if (position.toString().contains("F")){
                f++;
            }

        }
    }
    public void printLineUp(){
        for (PlayerOnPosition playerOnPosition: lineUp){
            System.out.println(playerOnPosition.getPosition().toString() + " "
                    + playerOnPosition.getPlayer().getName() + " "
                    + playerOnPosition.getPredictedStrength());
        }

    }
    public Integer getAllStrength(){
        Integer allStr = 0;
        for (PlayerOnPosition p: lineUp){
            allStr = allStr + p.getPredictedStrength();

        }
        return allStr;
    }

    public Integer getDefenceLineStrength(){

        Integer str = 0;
        for (PlayerOnPosition p: lineUp){
            if (p.getPosition().toString().contains("D")){
                str = str + p.getPredictedStrength();
            }
        }
        return str;
    }
    public Integer getMidleLineStrength(){

        Integer str = 0;
        for (PlayerOnPosition p: lineUp){
            if (p.getPosition().toString().contains("M")){
                str = str + p.getPredictedStrength();
            }
        }
        return str;
    }
    public Integer getForwardLineStrength(){

        Integer str = 0;
        for (PlayerOnPosition p: lineUp){
            if (p.getPosition().toString().contains("F")){
                str = str + p.getPredictedStrength();
            }
        }
        return str;
    }
    public Integer getLeftLineStrength(){

        Integer str = 0;
        for (PlayerOnPosition p: lineUp){
            if (p.getPosition().toString().contains("L")){
                str = str + p.getPredictedStrength();
            }
        }
        return str;
    }

    public Integer getCenterLineStrength(){

        Integer str = 0;
        for (PlayerOnPosition p: lineUp){
            if (p.getPosition().toString().contains("C")){
                str = str + p.getPredictedStrength();
            }
        }
        return str;
    }

    public Integer getRightLineStrength(){

        Integer str = 0;
        for (PlayerOnPosition p: lineUp){
            if (p.getPosition().toString().contains("R")){
                str = str + p.getPredictedStrength();
            }
        }
        return str;
    }

    public Boolean isCorrect(){

        return correct;
    }

    public Integer getLeader(){
        return leader;
    }

    public Integer getLeaderBonus(){
        return leaderBonus;
    }

    private void findLeader(){
        BigDecimal maxProfit = BigDecimal.ZERO;
        Integer i = 0;
        BigDecimal  bonus;
        for (int j = 0; j < lineUp.size(); j++){
            bonus = BigDecimal.ZERO;
            Integer age = lineUp.get(j).getPlayer().getAge();
            if (lineUp.get(j).getPlayer().getSpecialities().contains("Л3")){
                if (age<34){
                    age = 34;
                }
            }
            else  if (lineUp.get(j).getPlayer().getSpecialities().contains("Л2")){
                if (age<32){
                    age = 32;
                }
            }
            else  if (lineUp.get(j).getPlayer().getSpecialities().contains("Л")){
                if (age<30){
                    age = 30;
                }
            }
            bonus = new BigDecimal(lineUp.get(j).getPlayer().getStrength()*
                    (100-10*(30-age))).divide(new BigDecimal(100), RoundingMode.HALF_UP);
            if (maxProfit.compareTo(bonus) < 0){
                maxProfit = bonus;
                i = j;
            }
        }
        this.leader = i;
        this.leaderBonus = new BigDecimal(lineUp.get(leader).getPlayer().getRealStrength()).divide(new BigDecimal(10), RoundingMode.UP).intValue();
    }

    public void calculate(){
        this.findLeader();
        if (this.getType().equals("7-2-1")
                || this.getType().equals("6-3-1")
                || this.getType().equals("5-4-1")
                || this.getType().equals("5-3-2")
                || this.getType().equals("6-2-2")
                ){
            for (int j = 0; j < lineUp.size(); j++){
                if (lineUp.get(j).getPosition().toString().contains("D")){
                    lineUp.get(j).setPredictedStrength(
                            new BigDecimal(lineUp.get(j).getPredictedStrength()).multiply(new BigDecimal("0.96")).intValue()
                    );
                }
                else if (lineUp.get(j).getPosition().toString().contains("M")){
                    lineUp.get(j).setPredictedStrength(
                            new BigDecimal(lineUp.get(j).getPredictedStrength()).multiply(new BigDecimal("0.98")).intValue()
                    );
                }
                if (j != leader){
                    lineUp.get(j).setPredictedStrength(lineUp.get(j).getPredictedStrength()+leaderBonus);
                }
            }
        }
        else if (this.getType().equals("4-5-1")
                || this.getType().equals("3-6-1")
                || this.getType().equals("5-2-3")
                || this.getType().equals("4-4-2")
                || this.getType().equals("3-5-2")
                ){

            for (int j = 0; j < lineUp.size(); j++){
                if (lineUp.get(j).getPosition().toString().contains("F")){
                    lineUp.get(j).setPredictedStrength(
                            new BigDecimal(lineUp.get(j).getPredictedStrength()).multiply(new BigDecimal("0.98")).intValue()
                    );
                }
                else if (lineUp.get(j).getPosition().toString().contains("M")){
                    lineUp.get(j).setPredictedStrength(
                            new BigDecimal(lineUp.get(j).getPredictedStrength()).multiply(new BigDecimal("0.96")).intValue()
                    );
                }
                if (j != leader){
                    lineUp.get(j).setPredictedStrength(lineUp.get(j).getPredictedStrength()+leaderBonus);
                }

            }
        }
        else if(this.getType().equals("4-3-3")
                || this.getType().equals("4-2-4")
                || this.getType().equals("3-4-3")
                || this.getType().equals("3-3-4")
                || this.getType().equals("3-2-5")
                ) {

            for (int j = 0; j < lineUp.size(); j++){
                if (lineUp.get(j).getPosition().toString().contains("F")){
                    lineUp.get(j).setPredictedStrength(
                            new BigDecimal(lineUp.get(j).getPredictedStrength()).multiply(new BigDecimal("0.96")).intValue());
                }
                else if (lineUp.get(j).getPosition().toString().contains("M")){
                    lineUp.get(j).setPredictedStrength(
                            new BigDecimal(lineUp.get(j).getPredictedStrength()).multiply(new BigDecimal("0.98")).intValue()
                    );
                }
                if (j != leader){
                    lineUp.get(j).setPredictedStrength(lineUp.get(j).getPredictedStrength()+leaderBonus);
                }

            }
        }
    }
}
