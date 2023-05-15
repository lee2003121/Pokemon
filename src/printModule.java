public class printModule {
    final private static int width = 122; // 콘솔 최대 너비
    final private static int height = 30; // 콘솔 최대 높이
    private char[][] screen = new char[height][width]; // 콘솔에 출력할 화면을 저장

    private static class LazyHolder{ // Singleton 패턴을 위한 static class
        public static final printModule instance = new printModule();
    }
    public void init(){ // 출력할 화면을 초기화하는 함수
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                this.screen[i][j] = ' ';
            }
        }
    }
    public static printModule getInstance(){ // 외부에서 객체를 사용하기 위해 instance를 받는 명령어
        return LazyHolder.instance;
    }

    public int setPoint(int x, int y, char c) { // (x, y)좌표의 문자를 c로 지정하는 함수 (실패시 -1)
        try {
            return this.screen[x][y] = c;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
    }

    public int setScreen(String[] source) // String[]을 받아서 screen에 저장하는 함수 (실패시 -1)
    {
        int size = source.length;
        for (int i = 0; i < size; i++) {
            int length = source[i].length();
            if(length > width) return -1;
            for(int j = 0; j < length; j++)
            {
                this.screen[i][j] = source[i].charAt(j);
            }
        }
        return 0;
    }

    public int setMessage(String msg){ // 화면에 출력할 메시지를 세팅하는 함수 (실패시 -1)
        int msgLength = msg.length();

        if(msgLength > width) return -1;

        for(int i = 0; i < msgLength; i++){
            this.screen[height - 1][i] = msg.charAt(i);
        }
        return 0;
    }

    public void printScreen() { // 콘솔에 화면을 출력하는 함수
        printModule.clear();
        int x, y;
        for(x = 0; x < height; x++) {
            for(y = 0; y < width; y++){
                System.out.print(this.screen[x][y]);
            }
            System.out.println();
        }
    }

    public void printScreen(int millisecond){ // 화면을 출력한 후 millisecond만큼 정지
        this.printScreen();
        try{
            Thread.sleep(millisecond);
        } catch(InterruptedException e){
            // sleep실패하면 뭐 아쉽게 된거지
        }
    }

    public static void clear() { // 화면을 지우는 함수
        for(int i = 0; i < height; i++) System.out.println(); // 콘솔 최대 높이만큼 줄바꿈해서 지워진것 처럼 보임
    }
}
