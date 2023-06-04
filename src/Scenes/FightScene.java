package Scenes;

import Framework.Scene;
import Game.MyPokemon;
import Game.Pokemon;
import Game.PokemonInfo;
import Mng.GameMng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightScene extends Scene {

    List<PokemonInfo> myPokemons;
    List<PokemonInfo> allPokemons;

    PokemonInfo playerSelectPokemon;
    List<PokemonInfo> fightPokemon;

    @Override
    public void Start() {
        super.Start();
        isBattling = true;
        myPokemons = MyPokemon.getInfo();
        allPokemons = Pokemon.getInfo();

        fightPokemon = new ArrayList<>();

        for(int i=0;i<3;i++)
        {
            fightPokemon.add(allPokemons.get(GameMng.getInstance().GetRandom().nextInt(allPokemons.size())));
        }

        MyPokemonSelect();

        //fightPokemon = ;
        //System.out.println("상대 포켓몬 : " + fightPokemon.GetSmallInfo_MaxHp());
        System.out.println("\n\n");
        System.out.println("전투를 시작합니다!");
        System.out.println("선공입니다.");
    }

    @Override
    public void Update() {

        int select = GameMng.getInstance().scanner.nextInt();

        System.out.println("=====메뉴를 선택하세요=====");
        System.out.println("1. 공격하기");
        System.out.println("2. 포켓몬 교체");
        System.out.println("3. 아이템 사용");
        System.out.println("4. 도망가기");

        switch (select)
        {
            case 1: //공격

                break;
            case 2: // 교체
                break;
            case 3: // 아이템 사용
                break;
            case 4: // 포기
                break;
        }

        System.out.println("1."+playerSelectPokemon.skill1);
        System.out.println("2."+playerSelectPokemon.skill2);
        System.out.print("스킬을 선택하세요 : ");

        int skill = GameMng.getInstance().scanner.nextInt();

        System.out.println(skill + "번 스킬 : "+ (skill == 1 ? playerSelectPokemon.skill1 : playerSelectPokemon.skill2) + "을 선택하였습니다.");
        boolean result = true;
        //result = playerSelectPokemon.Fight(fightPokemon);

        //결과창

        if(result)
        {
            ResultShow(playerSelectPokemon);
        }
        System.out.println("=======================");
        System.out.println("상대방이 공격할 차례이다\n");
        //result = fightPokemon.Fight(playerSelectPokemon);
        if(result)
        {
            //ResultShow(fightPokemon);
        }

    }

    void ResultShow(PokemonInfo winPokemon)
    {
        isBattling = false;
        System.out.println(winPokemon.name + "이(가) 승리했다!");

        winPokemon.AddExp(15);

        playerSelectPokemon.Init();
        //fightPokemon.Init();

        playerSelectPokemon = null;
        fightPokemon = null;

        System.out.println("========== 메뉴 선택 ==========");
        System.out.println("1. 새로운 전투");
        System.out.println("2. 메뉴화면으로");

        int select = GameMng.getInstance().scanner.nextInt();

        if (select == 2)
            GameMng.getInstance().ChangeState(new MenuScene());
        else if (select == 1) {
            System.out.println("새로운 전투를 시작합니다.");
        }
    }

    //플레이어가 사용할 포켓몬을 선택합니다.
    void MyPokemonSelect()
    {
        System.out.println("=====나의 포켓몬 목록======");
        for(int i=0;i<myPokemons.size();i++)
        {
            System.out.println((i + 1) + ". " + myPokemons.get(i).GetSmallInfo_MaxHp());
        }

        System.out.print("전투할 포켓몬의 번호를 입력하세요 : ");
        int index = GameMng.getInstance().scanner.nextInt();
        playerSelectPokemon = myPokemons.get(index - 1);
        System.out.println(playerSelectPokemon.name + "을(를) 선택하였습니다!");
    }
}
