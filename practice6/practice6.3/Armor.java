//Броня
public class Armor implements ICloneable<Armor>{
    public String name;
    public int defence;

    public Armor(String name, int defence) {
        this.defence = defence;
        this.name = name;
    }

    public Armor clone() {
        return new Armor(this.name, this.defence);
    }
    public String getInfo() {
        return STR."\{this.name}\t\{this.defence} защиты";
    }
}
