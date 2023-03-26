package main;

import javax.swing.*;

public class GameWindow extends JFrame {

    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack(); //miesci sie w oknie
        jframe.setVisible(true);
    }
}
