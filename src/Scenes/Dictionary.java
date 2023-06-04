package Scenes;

import java.awt.*;
import java.util.List;

import Framework.Scene;
import Game.PokemonInfo;
import Game.character;
import Mng.*;
import Scenes.MenuScene;

public class Dictionary extends Scene {

    @Override
    public void Start()
    {
        printDictionary();
    }

    @Override
    public void Update() {
        System.out.println("메뉴 화면으로 돌아가려면 0을 누르세요.");
        int select = GameMng.getInstance().scanner.nextInt();
        if(select == 0)
        {
            GameMng.getInstance().ChangeState(new MenuScene());
        }
    }

    // 포켓몬 도감을 출력하는 printDictionary() 메서드
    public void printDictionary(){
        // MyPokemonList에 내가 보유한 포켓몬 객체 배열을 받음
        List<PokemonInfo> MyPokemonList = character.getInstance().MyPokemonList;
        List<PokemonInfo> allPokemonList = GameMng.getInstance().AllPokemons;
        // 도감에서 표를 출력하기 위한 tab 길이 지정 (\t는 너무 길었음)
        String tab = "   ";

        // 포켓몬 도감 표 헤더 출력 코드
        System.out.println("-----------------------------------------------------------------------------");
//        for(int i = 0; i < allPokemonList.size(); i++){
//            // name이 null 이면 즉, 보유한 포켓몬이 없으면 ??? 출력
//            if(MyPokemonList.size() > i){
//                for (int j = 0; j < 11; j++) System.out.format("%5s", tab + "???");
//            }else {
//                // 포켓몬 정보 출력
//                System.out.println(MyPokemonList.get(i).GetSmallInfo_Hp());
//            }
//            System.out.println();
//        }
        for (int i=0; i<MyPokemonList.size(); i++) {
            System.out.println(MyPokemonList.get(i).GetSmallInfo_Hp());
        }
        for (int i = 0; i < allPokemonList.size()-MyPokemonList.size(); i++) {
            System.out.println("???\t\t???\t\t???\t\t\t???\t\t???");
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
    public static void showDictionary(){
        // MyPokemonList에 내가 보유한 포켓몬 객체 배열을 받음
        List<PokemonInfo> MyPokemonList = character.getInstance().MyPokemonList;
        // 도감에서 표를 출력하기 위한 tab 길이 지정 (\t는 너무 길었음)
        String tab = "   ";

        // 포켓몬 도감 표 헤더 출력 코드
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
                "ID", "POKEMON", "TYPE", "SKILL1", "SKILL2", "HP", "ATTACK", "DEFENSE", "LEVEL", "EXP", "STATUS");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(int i = 0; i < MyPokemonList.size(); i++){
            // name이 null 이면 즉, 보유한 포켓몬이 없으면 ??? 출력
            if(MyPokemonList.get(i).name == null){
                continue;
            }else {
                // 포켓몬 정보 출력
                System.out.format("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
                        MyPokemonList.get(i).id, MyPokemonList.get(i).name, MyPokemonList.get(i).type, MyPokemonList.get(i).skill1, MyPokemonList.get(i).skill2, MyPokemonList.get(i).hp,
                        MyPokemonList.get(i).atk, MyPokemonList.get(i).def, MyPokemonList.get(i).level, MyPokemonList.get(i).exp, MyPokemonList.get(i).status);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}
