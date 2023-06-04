package Scenes;

import Framework.Scene;
import Game.Bag;
import Mng.GameMng;

import java.util.ArrayList;
import Game.MyPokemon;
import Game.Pokemon;
import Game.PokemonInfo;

public class CollectionScene extends Scene {

    private ArrayList<PokemonInfo> allPokemon;
    private ArrayList<PokemonInfo> myPokemon;

    private ArrayList<PokemonInfo> getAllPokemon(){
        return Pokemon.getInfo();
    }

    private ArrayList<PokemonInfo> getMyPokemon(){
        return MyPokemon.getInfo();
    }

    private PokemonInfo getPokemon(int id){
        return allPokemon.get(id);
    }

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

    public boolean hasBall(){
        if(true){
            System.out.println("몬스터 볼이 없습니다.");
            return false;
        }
        return true;
    }

    public boolean isFullPokemon(){
        if(myPokemon.size() >= 10) {
            System.out.println("더 이상 포켓몬을 수집할 수 없습니다.");
            return false;
        }
        return true;
    }

    public void askRemove(){

    }

    public void getDictionary(){

    }

    public void selectFightPokemon(){

    }

    @Override
    public void Update() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int rand = GameMng.getInstance().GetRandom().nextInt(101);

        allPokemon = getAllPokemon();
        myPokemon = getMyPokemon();

        if(rand <= 28)
        {
            PokemonInfo wildPokemon = getPokemon(rand);
            System.out.println("야생 " + wildPokemon.name + "이(가) 나타났다!");

            if(hasBall() && isFullPokemon()){

            }else if(isFullPokemon()){
                askRemove();
            }

            getDictionary();
            selectFightPokemon();

            // 내가 몬스터볼이 없으면 중단
            // 더 이상 수집할 수 없으면 중단
            // 수집할 수 없으면 버릴 것인가
            // 도감 가져오기
            // 대전용 몬스터
        }else {
            System.out.println("포켓몬을 발견하지 못했습니다. 다시 찾습니다..");
        }
    }
}
