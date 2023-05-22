import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PokemonInfo{
    String name;
    String type;
    String skil1;
    String skil2;
    int hp;
    int atk;
    int def;
    int level;
    int exp;
    int status;
}

public class Pokemon {

    public static void getInfo(PokemonInfo Pokemon, int targetLine){
        String csvFile = "/Users/ihan-eum/Downloads/pokemonInformation.csv";
        String line;
        String csvSplitBy = ",";
        int lineCnt = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(lineCnt == targetLine) {
                    String[] fields = line.split(csvSplitBy);

                    // 필드 값을 활용하여 필요한 작업 수행
                    Pokemon.name = fields[1];
                    Pokemon.atk = Integer.parseInt(fields[2]);
                    Pokemon.def = Integer.parseInt(fields[3]);
                    Pokemon.hp = Integer.parseInt(fields[4]);
                    Pokemon.type = fields[5];
                    Pokemon.skil1 = fields[6];
                    Pokemon.skil2 = fields[7];
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

    public static void generatePokemon(){
        PokemonInfo[] Pokemon = new PokemonInfo[28];
        for (int i = 0; i < Pokemon.length; i++) {
            Pokemon[i] = new PokemonInfo();
            getInfo(Pokemon[i], i+1);
        }
    }

}
