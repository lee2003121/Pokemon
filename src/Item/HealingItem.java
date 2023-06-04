package Item;

import Define.ITEM_TYPE;

public class HealingItem extends Item {
    private int healingPower;

    public HealingItem(String name, String description, int price, int healingPower, ITEM_TYPE type) {
        super(name, description, price, type);
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }
}
