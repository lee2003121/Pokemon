package Scenes;

import Define.ITEM_TYPE;
import Framework.Scene;
import Game.*;
import Item.*;
import Mng.GameMng;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightScene extends Scene {
    PokemonInfo playerSelectPokemon;
    List<PokemonInfo> fightPokemon;

    @Override
    public void Start() {
        super.Start();

        if(IsFightState() == false)
        {
            System.out.println("전투에 사용할 포켓몬이 없어 대전 포켓몬을 설정해 주세요.");
            GameMng.getInstance().ChangeState(new MenuScene());
            return;
        }

        isBattling = true;
        fightPokemon = new ArrayList<>();

        System.out.println("=====상대 포켓몬=====");

        for(int i=0;i<3;i++)
        {
            fightPokemon.add(GameMng.getInstance().AllPokemons.get(GameMng.getInstance().GetRandom().nextInt(GameMng.getInstance().AllPokemons.size())));
            fightPokemon.get(i).Init();
            System.out.println((i + 1) + ". " + fightPokemon.get(i).GetSmallInfo_Hp());
        }

        MyPokemonSelect();
;
        System.out.println("\n전투를 시작합니다!");
        System.out.println("선공입니다.");
    }

    @Override
    public void Update() {
        System.out.println("\n=====메뉴를 선택하세요=====");
        System.out.println("1. 공격하기");
        System.out.println("2. 포켓몬 교체");
        System.out.println("3. 아이템 사용");
        System.out.println("4. 도망가기");

        int select = GameMng.getInstance().scanner.nextInt();

        boolean result;
        switch (select)
        {
            case 1: //공격
                System.out.println("1."+ playerSelectPokemon.skill1);
                System.out.println("2."+ playerSelectPokemon.skill2);
                System.out.print("스킬을 선택하세요 : ");

                int skill = GameMng.getInstance().scanner.nextInt();

                System.out.println(skill + "번 스킬 : "+ (skill == 1 ? playerSelectPokemon.skill1 : playerSelectPokemon.skill2) + "을 선택하였습니다.");
                result = playerSelectPokemon.Fight(fightPokemon.get(0));

                if(result)
                {
                    MyPokemonResult();
                }
                break;
            case 2: // 교체
                System.out.println("포켓몬을 교체합니다.");
                MyPokemonSelect();
                break;
            case 3: // 아이템 사용
                if(Bag.getInstance().HaveHeal() == false)
                {
                    System.out.println("사용할 수 있는 아이템이 존재하지 않습니다.");
                    return;
                }
                else {
                    ItemUse();
                }
                break;
            case 4: // 포기
                System.out.println("도망가서 전투를 종료합니다. 메뉴 화면으로 이동합니다.");
                GameMng.getInstance().ChangeState(new MenuScene());
                return;
        }

        //상대방 전투 로직
        System.out.println("=======================");
        System.out.println("상대방이 공격할 차례이다");
        result = fightPokemon.get(0).Fight(playerSelectPokemon);


        if(result)
            FightPokemonResult();

    }

    void GameOver()
    {
        if(IsFightState() == false)
        {
            System.out.println("더이상 전투를 할 수 있는 포켓몬이 없어 메뉴 화면으로 돌아갑니다.");
            GameMng.getInstance().ChangeState(new MenuScene());
        }else {
            System.out.println("========== 메뉴 선택 ==========");
            System.out.println("1. 새로운 전투");
            System.out.println("2. 메뉴화면으로");

            int select = GameMng.getInstance().scanner.nextInt();

            if (select == 2)
                GameMng.getInstance().ChangeState(new MenuScene());
            else if (select == 1) {
                System.out.println("새로운 전투를 시작합니다.");
                GameMng.getInstance().ChangeState(new FightScene());
            }
        }
    }

    void MyPokemonResult()
    {
        fightPokemon.remove(0);
        if(fightPokemon.size() == 0)
        {
            System.out.println("플레이어가 승리하였습니다!");
            for(int i=0;i<character.getInstance().FightPokemonList.size();i++)
            {
                character.getInstance().FightPokemonList.get(i).AddExp(GameMng.getInstance().GetRandom().nextInt(10,20));
            }

            Bag.getInstance().addCoin(300);
            Bag.getInstance().addItem(ITEM_TYPE.CANDY);

            GameOver();
        }
        else {
            System.out.println("상대방이 " + fightPokemon.get(0).name + "을(를) 소환했습니다.");
        }
    }

    void FightPokemonResult()
    {
        if(IsFightState())
        {
            MyPokemonSelect();
            return;
        }

        System.out.println("플레이어가 패배하였습니다...");
        for(int i=0;i<character.getInstance().FightPokemonList.size();i++)
        {
            character.getInstance().FightPokemonList.get(i).AddExp(GameMng.getInstance().GetRandom().nextInt(5,10));
        }
        Bag.getInstance().addCoin(100);
        GameOver();
    }

    boolean IsFightState()  //현재 플레이어 포켓몬 중에서 전투가 가능한 상태인지, True면 전투 가능한 포켓몬 최소 1개 이상 존재, false면 없음
    {
        for(int i=0;i<character.getInstance().GetFightPokemonList().size();i++)
        {
            if(character.getInstance().GetFightPokemonList().get(i).status == 1)
            {
                return true;
            }
        }

        return false;
    }

    //플레이어가 사용할 포켓몬을 선택합니다.
    void MyPokemonSelect()
    {
        while (true)
        {
            System.out.println("=====나의 포켓몬 목록======");
            for(int i=0;i< character.getInstance().GetFightPokemonList().size();i++)
            {
                System.out.println((i + 1) + ". " + character.getInstance().GetFightPokemonList().get(i).GetSmallInfo_MaxHp());
            }

            System.out.print("전투할 포켓몬의 번호를 입력하세요 : ");
            int index = GameMng.getInstance().scanner.nextInt();
            playerSelectPokemon = character.getInstance().GetFightPokemonList().get(index - 1);

            if(playerSelectPokemon.status == 1)
                break;
            else
                System.out.println("기절한 포켓몬입니다. 다시 선택해 주세요.");
        }

        System.out.println(playerSelectPokemon.name + "을(를) 선택하였습니다!");
    }

    void ItemUse()
    {
        List<Item> myItemList = new ArrayList<Item>();

        for(int i=0;i<Bag.getInstance().GetItemList().size();i++)
        {
            Item curItem = Bag.getInstance().GetItemList().get(i);
            if((curItem.getType() == ITEM_TYPE.EPIC_HEAL || curItem.getType() == ITEM_TYPE.NORMAL_HEAL) && curItem.GetCount() > 0)
                myItemList.add(curItem);
        }

        System.out.println("=====사용할 아이템을 선택하세요.=====");
        for(int i=0;i<myItemList.size();i++)
        {
            System.out.println((i + 1) + ". " + myItemList.get(i));
        }

        int select = GameMng.getInstance().scanner.nextInt();

        myItemList.get(select - 1).UseItem();

        int amount = ((HealingItem)myItemList.get(select - 1)).getHealingPower();
        playerSelectPokemon.hp += amount;

        if(playerSelectPokemon.hp > playerSelectPokemon.maxHp)
            playerSelectPokemon.hp = playerSelectPokemon.maxHp;

        System.out.println("HP " + amount+"만큼 회복하였습니다!");
    }
}
