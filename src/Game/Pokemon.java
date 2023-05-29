package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Pokemon {
    // 포켓몬의 정보를 받는 getInfo() 메서드, 매개변수로 포켓몬 객체와, csv 파일에서 해당 포켓몬을 찾을 수 있는 targetLine을 받음
    public static void getInfo(PokemonInfo Pokemon, int targetLine){
        String csvFile = "https://github.com/lee2003121/Pokemon/blob/main/etc/pokemonInformation.csv";
        // 포켓몬 csv 파일 경로
        String line;
        // targetLine을 찾아 들어가기 위한 변수
        String csvSplitBy = ",";
        // csv 파일에서 포켓몬 속성 간의 구분자
        int lineCnt = 0;
        // targetLine을 찾아 들어가기 위한 변수

        // csv 파일을 읽음
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // 찾아들어간 라인이 targetLine과 일치하면
                if(lineCnt == targetLine) {
                    String[] fields = line.split(csvSplitBy);
                    // 포켓몬 객체의 필드에 각각의 속성을 삽입
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

    // 포켓몬 정보를 저장하는 포켓몬 객체 배열 생성 메서드 generatePokemon() 메서드
    public static PokemonInfo[] generatePokemon(){
        // 포켓몬 객체 배열 (포켓몬은 총 28개가 있다)
        PokemonInfo[] Pokemon = new PokemonInfo[28];
        for (int i = 0; i < Pokemon.length; i++) {
            Pokemon[i] = new PokemonInfo();
            // getInfo() 메서드로 각 포켓몬의 정보를 받음
            getInfo(Pokemon[i], i+1);
        }
        // 포켓몬 객체 배열 반환
        return Pokemon;
    }

}
