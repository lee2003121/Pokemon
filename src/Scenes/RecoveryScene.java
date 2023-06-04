package Scenes;

import Game.PokemonInfo;
import Mng.GameMng;
import Framework.Scene;

import java.util.List;

public class RecoveryScene extends Scene {
    private List<PokemonInfo> allPokemon;

    public void Start()
    {
        allPokemon = GameMng.getInstance().AllPokemons;
        recoverAllPokemon();
    }

    public void recoverAllPokemon() {
        System.out.println("체력 회복 중...");
        try {
            Thread.sleep(2000); // 2초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (PokemonInfo pokemon : allPokemon) {
            pokemon.hp = pokemon.maxHp;
        }
        System.out.println("모든 포켓몬의 체력이 회복되었습니다.");

        GameMng.getInstance().ChangePrevScene();
    }
}
