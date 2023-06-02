package Scenes;

import Framework.Scene;
import Game.Bag;
import Game.character;
import Mng.GameMng;

public class BagScene extends Scene {
    @Override
    public void Update()
    {
        super.Update();
        if(GameMng.getInstance().scanner.nextInt() == 0){
            GameMng.getInstance().ChangePrevScene();
        }
        else if(GameMng.getInstance().scanner.nextInt() >= Bag.getInstance().getNowItemCount()){
            System.out.println("잘못된 입력입니다.");
            Draw();
            return;
        }
        else {
            // 아이템 사용처리
        }
    }

    @Override
    public void Draw() {
        super.Draw();
        System.out.println("0. 뒤로가기");
        Bag.getInstance().printBag();
    }
}
