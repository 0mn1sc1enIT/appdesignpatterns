//Способности
public class Skill implements ICloneable<Skill> {
    public String name;
    public SkillType skillType;
    public Skill(String name, SkillType skillType) {
        this.name = name;
        this.skillType = skillType;
    }
    public Skill clone() {
        return new Skill(this.name, this.skillType);
    }

    public String getInfo() {
        return STR."\{this.name}\tskill type: \{this.skillType}\n";
    }
}
