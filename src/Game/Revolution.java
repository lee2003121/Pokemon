package Game;
import java.util.ArrayList;


public class Revolution {

    public boolean valLevel(PokemonInfo pokemon){
        return pokemon.level>=10;
    }
    public boolean isPosRev(PokemonInfo prevPok, PokemonInfo nextPok){
        return prevPok.hp < nextPok.hp;
    }
    public ArrayList<PokemonInfo> checkRevolution(ArrayList<PokemonInfo> myPokemonList, PokemonInfo pokemon){
        if(valLevel(pokemon)){
            ArrayList<PokemonInfo> allPokemon = Pokemon.getInfo();
            if(isPosRev(allPokemon.get(allPokemon.indexOf(pokemon)), allPokemon.get((allPokemon.indexOf(pokemon)) + 1))){
                PokemonInfo newPokemon = allPokemon.get((allPokemon.indexOf(pokemon)) + 1);
                myPokemonList.remove(pokemon);
                myPokemonList.add(newPokemon);
                System.out.println(pokemon + "이 " + newPokemon + "으로 진화 되었다!");
            }
        }
        return myPokemonList;
    }
}
