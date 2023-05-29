package Game;

class PokemonInfo{
    String name;
    // 포켓몬 이름
    String type;
    // 포켓몬 타입
    String skill1;
    // 포켓몬 기술1
    String skill2;
    // 포켓몬 기술2
    int hp;
    // 포켓몬 hp
    int atk;
    // 포켓몬 공격력
    int def;
    // 포켓몬 방어력
    int level;
    // 포켓몬 레벨
    int exp;
    // 포켓몬 경험치
    int status;
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
}