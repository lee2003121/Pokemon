package Game;

import Item.Item;

import java.util.ArrayList;
import java.util.List;

public class character {
    private List<Item> bag;
    private Map now_map;
    private int pX;
    private int pY;
    private static class lazyHolder{
        public static character instance = new character();
    }
    public static character getInstance(){
        return lazyHolder.instance;
    }

    public void init(){
        bag = new ArrayList<>();
    }

    public int getX(){
        return pX;
    }

    public int getY(){
        return pY;
    }

    public void goRight(){
        char nextTile = now_map.getMapData(this.pX, this.pY + 1);
        if(Map.isPassable(nextTile)) pY = pY + 1;
    }
    public void goLeft(){
        char nextTile = now_map.getMapData(this.pX, this.pY - 1);
        if(Map.isPassable(nextTile)) pY = pY - 1;
    }
    public void goUp(){
        char nextTile = now_map.getMapData(this.pX + 1, this.pY);
        if(Map.isPassable(nextTile)) pX = pX + 1;
    }
    public void goDown(){
        char nextTile = now_map.getMapData(this.pX - 1, this.pY);
        if(Map.isPassable(nextTile)) pX = pX - 1;
    }
}
/*;
HealingItem potion = new HealingItem("Potion", "Heals a Pokémon by 20 HP.", 300, 20);
character.addItemToBag(potion);
 */