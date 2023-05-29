package Scenes;

import Framework.Scene;
import Game.MyPokemon;
import Game.Pokemon;
import Game.PokemonInfo;

public class FightScene extends Scene {

    PokemonInfo[] myPokemons;
    PokemonInfo[] allPokemons;

    @Override
    public void Start() {
        super.Start();

        myPokemons = MyPokemon.MyPokemon();
        allPokemons = Pokemon.generatePokemon();

        for(int i=0;i< myPokemons.length;i++)
        {
            System.out.println(myPokemons[i]);
        }
        System.out.println("전체 포켓몬");
        for(int i=0;i< allPokemons.length;i++)
        {
            System.out.println(allPokemons[i]);
        }

    }

    @Override
    public void Update() {
        //super.Update();
    }
}
