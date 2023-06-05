package Scenes;

import Define.ITEM_TYPE;
import Framework.Scene;
import Game.Bag;
import Game.character;
import Item.Candy;
import Mng.GameMng;

public class BagScene extends Scene {
    @Override
    public void Update()
    {
        super.Update();
        int inputData = GameMng.getInstance().scanner.nextInt();
        if(inputData == 0){
            GameMng.getInstance().ChangePrevScene();
        }
        else if(isBattling()){ // 전투중 가방열기 -> 전투중인 포켓몬 회복 or 상대포켓몬 몬스터볼로 잡기
            if(inputData > Bag.getInstance().getNowItemCount()){
                System.out.println("잘못된 입력입니다.");
                return;
            }
            else {

            }
        }
        else { // 비전투중 가방열기 -> 소유중인 포켓몬중 회복 가능
            if(inputData > Bag.getInstance().getNowItemCount()){
                System.out.println("잘못된 입력입니다.");
                return;
            }
            else{
                // int inputData2 = GameMng.getInstance().scanner.nextInt();
                switch (inputData){
                    case 1: case 2: case 3: case 4: case 5: case 6:
                        System.out.println("비전투중에 사용할 수 없는 아이템입니다.");
                        break;
                    case 7:
                        try {
                            Candy item = (Candy)Bag.getInstance().GetItem(ITEM_TYPE.CANDY);

                            if(item.GetCount() > 0)
                            {
                                for(int i=0;i<character.getInstance().MyPokemonList.size();i++)
                                {
                                    System.out.println((i+1)+", " + character.getInstance().MyPokemonList.get(i).GetSmallInfo_Hp());
                                }
                                item.UseItem();
                                System.out.println("경험치를 올릴 포켓몬을 선택하세요");
                                int select = GameMng.getInstance().scanner.nextInt() - 1;
                                System.out.println(character.getInstance().MyPokemonList.get(select).name + "의 경험치를 10 증가 시켰습니다.");
                                character.getInstance().MyPokemonList.get(select).AddExp(10);
                            }else {
                                System.out.println("사탕이 없어 경험치를 올릴 수 없습니다.");
                            }
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                }
            }
        }
        Bag.getInstance().saveData();
    }

    @Override
    public void Draw() {
        super.Draw();
        System.out.println("0. 뒤로가기");
        Bag.getInstance().printBag();
    }
}
