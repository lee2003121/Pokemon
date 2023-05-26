package Game;

import Item.*;

import java.util.ArrayList;

public class Bag {
    public final int MaxItemCount = 30;
    private int nowItemCount;
    private ArrayList<Item> ItemList;

    private Bag(){
        nowItemCount = 0;
        ItemList = new ArrayList<Item>();
    }

    private static class lazyHolder{
        public static Bag instance = new Bag();
    }

    public static Bag getInstance(){
        return lazyHolder.instance;
    }

    public int addItem(Item i){
        if(nowItemCount >= MaxItemCount) return -1;
        else{
            ItemList.add(i);
            return 0;
        }
    }

    public int getNowItemCount(){return nowItemCount;}

    public void printBag(){
        if(nowItemCount == 0){
            System.out.println("가방이 비어있습니다.");
        }
        else{
            for(int i = 0; i < nowItemCount; i++) {
                System.out.println((i + 1) + ". " + ItemList.get(i).getName() + " " + ItemList.get(i).getDescription());
            }
        }
    }

    public int useItem(int index){
        if(index < 0 || index >= MaxItemCount) return -1;
        // 아이템 사용
        ItemList.remove(index);
        return 0;
    }
}
