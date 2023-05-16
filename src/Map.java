import java.io.*;

public class Map {
    private int width;
    private int height;
    private String[] mapData;

    void setMapData(File mapFile) // 파일경로를 받아서 mapData에 저장하는 함수
    {
        try{
            BufferedReader BR = new BufferedReader(new FileReader(mapFile));
            String mapSize = BR.readLine();
            width  = Integer.parseInt(mapSize.split(" ")[0]);
            height = Integer.parseInt(mapSize.split(" ")[1]);
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
}
