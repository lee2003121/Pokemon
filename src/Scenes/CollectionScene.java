package Scenes;

import Define.ITEM_TYPE;
import Framework.Scene;
import Game.Bag;
import Mng.GameMng;

import Item.*;
import java.util.ArrayList;
import Game.MyPokemon;
import Game.Pokemon;
import Game.PokemonInfo;
import Game.Dictionary;
import java.util.Scanner;
import Game.Bag;
import Item.Item;

public class CollectionScene extends Scene {

    private ArrayList<PokemonInfo> allPokemon;
    private ArrayList<PokemonInfo> myPokemon;
    private final Item monster = Bag.getInstance().GetItem(ITEM_TYPE.NORMAL_BALL);
    private final Item superBall = Bag.getInstance().GetItem(ITEM_TYPE.SUPER_BALL);
    private final Item hyper = Bag.getInstance().GetItem(ITEM_TYPE.HYPER_BALL);
    private final Item master = Bag.getInstance().GetItem(ITEM_TYPE.MASTER_BALL);

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
        System.out.println("포켓몬을 찾기 시작합니다.");
    }

    public boolean hasBall(){
        int count = monster.GetCount() + superBall.GetCount() + hyper.GetCount() + master.GetCount();
        return count > 0;
    }

    public boolean isFullPokemon(){
        return myPokemon.size() < 10;
    }

    public void askRemove(PokemonInfo wildPokemon){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보유한 포켓몬을 버리시겠습니까? (y/n)");
        String yn = scanner.nextLine();
        if(yn.equals("y")){
            Dictionary.showDictionary();
            System.out.println("버릴 포켓몬의 ID를 입력하세요.");
            int id = scanner.nextInt();
            myPokemon.remove(id);
            collectPokemon(wildPokemon);
        }else if(yn.equals("n")){
            System.out.println("수집을 포기합니다.");
        }
    }

    public void getDictionary(){

    }

    public void selectFightPokemon(){

    }

    public double selectBall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하는 몬스터볼의 ID를 입력하세요.");
        System.out.println("1 : 몬스터볼\t" + monster.GetCount() + "개");
        System.out.println("2 : 슈퍼볼\t" + superBall.GetCount() + "개");
        System.out.println("3 : 하이퍼볼\t" + hyper.GetCount() + "개");
        System.out.println("4 : 마스터볼\t" + master.GetCount() + "개");

        int id = scanner.nextInt();
        switch (id){
            case 1 :
                Bag.getInstance().useItem(ITEM_TYPE.NORMAL_HEAL);
                return ((PokeBall)monster).getCatchRate();
            case 2 :
                Bag.getInstance().useItem(ITEM_TYPE.SUPER_BALL);
                return ((PokeBall)superBall).getCatchRate();
            case 3 :
                Bag.getInstance().useItem(ITEM_TYPE.HYPER_BALL);
                return ((PokeBall)hyper).getCatchRate();
            case 4 :
                Bag.getInstance().useItem(ITEM_TYPE.MASTER_BALL);
                return ((PokeBall)master).getCatchRate();
            default:
                System.out.println("ID를 정확히 입력해주세요");
                selectBall();
        }
        return 0;
    }

    public boolean randomCollect(double rate){
        int rand = GameMng.getInstance().GetRandom().nextInt(101);
        return rand < rate;
    }

    public void collectPokemon(PokemonInfo wildPokemon){
        if(!hasBall()){
            System.out.println("몬스터 볼이 없습니다.");
        }else if(!isFullPokemon()){
            System.out.println("더 이상 포켓몬을 수집할 수 없습니다.");
            askRemove(wildPokemon);
        }else{
            double rate = selectBall();
            if(randomCollect(rate*100)){
                myPokemon.add(wildPokemon);
                System.out.println("야생 " + wildPokemon.name + "을(를) 포획했다!");
            }else{
                System.out.println("야생 " + wildPokemon.name + "이(가) 도망쳤다!");
            }
        }
    }

    public void runMenu(PokemonInfo wildPokemon){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : 수집하기");
        System.out.println("2 : 도감보기");
        System.out.println("3 : 대전 포켓몬 선택하기");
        System.out.println("종료하려면 아무 키나 입력");
        int menu = scanner.nextInt();

        switch (menu) {
            case 1 :
                collectPokemon(wildPokemon);
            case 2 :
                getDictionary();
            case 3:
                selectFightPokemon();
            default:
                GameMng.getInstance().ChangePrevScene();
        }
    }

    @Override
    public void Update() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int rand = GameMng.getInstance().GetRandom().nextInt(50);

        allPokemon = getAllPokemon();
        myPokemon = getMyPokemon();

        if(rand <= 28)
        {
            PokemonInfo wildPokemon = getPokemon(rand);
            System.out.println("야생 " + wildPokemon.name + "이(가) 나타났다!");
            runMenu(wildPokemon);
        }else {
            System.out.println("포켓몬을 발견하지 못했습니다. 다시 찾습니다..");
        }
    }
}
