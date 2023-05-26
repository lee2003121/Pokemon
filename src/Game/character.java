package Game;

import Game.Bag;

import java.util.ArrayList;
import java.util.List;

public class character {
    private Map now_map;
    private Bag bag;
    private int pX;
    private int pY;
    private static class lazyHolder{ // Singleton class
        public static character instance = new character();
    }
    public static character getInstance(){
        return lazyHolder.instance;
    }

    public void init(){
        bag = Bag.getInstance();
    } // 초기설정으로 가방클래스 세팅

    /*
    좌표 반환
     */
    public int getX(){
        return pX;
    }

    public int getY(){
        return pY;
    }
    /*
    이동하기
     */
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
