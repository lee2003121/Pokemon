package Item;

import Define.ITEM_TYPE;

public class PokeBall extends Item {
    private double catchRate;

    public PokeBall(String name, String description, int price, double catchRate, ITEM_TYPE type) {
        super(name, description, price, type);
        this.catchRate = catchRate;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(double catchRate) {
        this.catchRate = catchRate;
    }
}
