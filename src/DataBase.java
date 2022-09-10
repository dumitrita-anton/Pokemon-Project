import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataBase {
    ArrayList<Pokemon> allPokemons;
    ArrayList<Item> allItems;


    //dessign pattern 2 - Singleton
    private static final DataBase instance = new DataBase();

    public static DataBase getInstance() {
        return instance;
    }

    public void ReadPokemons(String fileName){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            allPokemons = new Gson().fromJson(reader, new TypeToken<ArrayList<Pokemon>>() {}.getType());
            reader.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error at reading pokemons from file.");
        }
    }

    public void ReadItems(String fileName){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            allItems = new Gson().fromJson(reader, new TypeToken<ArrayList<Item>>() {}.getType());
            reader.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error at reading items from file.");
        }
    }

    public Pokemon searchPokemon(String name) {

        for(Pokemon pokemon : allPokemons) {
            if(pokemon.name.equals(name)) {
                return pokemon;
            }
        }
        new MyLogger().myLog("Pokemon does not exist");
        return null;
    }

    public Item searchItem(String name) {

        for(Item item : allItems) {
            if(item.name.equals(name)) {
                return item;
            }
        }
        new MyLogger().myLog("Pokemon does not exist");
        return null;
    }

    public void AddPokemon(Pokemon pokemon){
        allPokemons.add(pokemon);
    }
    public void AddItem(Item item){
        allItems.add(item);
    }
}
