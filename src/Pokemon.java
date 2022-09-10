import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Pokemon implements Runnable{
        String name;
     Integer hp;
     Attack attack;
     Integer defense;
     Integer specialDefense;
     Ability1 ability1;
     Ability2 ability2;
     ArrayList<Item> items = new ArrayList<>();

     boolean dodged;
     boolean stunned;

    public Pokemon() {
    }

    public Pokemon(Pokemon builder) {
        this.name = builder.name;
        this.hp = builder.hp;
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.specialDefense = builder.specialDefense;
        this.ability1 = builder.ability1;
        this.ability2 = builder.ability2;
    }

    //All getter, and NO setter to provde immutability
    public String getName() {
        return name;
    }

    public Integer getHp() {
        return hp;
    }

    public Attack getAttack() {
        return attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public Ability1 getAbility1() {
        return ability1;
    }

    public Ability2 getAbility2() {
        return ability2;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    //special attributes to help the fight implementation
    public Pokemon pokemonFighting;

    public Pokemon getPokemonFighting() {
        return pokemonFighting;
    }

    public void setPokemonFighting(Pokemon pokemonFighting) {
        this.pokemonFighting = pokemonFighting;
    }

    //method to update pokemon points after fight
    public void addPoints(){
        hp++;
        if(attack.normalAttack != 0)
            attack.normalAttack++;
        else
            attack.specialAttack++;
        defense++;
        specialDefense++;
    }

    //method that calculate all current points of pokemon
    public int points() {
        return hp + attack.normalAttack + attack.specialAttack + defense +
                specialDefense;
    }

    public void updateAbilities(){
        if(ability1 != null && ability1.charged > 0)
            ability1.charged--;
        if(ability2 != null && ability2.charged > 0)
            ability2.charged--;
    }

    public void updatePointsItems(){
        for(Item item: this.items) {
            hp += item.getHp();
            if (attack.normalAttack != 0)
                attack.normalAttack += item.getAttack().normalAttack;
            else
                attack.specialAttack += item.getAttack().specialAttack;
            defense += item.getDefense();
            specialDefense += item.getSpecialDefense();
        }
    }
    public int choice;

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public void run() {
        Action[] listOfOrders = new Action[3];
        listOfOrders[0] = attack;
        listOfOrders[1] = ability1;
        listOfOrders[2] = ability2;

        choice = (int)(random() * 3);
        if(listOfOrders[choice] == null)
            choice = 0;

        if(!stunned)
            this.dodged = listOfOrders[choice].isDodge();

        if(!stunned){
            listOfOrders[choice].execute(this);
        }else {
            new MyLogger().myLog(name + " stunned");
            stunned = false;
        }

        updateAbilities();
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
