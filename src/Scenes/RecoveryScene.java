package Scenes;

import Game.PokemonInfo;
import Mng.GameMng;
import Framework.Scene;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecoveryScene extends Scene {
    private List<PokemonInfo> allPokemon;
    private int dotCount;
    private AtomicBoolean recoveryCompleted;

    public void Start() {
        allPokemon = GameMng.getInstance().AllPokemons;
        dotCount = 0;
        recoveryCompleted = new AtomicBoolean(false);
        recoverAllPokemon();
    }

    public void recoverAllPokemon() {
        new Thread(() -> {
            while (!recoveryCompleted.get()) {
                dotCount = (dotCount % 3) + 1;

                String dots = repeatString(".", dotCount);
                System.out.println("체력 회복 중" + dots);
                try {
                    Thread.sleep(510); // 0.3초간 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(3000); // 2초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recoveryCompleted.set(true);
        System.out.println("모든 포켓몬의 체력이 회복되었습니다.");
        GameMng.getInstance().ChangePrevScene();
    }

    private String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
