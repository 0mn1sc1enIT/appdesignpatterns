//Оружие
public class Weapon implements ICloneable<Weapon> {
    public String name;
    public int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public Weapon clone() {
        return new Weapon(this.name, this.damage);
    }

    public String getInfo() {
        return this.name+"\t"+this.damage+" урона";
    }
}
