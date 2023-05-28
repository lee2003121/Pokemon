package Game;

import Item.*;

import java.util.ArrayList;

public class Bag {
    public final int MaxItemCount = 30;
    private ArrayList<Item> ItemList;

    private Bag(){
        ItemList = new ArrayList<Item>();
    }

    private static class lazyHolder{
        public static Bag instance = new Bag();
    }

    public static Bag getInstance(){
        return lazyHolder.instance;
    }

    public int addItem(Item i){
        if(ItemList.size() >= MaxItemCount) return -1;
        else{
            ItemList.add(i);
            return 0;
        }
    }

    public int getNowItemCount(){return ItemList.size();}

    public void printBag(){
        if(ItemList.size() == 0){
            System.out.println("가방이 비어있습니다.");
        }
        else{
            for(int i = 0; i < ItemList.size(); i++) {
                System.out.println((i + 1) + ". " + ItemList.get(i).getName() + " " + ItemList.get(i).getDescription());
            }
        }
    }

    public int useItem(int index){
        if(0 < index && index < ItemList.size()){
            // 아이템 사용
            ItemList.remove(index);
            return 0;
        }
        return -1;
    }
}
