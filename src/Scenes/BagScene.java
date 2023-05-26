package Scenes;

import Framework.Scene;
import Game.Bag;
import Game.character;
public class BagScene extends Scene {
    @Override
    public  void Update()
    {
        super.Update();
        if(Integer.parseInt(inputData) == 0){//뒤로가기
        }
        else if(Integer.parseInt(inputData) >= Bag.getInstance().getNowItemCount()){
            // 잘못된 입력
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
