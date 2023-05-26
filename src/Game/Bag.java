package Game;

import Item.*;

import java.util.ArrayList;

public class Bag {
    public final int MaxItemCount = 30; // 아이템 최대 개수
    private ArrayList<Item> ItemList; // 아이템으 담을 ArrayList

    private Bag(){
        ItemList = new ArrayList<Item>();
    }

    private static class lazyHolder{ // Singleton class
        public static Bag instance = new Bag();
    }

    public static Bag getInstance(){
        return lazyHolder.instance;
    }

    public int addItem(Item i){ // 아이템 가방에 넣기
        if(ItemList.size() >= MaxItemCount) return -1;
        else{
            ItemList.add(i);
            return 0;
        }
    }

    public int getNowItemCount(){return ItemList.size();} // 현재 아이템 개수 

    public void printBag(){ // 가방에 있는 아이템 출력하기
        if(ItemList.size() == 0){
            System.out.println("가방이 비어있습니다.");
        }
        else{
            for(int i = 0; i < ItemList.size(); i++) {
                System.out.println((i + 1) + ". " + ItemList.get(i).getName() + " " + ItemList.get(i).getDescription());
            }
        }
    }

    public int useItem(int index){ // 아이템 사용하기
        if(0 < index && index < ItemList.size()){
            // 아이템 사용
            ItemList.remove(index);
            return 0;
        }
        return -1;
    }
}
