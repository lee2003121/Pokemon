package Framework;

import java.util.Scanner;

public class Scene {
    Scanner sc;
    protected String inputData;
    public void Start()
    {

    }
    public void Update()
    {
        System.out.println("Update");
        sc = new Scanner(System.in);
        inputData = sc.next();
        sc.close();
    }

    public void Draw()
    {
        //System.out.println("Draw");
    }

    public void Exit()
    {
        sc.close();
    }

    public String GetInputData()
    {
        return inputData;
    }
}
