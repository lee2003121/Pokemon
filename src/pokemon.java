public class pokemon {
    String pokemonName;
    int hp;
    int level;
    int offense;
    int defense;
    int exp;
    String type;
    boolean status; // true 이면 전투 가능, false 이면 전투 불가능
    skill[] skills = new skill[3];
    public pokemon(String pokemonName, String type, int hp, int offense, int defense, skill skill1, skill skill2){
        this.pokemonName = pokemonName;
        this.type = type;
        this.hp = hp;
        this.offense = offense;
        this.defense = defense;
        this.skills[0] = skill1;
        this.skills[1] = skill2;
        // 불변 속성
        this.level = 1;
        this.exp = 0;
        this.status = true;
    }

}
