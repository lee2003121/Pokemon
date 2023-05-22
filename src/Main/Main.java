package Main;

import Framework.printModule;

public class Main {
    public static void main(String[] args) {

        //GameMng.getInstance().GameLoop();

        while (true)
        {
            System.out.println("Hello");
            printModule.getInstance().clear();
        }

    }
}