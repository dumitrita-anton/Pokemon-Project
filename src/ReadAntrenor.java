import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadAntrenor {

    public void Read(Antrenor antrenor, String filename, DataBase data) {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            line = br.readLine();
            String[] field = line.split(" ");
            antrenor.setName(field[0]);
            int age = Integer.parseInt(field[1]);
            antrenor.setAge(age);

            line = br.readLine();
            String[] field1 = line.split(" ");
            ArrayList<Pokemon> pokemons = new ArrayList<>();

            for(int i = 0; i <3; i++){
                Pokemon pokemon = new Pokemon(data.searchPokemon(field1[i]));

                line = br.readLine();
                String[] field2 = line.split(" ");
                ArrayList<Item> items = new ArrayList<>();

                for(int j = 0; j < 3; j++)
                    items.add(data.searchItem(field2[j]));

                pokemon.setItems(items);
                pokemons.add(pokemon);
                antrenor.setPokemons(pokemons);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
