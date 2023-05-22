package Scenes;

import Framework.Scene;

public class MenuScene extends Scene {

    @Override
    public void Draw() {
        super.Draw();
        System.out.println("GOTO GAME");
        System.out.println("MENU");
        System.out.println("BAG");
        System.out.println("QUIT");
    }
}
