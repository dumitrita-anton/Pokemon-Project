//command class

public class Attack implements Action {
    Integer normalAttack;
    Integer specialAttack;

    public Attack(Integer normalAttack, Integer specialAttack) {
        this.normalAttack = normalAttack;
        this.specialAttack = specialAttack;
    }

    public boolean isDodge(){
        return false;
    }

    public Integer getNormalAttack() {
        return normalAttack;
    }

    public void setNormalAttack(Integer normalAttack) {
        this.normalAttack = normalAttack;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void execute(Pokemon pokemon) {
        if(pokemon.pokemonFighting.dodged == false) {
            new MyLogger().myLog(pokemon.name + " attacks " +
                    pokemon.pokemonFighting.name);
            if (pokemon.attack.normalAttack == 0) {
                int points = pokemon.attack.specialAttack -
                        pokemon.pokemonFighting.specialDefense;
                if (points > 0)
                    pokemon.pokemonFighting.hp -= points;
            } else {
                int points = pokemon.attack.normalAttack -
                        pokemon.pokemonFighting.defense;
                if (points > 0)
                    pokemon.pokemonFighting.hp -= points;
            }

        } else {
            new MyLogger().myLog(pokemon.pokemonFighting.name + " is dodged; attack failed");
        }
    }
}
