package Game;

import Mng.GameMng;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GrowthRoom {
    public static final int MAX_EXP = 1000;
    private class GrowthPokemon{
        PokemonInfo pokemon;
        Timestamp timestamp;

        public GrowthPokemon(PokemonInfo p, Timestamp time){
            this.pokemon = p;
            this.timestamp = time;
        }
    }
    private List<GrowthPokemon> growthPokemonList;
    private final int maxSize = 4;
    private static class lazyHolder{ // Singleton class
        public static GrowthRoom instance = new GrowthRoom();
    }
    public static GrowthRoom getInstance(){
        return lazyHolder.instance;
    }

    private GrowthRoom(){
        growthPokemonList = new ArrayList<GrowthPokemon>();
    }

    public int addGrowthPokemon(PokemonInfo p){
        if(growthPokemonList.size() == maxSize) {
            System.out.println("성장의 방이 이미 꽉 찼습니다.");
            return -1;
        }
        growthPokemonList.add(new GrowthPokemon(p, new Timestamp(System.currentTimeMillis())));
        return 0;
    }

    public void printGrowthPokemon(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int i;
        for(i = 0; i < growthPokemonList.size(); i++){
            System.out.println((int)(i + 1) + ". " + growthPokemonList.get(i).pokemon.name + " / " + timeToExp(growthPokemonList.get(i).timestamp));
        }
    }

    private int timeToExp(Timestamp inTime){
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        long seconds = (nowTime.getTime() - inTime.getTime()) / 1000;
        int exp = (int)Math.min(seconds/10, MAX_EXP);
        return exp;
    }

    public int takeGrowthPokemon(int n){ //인덱스 n에 있는 포켓몬 꺼내기
        try{
            GrowthPokemon p = growthPokemonList.get(n - 1);
            System.out.println(p.pokemon.name + "을(를) 꺼내시겠습니까?(Y/N)");
            String ans = GameMng.getInstance().scanner.next();
            if(ans.equals("N") || ans.equals("n")) return 1;
            if(ans.equals("Y") || ans.equals("y")){
                int exp = timeToExp(p.timestamp);
                p.pokemon.AddExp(exp);
                System.out.println(p.pokemon.name + "이(가) " + exp + "경험치를 획득하였습니다.");
                growthPokemonList.remove(n - 1);
                return 0;
            }
            return -1;
        }catch(Exception e) {
            System.out.println("잘못된 입력입니다.");
            e.printStackTrace();
            return -1;
        }
    }

    public int getPokemonCount(){
        return growthPokemonList.size();
    }
}