package Scenes;

import Framework.Scene;
import Mng.GameMng;
import Game.Shop;
import Game.Bag;

public class ShopScene extends Scene {

    @Override
    public void Update(){
        Shop shop = new Shop(Bag.getInstance());
        super.Update();
        int inputData = GameMng.getInstance().scanner.nextInt();
        switch(inputData){
            case 0: /*뒤로가기*/ break;
            case 1: shop.buyPotion(); break;
            case 2: shop.buyAdvancedPotion(); break;
            case 3: shop.buyMonsterBall(); break;
            case 4: shop.buySuperBall(); break;
            case 5: shop.buyHyperBall(); break;
            case 6: shop.buyMasterBall(); break;
            default: /*잘못된 입력*/ break;
        }
    }
    @Override
    public void Draw(){
        super.Draw();
        System.out.println("0. 뒤로가기");
        System.out.println("1. 일반 회복약\t포켓몬의 체력을 20 회복시킵니다.\t200coin");
        System.out.println("2. 고급 회복약\t포켓몬의 체력을 50 회복시킵니다.\t500coin");
        System.out.println("3. 몬스터볼\t특별한 캐치율을 제공하는 특수한 볼입니다.\t300coin");
        System.out.println("4. 슈퍼볼\t표준 포켓볼보다 높은 캐치율을 제공하는 좋은 고성능 볼입니다.\t500coin");
        System.out.println("5. 하이퍼볼\t슈퍼볼보다 높은 캐치율을 제공하는 고성능 볼입니다.\t1000coin");
        System.out.println("6. 마스터볼\t최고 수준의 성능을 가진 최상의 포켓볼입니다.\t2000coin");
    }
}
