public class ContextEveniment {
    private final Strategy strategy;

    public ContextEveniment(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(Pokemon pokemon1, Pokemon pokemon2) {

            return strategy.fight(pokemon1, pokemon2);
    }
}
