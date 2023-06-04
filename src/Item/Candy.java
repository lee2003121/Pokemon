package Item;

import Define.ITEM_TYPE;

public class Candy extends Item {
    private int experiencePoints;

    public Candy(String name, String description, int price, int experiencePoints, ITEM_TYPE type) {
        super(name, description, price, type);
        this.experiencePoints = experiencePoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void use(){

    }
}
