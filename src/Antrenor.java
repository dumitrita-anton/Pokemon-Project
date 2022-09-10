import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Antrenor {
    String name;
    Integer age;
    ArrayList <Pokemon> pokemons;

    public Antrenor() {
    }

    public Antrenor(String name, Integer age, ArrayList<Pokemon> pokemons) {
        this.name = name;
        this.age = age;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon maxPointPokemon() {
        int max = 0;
        Pokemon best = null;
        for (Pokemon pokemon : pokemons)
            if(pokemon.points() >= max) {
                best = pokemon;
                max = pokemon.points();
            }

        return best;
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
