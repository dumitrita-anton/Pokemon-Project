public class ItemsBuilder {
    public String name;
    public Integer hp;
    public Attack attack;
    public Integer defense;
    public Integer specialDefense;

    public ItemsBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemsBuilder withHP(Integer hp) {
        this.hp = hp;
        return this;
    }

    public ItemsBuilder withAttack(Attack attack) {
        this.attack = attack;
        return this;
    }

    public ItemsBuilder withDefense(Integer defense) {
        this.defense = defense;
        return this;
    }

    public ItemsBuilder withSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
        return this;
    }

    public Item build() {
        return new Item(this);
    }

}
