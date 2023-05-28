package Item;

public class HealingItem extends Item {
    private int healingPower;

    public HealingItem(String name, String description, int price, int healingPower) {
        super(name, description, price);
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }
}
