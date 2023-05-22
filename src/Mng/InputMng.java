package Mng;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InputMng extends JFrame implements KeyListener {
    public InputMng() {
        super("Event Based Keyboard Input Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        addKeyListener(this);
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        System.out.println("Key Typed: " + keyChar);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Key Pressed: " + keyCode);
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Key Released: " + keyCode);
    }

    public static void main(String[] args) {
        //new InputMng();
        // ExecutorService 생성
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 이름 입력 받는 작업
        System.out.print("이름을 입력하세요: ");
        executor.submit(() -> {
            String name = scanner.nextLine();
            System.out.println("입력된 이름: " + name);
        });

        // 사용자로부터 나이 입력 받는 작업
        System.out.print("나이를 입력하세요: ");
        executor.submit(() -> {
            int age = scanner.nextInt();
            System.out.println("입력된 나이: " + age);
        });

        // ExecutorService 종료
        executor.shutdown();


        // Scanner 닫기
        scanner.close();
    }
}
