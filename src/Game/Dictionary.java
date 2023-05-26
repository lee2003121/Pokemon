package Game;

public class Dictionary {
    public static void printDictionary(){
       PokemonInfo[] PokemonList = Pokemon.generatePokemon();
       PokemonInfo[] MyPokemonList = MyPokemon.MyPokemon();


       for (int i = 0; i < MyPokemonList.length; i++) {
           System.out.println(MyPokemonList[i].toString());
       }
    }
}
