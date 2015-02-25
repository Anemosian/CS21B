import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics2D;
import java.util.Random;

public class AttackerPlane {
  private BufferedImage image;
  private int x, y, sizeX, sizeY;

  AttackerPlane() {
    sizeX = 128;
    sizeY = 180;

    x = getRandomX();
    y = 0;
  }

  public int getRandomX() {
    Random rand = new Random();
    int n = rand.nextInt(750 - sizeX);

    return n;
  }

  public void draw(Graphics g, JPanel panel) {
/*    image = new BufferedImage(128, 220, java.awt.image.BufferedImage.TYPE_INT_ARGB);

    Graphics2D graphics = image.createGraphics();
    panel.print(graphics);
    graphics.dispose();*/

    try {
      image = ImageIO.read(new File("Images/attacker_plane.png"));
    } catch (IOException ex) {
      System.out.println("Attacker plane avatar not found");
    }

    g.drawImage(image, x, y, null);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }

  public void moveLeft() {
    x -= 10;
  }

  public void moveRight() {
    x += 10;
  }

  public void moveUp() {
    y -= 10;
  }

  public void moveDown() {
    y += 10;
  }
}
