package Game;
import java.util.List;

public class Revolution {
    public boolean valLevel(PokemonInfo pokemon){
        return pokemon.level>=10;
    }

    public boolean isPosRev(PokemonInfo prevPok, PokemonInfo nextPok){
        return prevPok.hp > nextPok.hp;
    }
    public PokemonInfo addPokemon(PokemonInfo pokemon) {
        List<PokemonInfo> allPokemon = Pokemon.getInfo();
        PokemonInfo newPokemon = null;
        if (isPosRev(allPokemon.get(allPokemon.indexOf(pokemon)), allPokemon.get((allPokemon.indexOf(pokemon)) + 1))) {
            newPokemon = allPokemon.get((allPokemon.indexOf(pokemon)) + 1);
        }
        return newPokemon;
    }

    public List<PokemonInfo> checkRevolution(List<PokemonInfo> myPokemonList, PokemonInfo pokemon){
        if(valLevel(pokemon)) {
            myPokemonList.add(addPokemon(pokemon));
            myPokemonList.remove(pokemon);
        }
        return myPokemonList;
    }
}
