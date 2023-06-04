package Game;

import Define.ITEM_TYPE;
import Item.*;
import Mng.GameMng;

import java.io.*;
import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> itemList;
    private int coin;
    private static final String FILE_NAME = "bag_data.km";

    private Bag() {
        itemList = new ArrayList<>();
        itemList.add(new HealingItem("일반 회복약", "포켓몬의 체력을 20 회복시킵니다.", Shop.POTION_PRICE, 20, ITEM_TYPE.NORMAL_HEAL));
        itemList.add(new HealingItem("고급 회복약", "포켓몬의 체력을 50 회복시킵니다.", Shop.ADVANCED_POTION_PRICE, 50, ITEM_TYPE.EPIC_HEAL));
        itemList.add(new PokeBall("몬스터볼", "특별한 캐치율을 제공하는 특수한 볼입니다.", Shop.MONSTERBALL_PRICE, 0.5, ITEM_TYPE.NORMAL_BALL));
        itemList.add(new PokeBall("슈퍼볼", "표준 포켓볼보다 높은 캐치율을 제공하는 좋은 고성능 볼입니다.", Shop.SUPERBALL_PRICE, 0.2, ITEM_TYPE.SUPER_BALL));
        itemList.add(new PokeBall("하이퍼볼", "슈퍼볼보다 높은 캐치율을 제공하는 고성능 볼입니다.", Shop.HYPERBALL_PRICE, 0.3, ITEM_TYPE.HYPER_BALL));
        itemList.add(new PokeBall("마스터볼", "최고 수준의 성능을 가진 최상의 포켓볼입니다.", Shop.MASTERBALL_PRICE, 1.0, ITEM_TYPE.MASTER_BALL));
        itemList.add(new Candy("캔디", "포켓몬의 경험치를 10 증가합니다.", Shop.MASTERBALL_PRICE, 10, ITEM_TYPE.CANDY));

        coin = 1000;
        //loadData();
    }

    private static Bag instance;
    public  static Bag getInstance()
    {
        if(instance == null)
            instance = new Bag();
        return instance;
    }

    public void addItem(ITEM_TYPE type) {
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getType() == type)
            {
                itemList.get(i).AddItem(1);
                break;
            }
        }
    }

    public int getNowItemCount() {
        return itemList.size();
    }

    public void printBag() {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }

    public boolean useItem(ITEM_TYPE type) {
        Item item = GetItem(type);

        if(item.GetCount() > 0)
        {
            item.UseItem();
            return true;
        }else {
            System.out.println(item.getName() +"이(가) 없어 사용할 수 없습니다.");
            return false;
        }
    }

    public Item GetItem(ITEM_TYPE type)
    {
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getType() == type)
            {
                return itemList.get(i);
            }
        }
        return null;
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

    public boolean HavePokeball()
    {
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getType() != ITEM_TYPE.NORMAL_HEAL && itemList.get(i).getType() != ITEM_TYPE.EPIC_HEAL
                    && itemList.get(i).GetCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean HaveHeal()
    {
        for(int i=0;i<itemList.size();i++)
        {
            if((itemList.get(i).getType() == ITEM_TYPE.NORMAL_HEAL || itemList.get(i).getType() == ITEM_TYPE.EPIC_HEAL)
                    && itemList.get(i).GetCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> GetItemList()
    {
        return itemList;
    }
}
