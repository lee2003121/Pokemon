package Main;

import Framework.printModule;
import Mng.GameMng;

public class Main {
    public static void main(String[] args) {

        GameMng.getInstance().GameLoop();
    }
}