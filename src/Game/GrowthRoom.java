package Game;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GrowthRoom {
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
        if(growthPokemonList.size() == maxSize) return -1;
        growthPokemonList.add(new GrowthPokemon(p, new Timestamp(System.currentTimeMillis())));
        return 0;
    }

    public void printGrowthPokemon(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for(int i = 1; i <= growthPokemonList.size(); i++){
            System.out.println(i + ". " + growthPokemonList.get(i - 1).pokemon.name + " / " + timeToExp(growthPokemonList.get(i - 1).timestamp));
        }
    }

    private int timeToExp(Timestamp inTime){
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        long seconds = (nowTime.getTime() - inTime.getTime()) / 1000;
        int exp = (int)Math.min(seconds/10, 1000);
        return exp;
    }

    public int takeGrowthPokemon(int n){ //인덱스 n에 있는 포켓몬 꺼내기
        try{
            int exp = timeToExp(growthPokemonList.get(n).timestamp);
            growthPokemonList.get(n).pokemon.AddExp(exp);
            System.out.println(growthPokemonList.get(n).pokemon.name + "이(가) " + exp + "경험치를 획득하였습니다.");
            growthPokemonList.remove(n);
            return 0;
        }catch(Exception e){
            System.out.println("비어있는 포켓몬입니다.");
            return -1;
        }
    }
}