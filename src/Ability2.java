//command class
//same effect as Ability1
public class Ability2 extends Ability implements Action {
    public Ability2 (int damage, boolean stun, boolean dodge, int cooldown){
        super(damage, stun, dodge, cooldown);
    }

    public void execute(Pokemon pokemon) {
        if (this.charged == 0) {
            if (!pokemon.pokemonFighting.dodged) {
                new MyLogger().myLog(pokemon.name + " executa ability2 contra " + pokemon.pokemonFighting.name);
                charged = cooldown;
                pokemon.pokemonFighting.hp -= damage;
                pokemon.pokemonFighting.stunned = stun;
            }
            else
                new MyLogger().myLog( pokemon.pokemonFighting.name + " is dodged");
        }else
            pokemon.attack.execute(pokemon);
    }
}
