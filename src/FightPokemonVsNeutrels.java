import static java.lang.Math.*;

public class FightPokemonVsNeutrels implements Strategy{
    @Override
    public int fight(Pokemon pokemon11, Pokemon pokemon22) {
        new MyLogger().myLog("\n" + pokemon11.name + " vs " + pokemon22.name);
        int counter = 1;

        Pokemon pokemon1 = new Pokemon(pokemon11);
        Pokemon pokemon2 = new Pokemon(pokemon22);

        pokemon1.setPokemonFighting(pokemon2);
        pokemon2.setPokemonFighting(pokemon1);

        //Tablou de comenzi
        Action[] listOfOrders1 = new Action[3];
        listOfOrders1[0] = pokemon1.attack;
        listOfOrders1[1] = pokemon1.ability1;
        listOfOrders1[2] = pokemon1.ability2;

        while (pokemon1.hp > 0 && pokemon2.hp > 0) {
            new MyLogger().myLog("Round " + counter);
            int choice;
            choice = (int)(random() * 3);

            if(!pokemon1.stunned)
                pokemon1.dodged = listOfOrders1[choice].isDodge();

            if(!pokemon2.stunned)
                pokemon2.attack.execute(pokemon2);
            else {
                new MyLogger().myLog(pokemon2.name + " stunned");
                pokemon2.stunned = false;
            }

            listOfOrders1[choice].execute(pokemon1);

            new MyLogger().myLog(pokemon1.name + " HP:"+pokemon1.hp+" dodged:"+pokemon1.dodged+" stunned:"+pokemon1.stunned);
            new MyLogger().myLog(pokemon2.name + " HP:"+pokemon2.hp+" dodged:"+pokemon2.dodged+" stunned:"+pokemon2.stunned);

            pokemon1.dodged = false;
            pokemon1.updateAbilities();
            counter++;
        }

        if(pokemon1.hp > 0) {
            return 1;
        }
        if(pokemon2.hp > 0) {
            return 2;
        }

        return 0;
    }
}
