import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Skill warriorSkill1 = new Skill("Разрушение", SkillType.Magical);
        Skill warriorSkill2 = new Skill("Неистовство",SkillType.Pure);
        ArrayList<Skill> warriorSkills = new ArrayList<>();
        warriorSkills.add(warriorSkill1);
        warriorSkills.add(warriorSkill2);
        Character warrior = new Character("Воин", 100, 30, 10, 5,
                new Weapon("Секира", 23),
                new Armor("Берсерк", 66),
                warriorSkills);
        System.out.println(warrior.getInfo());
        Character cloneWarrior = warrior.clone();
        System.out.println(cloneWarrior.getInfo());
    }
}
