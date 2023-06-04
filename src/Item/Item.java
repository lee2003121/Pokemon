package Item;

import Define.ITEM_TYPE;

public class Item {
    private String name;
    private String description;
    private int price;
    private ITEM_TYPE type;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
