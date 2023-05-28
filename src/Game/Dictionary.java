package Game;

public class Dictionary {
    public static void printDictionary(){
        PokemonInfo[] PokemonList = Pokemon.generatePokemon();
        PokemonInfo[] MyPokemonList = MyPokemon.MyPokemon();
        String tab = "   ";

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
                "POKEMON", "TYPE", "SKILL1", "SKILL2", "HP", "ATTACK", "DEFENSE", "LEVEL", "EXP", "STATUS");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(int i = 0; i < MyPokemonList.length; i++){
            if(MyPokemonList[i].name == null){
//                System.out.format("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
//                        "?????", "?????", "?????", "?????", "?????", "?????", "?????", "?????", "?????", "?????");
                for (int j = 0; j < 10; j++) System.out.format("%5s", tab + "???");
            }else {
                System.out.format("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
                        MyPokemonList[i].name, MyPokemonList[i].type, MyPokemonList[i].skill1, MyPokemonList[i].skill2, MyPokemonList[i].hp,
                        MyPokemonList[i].atk, MyPokemonList[i].def, MyPokemonList[i].level, MyPokemonList[i].exp, MyPokemonList[i].status);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}
