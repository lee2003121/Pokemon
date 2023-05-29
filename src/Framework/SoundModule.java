package Framework;

import java.io.*;
import javax.sound.sampled.*;
public class SoundModule {

    static void playSound(String fileName, int playTime){ // playTime은 millisecond단위, soundfile은 wav여야함
        try {
            File file = new File(fileName);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            Thread.sleep(playTime);
            /*
            소리가 정상적으로 출력되려면 sleep이 필요한거같음.
            내 테스트 환경에서 sleep이 없으면 소리 출력전에 프로그램이 완료되서 소리가 안나옴
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
