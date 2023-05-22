package Mng;
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
