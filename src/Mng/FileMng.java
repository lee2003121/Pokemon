package Mng;
import java.io.*;


public class FileMng {

    private FileMng() {}
    private static FileMng instance;


    public  static FileMng getInstance()
    {
        if(instance == null)
            instance = new FileMng();
        return instance;
    }

    static String LoadFile(String path)
    {
        String content = "";
        //파일을 열 때 경로에 파일이 없을 수 있기에 예외처리
        try {
            FileInputStream fin = new FileInputStream(path);
            InputStreamReader in = new InputStreamReader(fin, "MS949");

            int c;
            while((c=in.read()) != -1) {
                content += (char)c;
            }

            in.close();
            fin.close();
        }
        catch(IOException e)
        {
            System.out.print(e);
        }
        return content;
    }

}
