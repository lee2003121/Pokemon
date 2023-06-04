package Game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class SavePokemon {

    public void myPokemon(ArrayList<PokemonInfo> newList) {
        String csvFile = "etc/MyPokemon.csv"; // CSV 파일 경로 및 파일명

        // CSV 파일 읽기
        ArrayList<PokemonInfo> myList = MyPokemon.getInfo();

        // 기존 데이터에 새로운 데이터 덮어쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (int i = 0; i < myList.size(); i++) {
                PokemonInfo data = myList.get(i);

                String[] rowData = new String[12];
                rowData[0] = Integer.toString(i+1);
                rowData[1] = data.name;
                rowData[2] = Integer.toString(data.atk);
                rowData[3] = Integer.toString(data.def);
                rowData[4] = Integer.toString(data.hp);
                rowData[5] = Integer.toString(data.maxHp);
                rowData[6] = data.type;
                rowData[7] = data.skill1;
                rowData[8] = data.skill2;
                rowData[9] = Integer.toString(data.level);
                rowData[10] = Integer.toString(data.exp);
                rowData[11] = Integer.toString(data.status);

                writer.write(String.join(",", rowData));
                writer.newLine();
            }
            System.out.println("CSV 파일이 성공적으로 덮어쓰여졌습니다.");
        } catch (IOException e) {
            System.out.println("CSV 파일을 덮어쓰는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}


