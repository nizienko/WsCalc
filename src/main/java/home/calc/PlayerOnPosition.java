package home.calc;

import home.calc.utils.Positions;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 28.05.14
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class PlayerOnPosition {
    private Positions position;
    private Player player;
    private Integer predictedStrength;

    public PlayerOnPosition(Positions position, Player player) {
        this.position = position;
        this.player = player;
        this.predictedStrength = this.player.getRealStrength();
    }

    public Positions getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getPredictedStrength() {
        return predictedStrength;
    }

    public void setPredictedStrength(Integer predictedStrength) {
        this.predictedStrength = predictedStrength;
    }

}
