import java.lang.reflect.Array;
import java.util.ArrayList;

public class item {

    private ArrayList<Integer> Recovery_Pills = new ArrayList<Integer>(3);//0:총합 1:일반 회복약 2:고급회복약
    private int Candy = 0;
    private ArrayList<Integer> MonsterBall = new ArrayList<Integer>(5); //0:몬스터봏 총합 1:포켓볼 2:슈퍼볼 3:하이퍼볼 4:마스터볼

    public boolean Show(int kind)
    {
        if(kind==0)
        {
            return Show_Recovery_Pills();
        }
        if(kind==1)
        {
           return Show_Candy();
        }
        if(kind==2)
        {
            return Show_MonsterBall();
        }
        return true;
    }

    public boolean Show_Recovery_Pills()
    {
        if(Recovery_Pills.get(0)==0)
        {
            System.out.println("사용할 수 있는 물약이 없습니다.");
            return false;
        }
        else
        {
            System.out.println("사용가능한 물약");
            System.out.println("일반 회복약 : "+ Recovery_Pills.get(
                    1)+"개");
            System.out.println("일반 회복약 : "+ Recovery_Pills.get(2)+"개");
            return true;
        }

    }
    public boolean Show_Candy()
    {
        if(Candy==0)
        {
            System.out.println("사용할 수 있는 사탕이 없습니다.");
            return false;
        }
        else
        {
            System.out.println("사용가능한 물역."+Candy + "개");
            return true;
        }
    }
    public boolean Show_MonsterBall() {
        if (MonsterBall.get(0) == 0) {
            System.out.println("사용할 수 있는 몬스터볼이 없습니다.");
            return false;
        } else {
            System.out.println("사용가능한 물약");
            System.out.println("포켓볼 : "+ MonsterBall.get(1)+"개");
            System.out.println("슈퍼볼 : "+ MonsterBall.get(2)+"개");
            System.out.println("하이퍼볼 : "+ MonsterBall.get(3)+"개");
            System.out.println("마스터볼 : "+ MonsterBall.get(4)+"개");
            return true;
        }

    }


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

