package Scenes;

import Framework.Scene;
import Game.Bag;
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
        Bag bag = Bag.getInstance();
        bag.printBag();
    }
}
