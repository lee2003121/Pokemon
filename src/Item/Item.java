package Item;

import Define.ITEM_TYPE;

public class Item {
    private String name;
    private String description;
    private int price;
    private ITEM_TYPE type;
    private int count;

    public Item(String name, String description, int price, ITEM_TYPE type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public ITEM_TYPE getType(){return type;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void AddItem(int count){
        this.count += count;
    }

    public void UseItem()
    {
        if(count > 0)
            count--;
    }

    public int GetCount()
    {
        return count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s / %s / 보유 갯수 : %d", name, description, count);
    }
}
