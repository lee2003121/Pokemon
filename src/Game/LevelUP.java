package Game;

public class LevelUP {

    public PokemonInfo checkLevel(PokemonInfo pokemon){

        String name = pokemon.name;
        int prev = pokemon.level;
        int current = prev + pokemon.exp/15;

        if(prev != current) {
            System.out.println(name + "의 레벨이 " + prev + "에서 " + current + "로 올랐다!");
            pokemon.level = current;
        }

        return pokemon;
    }
}
