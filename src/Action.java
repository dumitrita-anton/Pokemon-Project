//Dessign pattern 3 - Command

//interfata pentru executarea actiunii
public interface Action {
    void execute(Pokemon pokemon);
    boolean isDodge();
}

