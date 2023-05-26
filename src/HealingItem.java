public class HealingItem extends Item {
    private int healingPoints;

    public HealingItem(String name, String description, int price, int healingPoints) {
        super(name, description, price);
        this.healingPoints = healingPoints;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }
}
