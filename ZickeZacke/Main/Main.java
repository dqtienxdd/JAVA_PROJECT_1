package Main;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
    public static void main(String[] args){
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Zicke Zacke Hühnerkacke");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);
       
    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);
    gamePanel.setupGame();
    gamePanel.startGameThread();
    }
}