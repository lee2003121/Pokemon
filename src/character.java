public class character {
    private item bag;
    private Map now_map;
    private int[] position = new int[2]; // 현재 좌표

    private static class lazyHoler{
        public static character instance = new character();
    }
    public static character getInstance(){
        return lazyHoler.instance;
    }

    public void init(){

    }
}
