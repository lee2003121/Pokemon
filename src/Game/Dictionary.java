package Game;

public class Dictionary {
    // 포켓몬 도감을 출력하는 printDictionary() 메서드
    public static void printDictionary(){
        // MyPokemonList에 내가 보유한 포켓몬 객체 배열을 받음
        PokemonInfo[] MyPokemonList = MyPokemon.MyPokemon();
        // 도감에서 표를 출력하기 위한 tab 길이 지정 (\t는 너무 길었음)
        String tab = "   ";

        // 포켓몬 도감 표 헤더 출력 코드
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
                "POKEMON", "TYPE", "SKILL1", "SKILL2", "HP", "ATTACK", "DEFENSE", "LEVEL", "EXP", "STATUS");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(int i = 0; i < MyPokemonList.length; i++){
            // name이 null 이면 즉, 보유한 포켓몬이 없으면 ??? 출력
            if(MyPokemonList[i].name == null){
                for (int j = 0; j < 10; j++) System.out.format("%5s", tab + "???");
            }else {
                // 포켓몬 정보 출력
                System.out.format("%5s %5s %5s %5s %5s %5s %5s %5s %5s %5s",
                        MyPokemonList[i].name, MyPokemonList[i].type, MyPokemonList[i].skill1, MyPokemonList[i].skill2, MyPokemonList[i].hp,
                        MyPokemonList[i].atk, MyPokemonList[i].def, MyPokemonList[i].level, MyPokemonList[i].exp, MyPokemonList[i].status);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}
