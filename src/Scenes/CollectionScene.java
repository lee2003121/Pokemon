package Scenes;

import Framework.Scene;
import Game.Bag;
import Mng.GameMng;

public class CollectionScene extends Scene {

    @Override
    public void Start() {
        if(true)
        {
            System.out.println("포켓몬을 찾기 시작합니다.");
        }else {
            System.out.println("포켓볼이 없어서 메뉴 화면으로 돌아갑니다.");
            GameMng.getInstance().ChangeState(new MenuScene());
        }
    }

    @Override
    public void Update() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int rand = GameMng.getInstance().GetRandom().nextInt(101);

        if(rand > 80)
        {
            System.out.println("포켓몬을 발견하였습니다.");

        }else {
            System.out.println("포켓몬을 발견하지 못했습니다. 다시 찾습니다..");
        }
    }
}
