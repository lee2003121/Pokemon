package Framework;

import java.util.Scanner;

public class Scene {

    protected String inputData;
    public void Start()
    {

    }
    public void Update()
    {
        //System.out.println("Update");
        Scanner sc = new Scanner(System.in);
        inputData = sc.next();
        sc.close();
    }

    public void Draw()
    {
        //System.out.println("Draw");
    }

    public void Exit()
    {
        System.out.println("Exit");
    }

    public String GetInputData()
    {
        return inputData;
    }
}
