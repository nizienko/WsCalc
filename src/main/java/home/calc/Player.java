package home.calc;

import home.calc.utils.Performance;
import home.calc.utils.Positions;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;

/**
 * User: def
 * Date: 5/21/14
 * Time: 9:45 PM
 */
public class Player {
    private String name;
    private String position;
    private Integer age;
    private Integer strength;
    private Integer fitness;
    private BigDecimal moral;
    private BigDecimal moralChange;
    private Integer realStrength;
    private BigDecimal ratio;
    private Integer games;
    private String specialities;
    private BigDecimal cost;
    private BigDecimal salary;
    private String status;

    private Performance performance;

    public Player(Element player) {
//        System.out.println("------------");
        this.name = player.select("a[href*=ngPlayerInfo]").text();
//        System.out.println("Имя - " + this.name);
        this.position = player.select("td:eq(4)").text();
//        System.out.println("Позиция - " + this.position);
        try {
            this.age = Integer.parseInt(player.select("td:eq(5)").text().replace("\u00a0",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.age = 0;
        }
//        System.out.println("Возраст - " + this.age);
        try {
            this.strength = Integer.parseInt(player.select("td:eq(6)").text().replace("\u00a0",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.strength = 0;
        }
//        System.out.println("Сила - " + this.strength);
        try {
            this.fitness = Integer.parseInt(player.select("td:eq(8)").text().replace("\u00a0","").replace("%",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.fitness = 0;
        }
//        System.out.println("Готовность - " + this.fitness + "%");
        try {
            String moralString = player.select("td:eq(9) > img").attr("alt").replace("\u00a0","");
            this.moral = new BigDecimal(moralString.replaceAll(".*\\(([0-9]\\.[0-9]{2}).*([0-9]\\.[0-9]{2})\\)","$1"));
            this.moralChange = new BigDecimal(moralString.replaceAll(".*\\(([0-9]\\.[0-9]{2}).*([0-9]\\.[0-9]{2})\\)","$2"));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.moral = BigDecimal.ZERO;
            this.moralChange = BigDecimal.ZERO;
        }
//        System.out.println("Мораль - " + this.moral + ", изменение - " + this.moralChange);
        try {
            this.realStrength = Integer.parseInt(player.select("td:eq(10)").text().replace("\u00a0",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.realStrength = 0;
        }
//        System.out.println("Реальная сила - " + this.realStrength);

        try {
            this.ratio = new BigDecimal(player.select("td:eq(11)").text().replace("\u00a0",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.ratio = BigDecimal.ZERO;
        }
//        System.out.println("Коффециент перспективности - " + this.ratio);
        try {
            this.games = Integer.parseInt(player.select("td:eq(12)").text().replace("\u00a0",""));
            if (player.select("td:eq(12) > font").attr("color").equals("green")) {
                games = games*(-1);
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.games = 0;
        }
//        System.out.println("Игр подряд - " + this.games);
        this.specialities = player.select("td:eq(13)").text();
//        System.out.println("Спецухи - " + this.specialities);
        try {
            this.cost = new BigDecimal(player.select("td:eq(14)").text().replace("\u00a0",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.cost = BigDecimal.ZERO;
        }
//        System.out.println("Цена - " + this.cost);
        try {
            this.salary = new BigDecimal(player.select("td:eq(15)").text().replace("\u00a0",""));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            this.salary = BigDecimal.ZERO;
        }
//        System.out.println("Зарплата - " + this.salary);
//        System.out.println("============");

    }

    public String getName() {
        return this.name;
    }
    public Integer getRealStrength() {
        return this.realStrength;
    }

    public boolean isPosition(String position) {
        return this.position.contains(position);
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public String getPosition(){
        return position;
    }

    public void setPerformance(Performance performance){
        this.performance = performance;
//        System.out.println(this.getName()+" становится "+performance.toString());
    }

    public Performance getPerformance(){
        if (this.performance != null){
            return this.performance;
        }
        else {
            return Performance.UNKNOWN;
        }
    }

    public Boolean strongerThan(Player player){
        return this.getRealStrength()>player.getRealStrength();
    }

    public Integer getFitness(){
        return fitness;
    }

    public String getSpecialities(){
        return specialities;
    }

    public Integer getStrength()
    {
        return strength;
    }

    public Integer getAge()
    {
        return age;
    }

}