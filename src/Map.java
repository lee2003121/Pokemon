import java.io.*;

public class Map {
    public static final char[] impassableObject = {'='}; // 통
    private int width;
    private int height;
    private String[] mapData;

    void setMapData(File mapFile) // 파일경로를 받아서 mapData에 저장하는 함수
    {
        try{
            BufferedReader BR = new BufferedReader(new FileReader(mapFile));
            String mapSize = BR.readLine();
            height = Integer.parseInt(mapSize.split(" ")[0]);
            width = Integer.parseInt(mapSize.split(" ")[1]);
            setHeight(height);

            for(int i = 0; i < height; i++){
                this.mapData[i] = BR.readLine();
            }
        }catch (FileNotFoundException e) {
            System.out.println("Cannot Find Mapfile(" + mapFile.getPath() + ")");
        }catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private int setHeight(int height) { //height setter
        if(height <= 0) return -1;
        this.height = height;
        mapData = new String[height];

        return 0;
    }

    public String[] getMapData(){
        return mapData;
    }
    public char getMapData(int x, int y){
        if(x < 0 || x > height) return 0;
        if(y < 0 || y > width) return 0;
        return mapData[x].charAt(y);
    }

    public static boolean isPassable(char tile){
        for(char c: impassableObject){
            if(c == tile) return false;
        }
        return true;
    }
}
