package Scenes;

import Framework.Scene;
import Game.MyPokemon;
import Game.Pokemon;
import Game.PokemonInfo;

import java.util.List;

public class FightScene extends Scene {

    List<PokemonInfo> myPokemons;
    List<PokemonInfo> allPokemons;

    @Override
    public void Start() {
        super.Start();

        myPokemons = MyPokemon.getInfo();
        allPokemons = Pokemon.getInfo();

        for(int i=0;i< myPokemons.size();i++)
        {
            System.out.println(myPokemons.get(i));
        }
        System.out.println("전체 포켓몬");
        for(int i=0;i< allPokemons.size();i++)
        {
            System.out.println(allPokemons.get(i));
        }

    }

    @Override
    public void Update() {
        //super.Update();
    }
}
