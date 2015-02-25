import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class LevelOnePanel extends JPanel implements KeyListener, Runnable {
  private BufferedImage image;
  private PlayerOne p1;
  private AttackerPlane a;
  private Thread t;
  private boolean collided;

  LevelOnePanel(PlayerOne p1) {
    try {
      image = ImageIO.read(new File("Images/sky_background.png"));
    } catch (IOException e) {
      System.out.println("Background image not found");
    }
    this.p1 = p1;
    a = new AttackerPlane();

    collided = false;

    this.addKeyListener(this);
    this.setFocusable(true);
    this.requestFocusInWindow();

    start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);

    a.draw(g, this);
    p1.draw(g, this);

    //Simply prints "collision" at the top
    if (collided) {
      g.setColor(Color.white);
      g.setFont(new Font("default", Font.BOLD, 16));
      g.drawString("Collision!", 300, 20);
    }

    revalidate();
    repaint();
  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    System.out.println("Key pressed");

    //controls the player plane
    if (key == 'A' || key == KeyEvent.VK_LEFT) {
      p1.moveLeft();
    } else if (key == 'D' || key == KeyEvent.VK_RIGHT) {
      p1.moveRight();
    } else if (key == 'W' || key == KeyEvent.VK_UP) {
      p1.moveUp();
    } else if (key == 'S' || key == KeyEvent.VK_DOWN) {
      p1.moveDown();
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public void run() {
    System.out.println("Running attacking thread");

    while (true) {
      a.moveDown();

      System.out.println("Attacker moving down");
      try {
        Thread.sleep(100);
      }
      catch (InterruptedException e) {
        System.out.println("Interrupted");
      }

      collided = checkCollision(p1, a);

      revalidate();
      repaint();

      if (a.getY() >= 750) {
        a.setX(a.getRandomX());
        a.setY(0);
        System.out.println("Attacker plane going back to top");
      }
    }
  }

  public void start() {
    System.out.println("Starting attacking thread");
    if (t == null) {
      t = new Thread(this, "attackingThread");
      t.start();
    }
  }

  public boolean checkCollision(PlayerOne p1, AttackerPlane a) {
    if (((p1.getX() + p1.getSizeX()) < a.getX()) ||
      ((a.getX() + a.getSizeX()) < p1.getX()))
      return false;

    if ((p1.getY() + p1.getSizeY() < a.getY()) ||
      (a.getY() + a.getSizeY() < p1.getY()))
      return false;

    return true;
  }
}
