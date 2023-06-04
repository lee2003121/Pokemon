package Scenes;

import Framework.Scene;
import Game.GrowthRoom;
import Game.PokemonInfo;
import Game.MyPokemon;
import Mng.GameMng;
import Game.Dictionary;
import java.util.ArrayList;

public class GrowthRoomScene extends Scene{
    @Override
    public void Update(){
        super.Update();
        int inputData = GameMng.getInstance().scanner.nextInt();
        if(inputData == 0){
            GameMng.getInstance().ChangePrevScene();
            return;
        }
        else if(0 < inputData && inputData < GrowthRoom.getInstance().getPokemonCount()){
            GrowthRoom.getInstance().takeGrowthPokemon(inputData);
        }
        else if(inputData == GrowthRoom.getInstance().getPokemonCount()){
            ArrayList<PokemonInfo> list = MyPokemon.getInfo();
            Dictionary.showDictionary();
            int inputData2 = GameMng.getInstance().scanner.nextInt();
            if(list.get(inputData2 - 1).name == null){
                System.out.println("잘못된 입력입니다.");
                this.Draw();
                return;
            }
            GrowthRoom.getInstance().addGrowthPokemon(list.get(inputData2 - 1));
        }
        else{
            System.out.println("잘못된 입력입니다.");
            this.Draw();
            return;
        }

    }

    @Override
    public void Draw(){
        super.Draw();
        System.out.println("포켓몬을 자동으로 성장시킬 수 있는 성장의 방 입니다.");
        System.out.println("최대 " + GrowthRoom.MAX_EXP + "경험치를 얻을 수 있습니다.");
        System.out.println("\n0. 뒤로가기");
        GrowthRoom.getInstance().printGrowthPokemon();
        System.out.println(GrowthRoom.getInstance().getPokemonCount() + ". 포켓몬을 성장의 방에 두기");
    }
}