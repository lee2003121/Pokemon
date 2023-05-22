public class character {
    private item bag;
    private Map now_map;
    private int[] position = new int[2]; // 현재 좌표

    private static class lazyHolder{
        public static character instance = new character();
    }
    public static character getInstance(){
        return lazyHolder.instance;
    }

    public void init(){

    }
}
