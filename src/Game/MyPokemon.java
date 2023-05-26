package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyPokemon {
    private static void getInfo(PokemonInfo Pokemon, int targetLine){
        String csvFile = "/Users/ihan-eum/Downloads/MyPokemon.csv";
        String line;
        String csvSplitBy = ",";
        int lineCnt = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(lineCnt == targetLine) {
                    String[] fields = line.split(csvSplitBy);

                    Pokemon.name = fields[1];
                    Pokemon.atk = Integer.parseInt(fields[2]);
                    Pokemon.def = Integer.parseInt(fields[3]);
                    Pokemon.hp = Integer.parseInt(fields[4]);
                    Pokemon.type = fields[5];
                    Pokemon.skill1 = fields[6];
                    Pokemon.skill2 = fields[7];
                    Pokemon.level = Integer.parseInt(fields[8]);
                    Pokemon.exp = Integer.parseInt(fields[9]);
                    Pokemon.status = Integer.parseInt(fields[10]);
                }
                lineCnt++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PokemonInfo[] MyPokemon(){
        PokemonInfo[] MyPokemon = new PokemonInfo[28];
        for (int i = 0; i < MyPokemon.length; i++) {
            MyPokemon[i] = new PokemonInfo();
            getInfo(MyPokemon[i], i+1);
        }
        return MyPokemon;
    }
}
