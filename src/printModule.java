public class printModule {
    final private static int width = 122;
    final private static int height = 30;
    private char[][] screen = new char[height][width];

    public void setPoint(int x, int y, char c) {
        this.screen[x][y] = c;
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

    public static void clear() {
        for(int i = 0; i < 80; i++) System.out.println();
    }
}
