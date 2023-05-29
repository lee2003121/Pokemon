package Scenes;

import Framework.Scene;
import Mng.GameMng;

public class MenuScene extends Scene {

    @Override
    public  void Update()
    {
        super.Update();
        switch (Integer.parseInt(inputData))
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
        System.out.println("4. QUIT");
    }
}
