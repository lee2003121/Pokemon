package Scenes;

import Framework.Scene;

public class MenuScene extends Scene {

    @Override
    public  void Update()
    {
        super.Update();
        switch (Integer.parseInt(inputData))
        {
            case 1:
                //전투 씬으로 이동
                break;
            case 2:
                //수집 씬으로 이동
                break;
            case 3:
                //가방 씬으로 이동
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
