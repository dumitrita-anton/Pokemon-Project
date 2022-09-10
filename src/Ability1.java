//command class

public class Ability1 extends Ability implements Action {
    public Ability1 (int damage, boolean stun, boolean dodge, int cooldown){
        super(damage, stun, dodge, cooldown);
    }

    public void execute(Pokemon pokemon) {
        if (this.charged == 0) {
            if (!pokemon.pokemonFighting.dodged) {

                new MyLogger().myLog(pokemon.name + " executa ability1 contra " + pokemon.pokemonFighting.name);
                //pokemon atacat -> actualizeaza punctele atacatului
                charged = cooldown;
                pokemon.pokemonFighting.hp -= damage;
                pokemon.pokemonFighting.stunned = stun;
            }
            else
                new MyLogger().myLog( pokemon.pokemonFighting.name + " is dodged");
        }else
            //actualizeaza punctele pokemonului care ataca
            pokemon.attack.execute(pokemon);
    }
}
