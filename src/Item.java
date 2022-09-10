public class Item {
    String name;
    private Integer hp;
    private Attack attack;
    private Integer defense;
    private Integer specialDefense;

    Item(ItemsBuilder builder) {
        this.name = builder.name;
        this.hp = builder.hp;
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.specialDefense = builder.specialDefense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }
}
