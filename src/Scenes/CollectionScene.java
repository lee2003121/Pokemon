package Scenes;

import Framework.Scene;
import Game.Bag;
import Mng.GameMng;

import java.util.ArrayList;
import Game.MyPokemon;
import Game.Pokemon;
import Game.PokemonInfo;
import Game.Dictionary;
import java.util.Scanner;

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
//            System.out.println("포켓볼이 없어서 메뉴 화면으로 돌아갑니다.");
            GameMng.getInstance().ChangeState(new MenuScene());
        }
    }

    public boolean hasBall(){
        if(true){

            return false;
        }
        return true;
    }

    public boolean isFullPokemon(){

        return myPokemon.size() < 10;
    }

    public void askRemove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보유한 포켓몬을 버리시겠습니까? (y/n)");
        String yn = scanner.nextLine();
        if(yn.equals("y")){
            Dictionary.showDictionary();
            System.out.println("버릴 포켓몬의 ID를 입력하세요.");
            int id = scanner.nextInt();
            myPokemon.remove(id);
            collectPokemon();
        }else if(yn.equals("n")){
            System.out.println("수집을 포기합니다.");
        }
    }

    public void getDictionary(){

    }

    public void selectFightPokemon(){

    }

    public void collectPokemon(){
        if(!hasBall()){
            System.out.println("몬스터 볼이 없습니다.");
        }else if(!isFullPokemon()){
            System.out.println("더 이상 포켓몬을 수집할 수 없습니다.");
            askRemove();
        }else{
            // 내가 갖고 있는 몬스터볼 선택
            // 확률적으로 수집 가능할 수도 안될 수도
        }
    }

    public void runMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : 수집하기");
        System.out.println("2 : 도감보기");
        System.out.println("3 : 대전 포켓몬 선택하기");
        System.out.println("종료하려면 아무 키나 입력");
        int menu = scanner.nextInt();

        switch (menu) {
            case 1 :
                collectPokemon();
            case 2 :
                getDictionary();
            case 3:
                selectFightPokemon();
            default:

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

        allPokemon = getAllPokemon();
        myPokemon = getMyPokemon();

        if(rand <= 28)
        {
            PokemonInfo wildPokemon = getPokemon(rand);
            System.out.println("야생 " + wildPokemon.name + "이(가) 나타났다!");
            runMenu();
        }else {
            System.out.println("포켓몬을 발견하지 못했습니다. 다시 찾습니다..");
        }
    }
}
