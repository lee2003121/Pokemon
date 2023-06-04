package Scenes;

import Define.ITEM_TYPE;
import Framework.Scene;
import Game.Bag;
import Item.Item;
import Mng.GameMng;

import java.util.ArrayList;

public class CollectionScene extends Scene {

    @Override
    public void Start() {

        if(Bag.getInstance().HavePokeball())
        {
            System.out.println("포켓몬을 찾기 시작합니다.");
        }else {
            System.out.println("포켓볼이 없어서 메뉴 화면으로 돌아갑니다.");
            GameMng.getInstance().ChangeState(new MenuScene());
        }
    }

    @Override
    public void Update() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int rand = GameMng.getInstance().GetRandom().nextInt(101);

        if(rand > 80)
        {
            System.out.println("포켓몬을 발견하였습니다.");

            System.out.println("사용할 몬스터 볼을 선택하세요.");

            ArrayList<Item> itemList = new ArrayList<Item>();

            itemList.add(Bag.getInstance().GetItem(ITEM_TYPE.NORMAL_BALL));
            itemList.add(Bag.getInstance().GetItem(ITEM_TYPE.HYPER_BALL));
            itemList.add(Bag.getInstance().GetItem(ITEM_TYPE.EPIC_HEAL));
            itemList.add(Bag.getInstance().GetItem(ITEM_TYPE.MASTER_BALL));

            for(int i = 0; i<itemList.size();i++)
            {
                System.out.println("");
            }

        }else {
            System.out.println("포켓몬을 발견하지 못했습니다. 다시 찾습니다..");
        }
    }
}
