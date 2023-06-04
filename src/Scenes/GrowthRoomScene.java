package Scenes;

import Framework.Scene;
import Game.GrowthRoom;
import Game.PokemonInfo;
import Mng.GameMng;
import Game.character;

import java.util.List;

public class GrowthRoomScene extends Scene{
    @Override
    public void Update(){
        super.Update();
        int inputData = GameMng.getInstance().scanner.nextInt();
        if(inputData == 0){
            GameMng.getInstance().ChangePrevScene();
            return;
        }
        else if(inputData == GrowthRoom.getInstance().getPokemonCount() + 1){
            List<PokemonInfo> list = character.getInstance().MyPokemonList;
            Dictionary.showDictionary();
            System.out.print("포켓몬을 선택하세요 : ");
            int inputData2 = GameMng.getInstance().scanner.nextInt();
            for(var p: list)
            {
                if(p.id == inputData2) {
                    GrowthRoom.getInstance().addGrowthPokemon(p);
                    return;
                }
            }
            System.out.println("잘못된 입력입니다.");
        }
        else{
            GrowthRoom.getInstance().takeGrowthPokemon(inputData);
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
        System.out.println((GrowthRoom.getInstance().getPokemonCount() + 1) + ". 포켓몬을 성장의 방에 두기");
    }
}
