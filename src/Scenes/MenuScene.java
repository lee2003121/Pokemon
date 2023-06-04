package Scenes;

import Framework.Scene;
import Game.Bag;
import Game.character;
import Mng.GameMng;

public class MenuScene extends Scene {
    @Override
    public  void Update()
    {
        super.Update();
        switch (GameMng.getInstance().scanner.nextInt())
        {
            case 1:
                GameMng.getInstance().ChangeState(new FightScene());
                break;
            case 2:
                GameMng.getInstance().ChangeState(new CollectionScene());
                break;
            case 3:
                GameMng.getInstance().ChangeState(new BagScene());
                break;
            case 4:
                GameMng.getInstance().ChangeState(new ShopScene());
                break;
            case 5:
                GameMng.getInstance().ChangeState(new RecoveryScene());
                break;
            case 6:
                GameMng.getInstance().ChangeState(new GrowthRoomScene());
                break;
            case 7:
                GameMng.getInstance().ChangeState(new Dictionary());
                break;
            case 8:
                Bag.getInstance().saveData();
                character.getInstance().saveData();
                System.exit(0);
                break;
        }
    }

    @Override
    public void Draw() {
        super.Draw();
        System.out.println("1. 대전모드");
        System.out.println("2. 수집모드");
        System.out.println("3. 가방");
        System.out.println("4. 상점");
        System.out.println("5. 회복 센터");
        System.out.println("6. 성장의 방");
        System.out.println("7. 도감");
        System.out.println("8. 나가기");
    }
}
