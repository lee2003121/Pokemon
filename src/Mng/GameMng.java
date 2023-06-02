package Mng;

import Framework.Scene;
import Game.PokemonInfo;
import Scenes.MenuScene;

import java.util.Random;
import java.util.Scanner;

public class GameMng{

    //랜덤
    Random random;

    //입력 모듈
    public Scanner scanner;

    //상성표 데이터
    public int[][] compatibility_Table;

    private GameMng() {
        //메뉴에서 시작
        curScene = new MenuScene();
        curScene.Start();

        random = new Random();
        scanner = new Scanner(System.in);

        String data = FileMng.getInstance().LoadFile("etc/compatibility.csv");
        compatibility_Table = ParseToCompatibility(data);
    }
    private static GameMng instance;
    public boolean isPlaying = true;

    private Scene curScene;
    private Scene prevScene;

    //싱글톤 패턴
    public  static GameMng getInstance()
    {
        if(instance == null)
            instance = new GameMng();
        return instance;
    }
    private void Update()
    {
        if(curScene != null)
            curScene.Update();
    }

    private void Draw()
    {
        if(curScene != null)
            curScene.Draw();
    }

    public void GameLoop()
    {
        while (isPlaying)
        {
            Draw();
            Update();
        }
    }

    //현재 씬을 바꾸는 함수
    public void ChangeState(Scene scene)
    {
        if(scene != null) {
            prevScene = curScene;
            curScene.Exit();
            curScene = scene;
            curScene.Start();
        }
    }

    //전에 있는 씬으로 돌아가는 것.
    public void ChangePrevScene()
    {
        ChangeState(prevScene);
    }

    public Random GetRandom()
    {
        random.setSeed(System.currentTimeMillis());
        return random;
    }

    public int TypeToString(String type)
    {
        switch (type)
        {
            case "노말":
                return 0;
            case "격투":
                return 1;
            case "비행":
                return 2;
            case "독":
                return 3;
            case "땅":
                return 4;
            case "바위":
                return 5;
            case "벌레":
                return 6;
            case "고스트":
                return 7;
            case "강철":
                return 8;
            case "불꽃":
                return 9;
            case "물":
                return 10;
            case "풀":
                return 11;
            case "전기":
                return 12;
            case "에스퍼":
                return 13;
            case "얼음":
                return 14;
            case "드래곤":
                return 15;
            case "악":
                return 16;
            case "페어리":
                return 17;

        }
        return -1;
    }

    static int[][] ParseToCompatibility(String data)
    {
        String[] lines = data.split("\n");
        int[][] dataArr = new int[lines.length][lines.length];

        for(int i=0;i< lines.length;i++)
        {
            String[] numbers = lines[i].split(",");
            for(int j=0;j<numbers.length;j++)
            {
                dataArr[i][j] = Integer.parseInt(numbers[j].trim());
            }
        }
        return dataArr;
    }
}
