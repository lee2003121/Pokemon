public class pokemon {
    String pokemonName;
    int hp;
    int level;
    int offense;
    int defense;
    int exp;
    boolean status; // true 이면 전투 가능, false 이면 전투 불가능
    skill[] skills = new skill[3];
    public pokemon(String pokemonName, int hp, int offense, int defense, skill skills){
        this.pokemonName = pokemonName;
        this.level = 1;
        this.hp = hp;
        this.offense = offense;
        this.defense = defense;
        this.exp = 0;
        this.status = true;
        this.skills[0];
    }

}
