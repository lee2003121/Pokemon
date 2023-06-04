package Scenes;

import Game.PokemonInfo;
import Game.character;
import Mng.GameMng;
import Framework.Scene;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
public class RecoveryScene extends Scene {
    private List<PokemonInfo> allPokemon;
    private int dotCount;
    private AtomicBoolean recoveryCompleted;

    public void Start() {
        allPokemon = character.getInstance().MyPokemonList;
        dotCount = 0;
        recoveryCompleted = new AtomicBoolean(false);
        recoverAllPokemon();
    }

    public void recoverAllPokemon() {
        // 별도의 Runnable 객체를 정의하여 스레드를 생성
        Thread recoveryThread = new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        });

        recoveryThread.start();

        try {
            Thread.sleep(3000); // 2초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recoveryCompleted.set(true);
        // 모든 포켓몬의 체력을 최대치로 회복
        for (PokemonInfo pokemon : allPokemon) {
            pokemon.hp= pokemon.maxHp;
            if(pokemon.status!=2)
                pokemon.status=1;
        }
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
