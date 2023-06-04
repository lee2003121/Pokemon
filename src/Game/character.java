package Game;

import Game.Bag;
import Item.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class character implements Serializable {
    private final String FILE_NAME = "character_data.km";
    public List<PokemonInfo> MyPokemonList;
    public List<PokemonInfo> FightPokemonList;
    private int level;
    private int exp;
    private Bag bag;
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
        FightPokemonList = MyPokemon.getInfo(); //TODO 나중에 이거 지워야함.
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

    public void saveData() {
        bag.saveData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(MyPokemonList);
            oos.writeObject(FightPokemonList);
            oos.writeInt(level);
            oos.writeInt(exp);
            oos.flush();
            System.out.println("데이터 저장 완료");
        } catch (IOException e) {
            System.out.println("데이터 저장 실패: " + e.getMessage());
        }
    }

    public void loadData() {
        bag.loadData();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            MyPokemonList = (List<PokemonInfo>)ois.readObject();
            FightPokemonList = (List<PokemonInfo>)ois.readObject();
            level = ois.readInt();
            exp = ois.readInt();
            System.out.println("데이터 로드 완료");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("데이터 로드 실패: " + e.getMessage());
        }
    }
}
