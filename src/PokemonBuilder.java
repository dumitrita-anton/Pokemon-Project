public class PokemonBuilder {
    //Dessign pattern 1 - builder
    public String name;
    public Integer hp;
    public Attack attack;
    public Integer defense;
    public Integer specialDefense;
    public Ability1 ability1;
    public Ability2 ability2;

    public PokemonBuilder Name(String name) {
        this.name = name;
        return this;
    }

    public PokemonBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public PokemonBuilder withAttack(Attack attack){
        this.attack = attack;
        return this;
    }

    public PokemonBuilder withDefense(int defense){
        this.defense = defense;
        return this;
    }

    public PokemonBuilder withSpecialDefenses( int specialDefense){
        this.specialDefense = specialDefense;
        return this;
    }

    public PokemonBuilder withAbilities(Ability1 ability1, Ability2 ability2){
        this.ability1 = ability1;
        this.ability2 = ability2;
        return this;
    }

    //Return the finally constrcuted Pokemon object
    public Pokemon build(){
        Pokemon pokemon = new Pokemon();
        pokemon.name = this.name;
        pokemon.hp = this.hp;
        pokemon.attack = this.attack;
        pokemon.defense = this.defense;
        pokemon.specialDefense = this.specialDefense;
        pokemon.ability1 = this.ability1;
        pokemon.ability2 = this.ability2;

        return pokemon;
    }

}
