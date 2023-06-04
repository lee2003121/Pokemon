package Game;

import Mng.GameMng;

import java.util.ArrayList;

public class PokemonInfo{

    public int id;
    // 포켓몬 id
    public String name;
    // 포켓몬 이름
    public String type;
    // 포켓몬 타입
    public String skill1;
    // 포켓몬 기술1
    public String skill2;
    // 포켓몬 기술2

    public int maxHp;

    public int hp;
    // 포켓몬 hp
    public int atk;
    // 포켓몬 공격력
    public int def;
    // 포켓몬 방어력
    public int level;
    // 포켓몬 레벨
    public int exp;
    // 포켓몬 경험치
    public int status;
    // 포켓몬 상태 1이면 전투 가능, 0이면 기절 상태

    // 포켓몬 객체 출력을 위한 toString() 메서드 선언
    @Override
    public String toString() {
        return "PokemonInfo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", skill1='" + skill1 + '\'' +
                ", skill2='" + skill2 + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", def=" + def +
                ", level=" + level +
                ", exp=" + exp +
                ", status=" + status +
                '}';
    }

    public String GetSmallInfo_Hp()
    {
        return String.format("%s %s / %s 속성 / Hp: %d / Atk: %d / Level: %d",name,status == 1 ? "" : "(기절)",type,hp,atk,level);
    }

    public String GetSmallInfo_MaxHp()
    {
        return String.format("%s %s / %s 속성 / Hp: %d / Atk: %d / Level: %d",name,status == 1 ? "" : "(기절)",type,hp,atk,level);
    }

    public void Init()
    {
        hp = maxHp;
    }

    public boolean Fight(PokemonInfo fighter)
    {
        System.out.println(String.format("%s이(가) %s에게 공격을 했다!", name, fighter.name));
        float pct = 1.0f;
        int a_type = GameMng.getInstance().TypeToString(type);
        int b_type = GameMng.getInstance().TypeToString(fighter.type);

        int result = GameMng.getInstance().compatibility_Table[a_type][b_type];
        if(result == 1)
        {
            pct = 0.8f;
            System.out.print("공격은 별로였다..");
        }
        else if(result == 2)
        {
            pct = 1.25f;
            System.out.print("공격은 굉장했다!!");
        }else {
            System.out.print("공격은 미미했다.");
        }

        int dmg = (int)(10 * ((float)atk/fighter.def) * pct) + 1;
        fighter.hp -= dmg;

        System.out.println(String.format(" (총 %d만큼 공격했다)", dmg));

        //System.out.println(FightInfo());
        System.out.println(fighter.FightInfo());

        if(fighter.hp <= 0)
        {
            fighter.status = 0;
            System.out.println(fighter.name +"은(는) 쓰러졌다...");
            return true;
        }
        return false;
    }

    public String FightInfo()
    {
        return String.format("%s %s- 남은 체력: %d/%d, 공격력: %d", name, status == 1 ? "" : "(기절)" , hp,maxHp,atk);
    }

    public void AddExp(int exp)
    {
        this.exp += exp;

        while (exp >= 15)
        {
            exp -= 15;
            level++;
        }

        checkRevolution();
    }

    public boolean valLevel(PokemonInfo pokemon){
        return pokemon.level>=3;
    }
    public boolean isPosRev(PokemonInfo prevPok, PokemonInfo nextPok){
        return prevPok.hp < nextPok.hp;
    }
    void checkRevolution(){
        if(valLevel(this)){
            ArrayList<PokemonInfo> allPokemon = Pokemon.getInfo();
            if(isPosRev(allPokemon.get(allPokemon.indexOf(this)), allPokemon.get((allPokemon.indexOf(this)) + 1))){
                PokemonInfo newPokemon = allPokemon.get((allPokemon.indexOf(this)) + 1);
                character.getInstance().MyPokemonList.remove(this);
                character.getInstance().MyPokemonList.add(newPokemon);
                System.out.println(this.name + "이(가) " + newPokemon + "으로 진화 되었다!");
            }
        }
    }
}