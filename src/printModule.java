public class printModule {
    final private static int width = 122; // 콘솔 최대 너비
    final private static int height = 30; // 콘솔 최대 높이
    private char[][] screen = new char[height][width]; // 콘솔에 출력할 화면을 저장

    private static class LazyHolder{
        public static final printModule instance = new printModule();
    }
    public void init(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                this.screen[i][j] = ' ';
            }
        }
    }
    public static printModule getInstance(){
        return LazyHolder.instance;
    }

    public int setPoint(int x, int y, char c) {
        try {
            return this.screen[x][y] = c;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
    }

    public void setMessage(String msg){
        int msgLength = msg.length();

        for(int i = 0; i < msgLength; i++){
            this.screen[height - 1][i] = msg.charAt(i);
        }
    }

    public void printScreen() {
        printModule.clear();
        int x, y;
        for(x = 0; x < height; x++) {
            for(y = 0; y < width; y++){
                System.out.print(this.screen[x][y]);
            }
            System.out.println();
        }
    }

    public void printScreen(int millisecond){
        this.printScreen();
        try{
            Thread.sleep(millisecond);
        } catch(InterruptedException e){

        }
    }

    public static void clear() {
        for(int i = 0; i < height; i++) System.out.println(); // 콘솔 최대 높이만큼 줄바꿈해서 지워진것 처럼 보임
    }
}
