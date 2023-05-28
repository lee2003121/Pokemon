package Game;

import Item.Item;

import java.util.ArrayList;

public class Bag {
    public final int MaxItemCount = 30;
    private ArrayList<Item> ItemList;
    private int coin;

    private Bag() {
        ItemList = new ArrayList<Item>();
        coin = 0;
    }

    private static class LazyHolder {
        public static final Bag instance = new Bag();
    }

    public static Bag getInstance() {
        return LazyHolder.instance;
    }

    public int addItem(Item i) {
        if (ItemList.size() >= MaxItemCount)
            return -1;
        else {
            ItemList.add(i);
            return 0;
        }
    }

    public int getNowItemCount() {
        return ItemList.size();
    }

    public void printBag() {
        if (ItemList.size() == 0) {
            System.out.println("가방이 비어있습니다.");
        } else {
            for (int i = 0; i < ItemList.size(); i++) {
                System.out.println((i + 1) + ". " + ItemList.get(i).getName() + " " + ItemList.get(i).getDescription());
            }
        }
    }

    public int useItem(int index) {
        if (index > 0 && index <= ItemList.size()) {
            ItemList.remove(index - 1);
            return 0;
        }
        return -1;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void addCoin(int amount) {
        coin += amount;
    }

    public void deductCoin(int amount) {
        coin -= amount;
    }
}
