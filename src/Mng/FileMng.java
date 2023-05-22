package Mng;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class FileMng {

    private FileMng() {}
    private static FileMng instance;


    public  static FileMng getInstance()
    {
        if(instance == null)
            instance = new FileMng();
        return instance;
    }
}
