package Scenes;

import Define.ITEM_TYPE;
import Framework.Scene;
import Item.Item;
import Mng.GameMng;
import Game.Shop;
import Game.Bag;

public class ShopScene extends Scene {

    @Override
    public void Update(){
        super.Update();
        int inputData = GameMng.getInstance().scanner.nextInt();
        switch(inputData){
            case 0: GameMng.getInstance().ChangeState(new MenuScene());
                    Bag.getInstance().saveData();
            break;
            case 1: BuyItem(ITEM_TYPE.NORMAL_HEAL); break;
            case 2: BuyItem(ITEM_TYPE.EPIC_HEAL); break;
            case 3: BuyItem(ITEM_TYPE.NORMAL_BALL); break;
            case 4: BuyItem(ITEM_TYPE.SUPER_BALL); break;
            case 5: BuyItem(ITEM_TYPE.HYPER_BALL); break;
            case 6: BuyItem(ITEM_TYPE.MASTER_BALL); break;
            default: /*잘못된 입력*/ break;
        }
    }
    @Override
    public void Draw(){
        super.Draw();
        System.out.println("현재 보유 코인 : " + Bag.getInstance().getCoin());
        System.out.println("0. 뒤로가기");
        System.out.println("1. 일반 회복약\t포켓몬의 체력을 20 회복시킵니다.\t200coin");
        System.out.println("2. 고급 회복약\t포켓몬의 체력을 50 회복시킵니다.\t500coin");
        System.out.println("3. 몬스터볼\t특별한 캐치율을 제공하는 특수한 볼입니다.\t300coin");
        System.out.println("4. 슈퍼볼\t표준 포켓볼보다 높은 캐치율을 제공하는 좋은 고성능 볼입니다.\t500coin");
        System.out.println("5. 하이퍼볼\t슈퍼볼보다 높은 캐치율을 제공하는 고성능 볼입니다.\t1000coin");
        System.out.println("6. 마스터볼\t최고 수준의 성능을 가진 최상의 포켓볼입니다.\t2000coin");
    }

    void BuyItem(ITEM_TYPE type)
    {
        Item item = Bag.getInstance().GetItem(type);

        if(item.getPrice() <= Bag.getInstance().getCoin())
        {
            Bag.getInstance().addItem(type);
            Bag.getInstance().deductCoin(item.getPrice());
            System.out.println(item.getName()+"을(를) 구매하였습니다.");
        }else {
            System.out.println("돈이 부족하여 " + item.getName()+"을(를) 구매할 수 없습니다.");
        }
    }
}
