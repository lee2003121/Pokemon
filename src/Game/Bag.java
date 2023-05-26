package Game;

import Item.*;
public class Bag {
    public final int MaxItemCount = 30;
    private int nowItemCount;
    private Item[] ItemList;

    private Bag(){
        nowItemCount = 0;
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
            ItemList[nowItemCount] = i;
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
                System.out.println((i + 1) + ". " + ItemList[i].getName());
            }
        }
    }
}
