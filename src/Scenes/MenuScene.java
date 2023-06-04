package Scenes;

import Framework.Scene;
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
                System.exit(0);
                break;
        }
    }

    @Override
    public void Draw() {
        super.Draw();
        System.out.println("1. FIGHT");
        System.out.println("2. COLLECTION");
        System.out.println("3. BAG");
        System.out.println("4. SHOP");
        System.out.println("5. Recovery");
        System.out.println("6. GROWTHROOM");
        System.out.println("7. QUIT");
    }
}
