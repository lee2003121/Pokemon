package Item;

public class PokeBall extends Item {
    private double catchRate;

    public PokeBall(String name, String description, int price, double catchRate) {
        super(name, description, price);
        this.catchRate = catchRate;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(double catchRate) {
        this.catchRate = catchRate;
    }
}
