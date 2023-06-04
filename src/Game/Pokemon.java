package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokemon {
    // 포켓몬의 정보를 받는 getInfo() 메서드, 매개변수로 포켓몬 객체와, csv 파일에서 해당 포켓몬을 찾을 수 있는 targetLine을 받음
        public static ArrayList<PokemonInfo> getInfo(){
            String csvFile = "etc/pokemonInformation.csv";
            // 포켓몬 csv 파일 경로
            String line;
            // targetLine을 찾아 들어가기 위한 변수
            String csvSplitBy = ",";
            // csv 파일에서 포켓몬 속성 간의 구분자

            ArrayList<PokemonInfo> list = new ArrayList<>();

            // csv 파일을 읽음
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(csvSplitBy);
                    PokemonInfo Pokemon = new PokemonInfo();
                    // 포켓몬 객체의 필드에 각각의 속성을 삽입
                    Pokemon.id = Integer.parseInt(fields[0]);
                    Pokemon.name = fields[1];
                    Pokemon.atk = Integer.parseInt(fields[2]);
                    Pokemon.def = Integer.parseInt(fields[3]);
                    Pokemon.hp = Integer.parseInt(fields[4]);
                    Pokemon.maxHp = Pokemon.hp;
                    Pokemon.type = fields[5];
                    Pokemon.skill1 = fields[6];
                    Pokemon.skill2 = fields[7];
                    Pokemon.level = Integer.parseInt(fields[8]);
                    Pokemon.exp = Integer.parseInt(fields[9]);
                    Pokemon.status = Integer.parseInt(fields[10]);
                    list.add(Pokemon);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }

}
