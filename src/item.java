import java.lang.reflect.Array;
import java.util.ArrayList;

public class item {

    private ArrayList<Integer> Recovery_Pills = new ArrayList<Integer>(3);//0:총합 1:일반 회복약 2:고급회복약
    private int Candy = 0;
    private ArrayList<Integer> MonsterBall = new ArrayList<Integer>(5); //0:몬스터봏 총합 1:포켓볼 2:슈퍼볼 3:하이퍼볼 4:마스터볼

    public ArrayList<Integer> getRecovery_Pills() {
        return Recovery_Pills;
    }

    public void setRecovery_Pills(ArrayList<Integer> recovery_Pills) {
        Recovery_Pills = recovery_Pills;
    }

    public int getCandy() {
        return Candy;
    }

    public void setCandy(int candy) {
        Candy = candy;
    }


    public ArrayList<Integer> getMonsterBall() {
        return MonsterBall;
    }

    public void setMonsterBall(ArrayList<Integer> monsterBall) {
        MonsterBall = monsterBall;
    }

    public item()
    {

    }
}

