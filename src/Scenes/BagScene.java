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
        int inputData = GameMng.getInstance().scanner.nextInt();
        if(inputData == 0){
            GameMng.getInstance().ChangePrevScene();
        }
        else if(isBattling()){ // 전투중 가방열기 -> 전투중인 포켓몬 회복 or 상대포켓몬 몬스터볼로 잡기
            if(inputData > Bag.getInstance().getNowItemCount()){
                System.out.println("잘못된 입력입니다.");
                return;
            }
            else {

            }
        }
        else { // 비전투중 가방열기 -> 소유중인 포켓몬중 회복 가능
            if(inputData > Bag.getInstance().getNowItemCount()){
                System.out.println("잘못된 입력입니다.");
                return;
            }
            else{

            }
        }
        Bag.getInstance().saveData();
    }

    @Override
    public void Draw() {
        super.Draw();
        System.out.println("0. 뒤로가기");
        Bag.getInstance().printBag();
    }
}
