package Scenes;
import Game.Pokemon;
import Game.PokemonInfo;
import Mng.GameMng;

import java.util.List;

public class RecoveryScene {
    private List<PokemonInfo> allPokemons;

    public void Update()
    {
        allPokemons = GameMng.getInstance().AllPokemons;
        recoverAllPokemon();
    }

    public void recoverAllPokemon() {
        System.out.println("체력 회복 중...");
        try {
            Thread.sleep(2000); // 2초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (PokemonInfo pokemon : allPokemons) {
            pokemon.hp = pokemon.maxHp;
        }
        System.out.println("모든 포켓몬의 체력이 회복되었습니다.");
        GameMng.getInstance().ChangeState(new MenuScene());
    }
}
