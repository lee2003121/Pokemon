package Game;

import Item.Item;

import java.io.*;
import java.util.ArrayList;

public class Bag {
    public final int MaxItemCount = 30;
    private ArrayList<Item> itemList;
    private int coin;
    private static final String FILE_NAME = "bag_data.km";

    private Bag() {
        itemList = new ArrayList<>();
        coin = 0;
    }

    private static class LazyHolder {
        public static final Bag instance = new Bag();
    }

    public static Bag getInstance() {
        return LazyHolder.instance;
    }

    public int addItem(Item item) {
        if (itemList.size() >= MaxItemCount)
            return -1;
        else {
            itemList.add(item);
            return 0;
        }
    }

    public int getNowItemCount() {
        return itemList.size();
    }

    public void printBag() {
        if (itemList.size() == 0) {
            System.out.println("가방이 비어있습니다.");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i).getName() + " " + itemList.get(i).getDescription());
            }
        }
    }

    public int useItem(int index) {
        if (index > 0 && index <= itemList.size()) {
            itemList.remove(index - 1);
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

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(itemList);
            oos.writeInt(coin);
            oos.flush();
            System.out.println("데이터 저장 완료");
        } catch (IOException e) {
            System.out.println("데이터 저장 실패: " + e.getMessage());
        }
    }

    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            itemList = (ArrayList<Item>) ois.readObject();
            coin = ois.readInt();
            System.out.println("데이터 로드 완료");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("데이터 로드 실패: " + e.getMessage());
        }
    }
}
