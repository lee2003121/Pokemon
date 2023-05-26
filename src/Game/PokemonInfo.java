package Game;

class PokemonInfo{
    String name;
    String type;
    String skill1;
    String skill2;
    int hp;
    int atk;
    int def;
    int level;
    int exp;
    int status;

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