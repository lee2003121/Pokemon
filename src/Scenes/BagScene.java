package Scenes;

import Framework.Scene;
import Game.character;
public class BagScene extends Scene {
    @Override
    public  void Update()
    {
        super.Update();
        switch (Integer.parseInt(inputData))
        {

        }
    }

    @Override
    public void Draw() {
        super.Draw();
        character player = character.getInstance();
        player.bag.Show_Recovery_Pills();
        player.bag.Show_MonsterBall();
        player.bag.Show_Candy();
    }
}
