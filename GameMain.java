import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

class GameMain extends JFrame {
  private JPanel mainPanel, levelOnePanel;
  private JButton startButton;
  private PlayerOne p1;
  private int currentLevel;

  GameMain() {
    currentLevel = 0;
    p1 = new PlayerOne();

    add(startMenu());
  }

  private JPanel startMenu() {
    mainPanel = new JPanel(new GridLayout(3, 3));

    startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentLevel = 1;
        System.out.println("Button clicked");

        remove(mainPanel);

        levelOnePanel = new LevelOnePanel(p1);
        add(levelOnePanel);

        validate();
        repaint();
      }
    });

    mainPanel.add(new JLabel(""));
    mainPanel.add(new JLabel(""));
    mainPanel.add(new JLabel(""));

    mainPanel.add(new JLabel(""));
    mainPanel.add(startButton);
    mainPanel.add(new JLabel(""));

    mainPanel.add(new JLabel(""));
    mainPanel.add(new JLabel(""));
    mainPanel.add(new JLabel(""));

    return mainPanel;
  }
}
