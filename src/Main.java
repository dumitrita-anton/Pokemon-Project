import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new java.io.File("output1.txt");
        DataBase data = DataBase.getInstance();
        data.ReadPokemons("pokemoni.json");
        data.ReadItems("items.json");

//        Pokemon pokemon = new PokemonBuilder()
//                .Name("Gyarados").hp(90)
//                .withAttack(new Attack(0, 7))
//                .withDefense(6)
//                .withSpecialDefenses(6)
//                .withAbilities(new Ability1(7, true, false, 5),
//                        new Ability2(6, false, false, 4)).build();
//
//        data.AddPokemon(pokemon);
//        Pokemon neutrel = new Pokemon(data.allPokemons.get(2));



        //System.out.println(neutrel1.getName() + neutrel1.hp.toString());
        //System.out.println(neutrel2.getName() + neutrel2.getHp().toString());
        //System.out.println(neutrel.getName() + neutrel.getHp());

//        File test0 = new File("tests/test0.txt");
//        File test1 = new File("tests/test1.txt");
//        File test2 = new File("tests/test2.txt");
//        File test3 = new File("tests/test3.txt");
//        File test4 = new File("tests/test4.txt");
//        File test5 = new File("tests/test5.txt");
//        File test6 = new File("tests/test6.txt");
//        File test7 = new File("tests/test7.txt");
//        File test8 = new File("tests/test8.txt");
//        File test9 = new File("tests/test9.txt");
//
//        File out0 = new File("outputs/out0.txt");
//        File out1 = new File("outputs/out1.txt");
//        File out2 = new File("outputs/out2.txt");
//        File out3 = new File("outputs/out3.txt");
//        File out4 = new File("outputs/out4.txt");
//        File out5 = new File("outputs/out5.txt");
//        File out6 = new File("outputs/out6.txt");
//        File out7 = new File("outputs/out7.txt");
//        File out8 = new File("outputs/out8.txt");
//        File out9 = new File("outputs/out9.txt");


//        String [] test = new String[20];

//        try (BufferedReader br = new BufferedReader(new FileReader(test2))) {
//            String line;
//
//            for (int i = 0; (line = br.readLine()) != null; i++) {
//                test[i] = line;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        {
            Pokemon neutrel1 = new Pokemon(data.allPokemons.get(0));
            Pokemon neutrel2 = new Pokemon(data.allPokemons.get(1));
            Antrenor antrenor1 = new Antrenor();
            Antrenor antrenor2 = new Antrenor();

            ReadAntrenor br = new ReadAntrenor();
            br.Read(antrenor1, "Tests/Test1/antrenor1.txt", data);
            br.Read(antrenor2, "Tests/Test1/antrenor2.txt", data);

//        System.out.println(antrenor1.name + antrenor1.age);
//
//        for (Pokemon pokemonaux: antrenor1.pokemons) {
//            System.out.println(pokemonaux.getName());
//        }
            Adventure adventure = new Adventure(neutrel1, neutrel2);

            for (int j = 0; j < 3; j++) {
                Pokemon pokemon1 = antrenor1.pokemons.get(j);
                Pokemon pokemon2 = antrenor2.pokemons.get(j);

                pokemon1.updatePointsItems();
                pokemon2.updatePointsItems();

                adventure.start(pokemon1, pokemon2);
            }

            FightThread finalFight = new FightThread();
            Pokemon bestPokemon1 = antrenor1.maxPointPokemon();
            Pokemon bestPokemon2 = antrenor2.maxPointPokemon();


            finalFight.fight(bestPokemon1, bestPokemon2);


            new MyLogger().myLog("!FINAL BATTLE WINNER!");
        }
        }
}
