package Game;

import Game.Bag;

import java.util.ArrayList;
import java.util.List;

public class character {
    public List<PokemonInfo> MyPokemonList;
    private List<PokemonInfo> FightPokemonList;
    private Map now_map;
    private int level;
    private int exp;
    private Bag bag;
    private int pX;
    private int pY;
    private static class lazyHolder{ // Singleton class
        public static character instance = new character();
    }
    public static character getInstance(){
        return lazyHolder.instance;
    }

    public void init(){
        level = 1;
        exp = 0;
        bag = Bag.getInstance();

        MyPokemonList = MyPokemon.getInfo();
    }

    public void AddFightPokemon(PokemonInfo pokemon)
    {
        if(FightPokemonList.size() + 1 < 3)
            FightPokemonList.add(pokemon);
    }

    public boolean FightPokemonIsFull()
    {
        return FightPokemonList.size() >= 2;
    }

    public List<PokemonInfo> GetFightPokemonList(){return FightPokemonList;}

    public void RemovePokemon(int index) {
        FightPokemonList.remove(index);
    }


    public int getLevel(){
        return level;
    }

    public int getExp(){
        return exp;
    }

    public void addExp(int earnExp){
        exp += earnExp;
        if(exp > 100){
            levelUp(exp/100);
            exp %= 100;
        }
    }

    private void levelUp(int n)
    {
        if(level == 10){
            System.out.println("트레이너 레벨이 이미 최고레벨입니다.");
            return;
        }

        if(n > 0) {
            System.out.println("트레이너레벨이 올랐습니다.");
            level += n;
            if (level >= 10) {
                level = 10;
                System.out.println("현재 최고레벨입니다.");
            } else {
                System.out.println("현재 " + level + "레벨 입니다.");
            }
        }
    }
    /*
    좌표 반환
     */
    public int getX(){
        return pX;
    }

    public int getY(){
        return pY;
    }
    /*
    이동하기
     */
    public void goRight(){
        char nextTile = now_map.getMapData(this.pX, this.pY + 1);
        if(Map.isPassable(nextTile)) pY = pY + 1;
    }
    public void goLeft(){
        char nextTile = now_map.getMapData(this.pX, this.pY - 1);
        if(Map.isPassable(nextTile)) pY = pY - 1;
    }
    public void goUp(){
        char nextTile = now_map.getMapData(this.pX + 1, this.pY);
        if(Map.isPassable(nextTile)) pX = pX + 1;
    }
    public void goDown(){
        char nextTile = now_map.getMapData(this.pX - 1, this.pY);
        if(Map.isPassable(nextTile)) pX = pX - 1;
    }
    public void collectCoin(int amount) {
        bag.addCoin(amount);
        System.out.println(amount + "코인을 획득하였습니다.");
    }
}
