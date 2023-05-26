package Item;

public class Candy extends Item {
    private int experiencePoints;

    public Candy(String name, String description, int price, int experiencePoints) {
        super(name, description, price);
        this.experiencePoints = experiencePoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
}
