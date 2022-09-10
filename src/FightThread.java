import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FightThread implements Strategy{
    @Override
    public int fight(Pokemon pokemon11, Pokemon pokemon22){
        new MyLogger().myLog("\n" + pokemon11.name + " vs " +
                pokemon22.name);
        int counter = 1;

        Pokemon pokemon1 = new Pokemon(pokemon11);
        Pokemon pokemon2 = new Pokemon(pokemon22);

        pokemon1.setPokemonFighting(pokemon2);
        pokemon2.setPokemonFighting(pokemon1);

        ExecutorService executor;

        while (pokemon1.hp > 0 && pokemon2.hp > 0) {
            new MyLogger().myLog("Round " + counter);
            executor = Executors.newFixedThreadPool(2);
            executor.execute(pokemon1);
            executor.execute(pokemon2);

            executor.shutdown();

            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new MyLogger().myLog(pokemon1.name + " HP:"+pokemon1.hp+" dodged:"+pokemon1.dodged+" stunned:"+pokemon1.stunned);
            new MyLogger().myLog(pokemon2.name + " HP:"+pokemon2.hp+" dodged:"+pokemon2.dodged+" stunned:"+pokemon2.stunned);
            pokemon1.dodged = false;
            pokemon2.dodged = false;
            counter++;
        }

        if(pokemon1.hp > 0) {
            new MyLogger().myLog("\nWINNER: antrenorul1 with " + pokemon1.name);
            return 1;
        }
        if(pokemon2.hp > 0) {
            new MyLogger().myLog("\nWINNER: antrenorul2 with " + pokemon2.name);
            return 2;
        }

        new MyLogger().myLog("\nDRAW!");
        return 0;
    }
}
