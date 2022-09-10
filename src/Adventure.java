import static java.lang.Math.random;

public class Adventure {
    private final Pokemon neutrel1;
    private final Pokemon neutrel2;

    public Adventure(Pokemon neutrel1, Pokemon neutrel2) {
        this.neutrel1 = neutrel1;
        this.neutrel2 = neutrel2;
    }

    public void start (Pokemon pokemon1, Pokemon pokemon2) {
        int i = -1;
        ContextEveniment fight = new ContextEveniment(new FightPokemonVsNeutrels());
        new MyLogger().myLog(pokemon1.name + " vs" + pokemon2.name);



        while (i != 0){
            i = (int)(random() * 3);

            if (i == 2) {
                updatePoints(fight.executeStrategy(pokemon1, neutrel2), pokemon1, neutrel2);
                updatePoints(fight.executeStrategy(pokemon2, neutrel2), pokemon2, neutrel2);
            }

            if (i == 1) {
                updatePoints(fight.executeStrategy(pokemon1, neutrel1), pokemon1, neutrel1);
                updatePoints(fight.executeStrategy(pokemon2, neutrel1), pokemon2, neutrel1);
            }

            if (i == 0) {
                fight = new ContextEveniment(new FightThread());
                updatePoints(fight.executeStrategy(pokemon1, pokemon2), pokemon1, pokemon2);
            }

        }
    }

    public void updatePoints(int choice, Pokemon pokemon1, Pokemon pokemon2){
        if(choice == 1)
            pokemon1.addPoints();
        if(choice == 2)
            pokemon2.addPoints();
    }
}


