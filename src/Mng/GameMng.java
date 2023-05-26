package Mng;

import Framework.Scene;
import Scenes.MenuScene;

import java.awt.*;

public class GameMng{
    private GameMng() {
        curScene = new MenuScene();
        curScene.Start();
    }
    private static GameMng instance;

    public boolean isPlaying = true;

    private Scene curScene;
    private Scene prevScene;

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


}
