import java.util.List;
import java.util.ArrayList;
//Персонаж
public class Character implements ICloneable<Character> {
    public String name;
    public int health;
    public int strength;
    public int agility;
    public int intelligence;
    public Weapon weapon;
    public Armor armor;
    public List<Skill> skills;

    public Character() {
        skills = new ArrayList<Skill>();
    }

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public Character(String name, int health, int strength, int agility, int intelligence,
                     Weapon weapon, Armor armor, ArrayList<Skill> warriorSkills) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.armor = armor;
        this.weapon = weapon;
        skills = warriorSkills;
    }


    public Character clone() {
        Character clone = new Character();
        clone.name = this.name;
        clone.health = this.health;
        clone.strength = this.strength;
        clone.agility = this.agility;
        clone.intelligence = this.intelligence;
        clone.skills.addAll(this.skills);
        clone.armor = this.armor.clone();
        clone.weapon = this.weapon.clone();
        return clone;
    }

    public String getInfo() {
        String CharacterInfo = "Персонаж:\t"+this.name+"\nЗдоровье:\t"+this.health+"\nСила:\t"+
                this.strength+"\nЛовкость:\t" +this.agility+"\nИнтеллект:\t"+
                this.intelligence;
        String ArmorInfo = this.armor.getInfo();
        String WeaponInfo = this.weapon.getInfo();
        StringBuilder SkillsInfo = new StringBuilder();
        for (var skill: this.skills) {
            SkillsInfo.append(skill.getInfo());
        }
        return STR."\{CharacterInfo}\n\{ArmorInfo}\n\{WeaponInfo}\n\{SkillsInfo}";
    }
}
