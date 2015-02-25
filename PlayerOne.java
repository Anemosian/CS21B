import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics2D;

public class PlayerOne {
  private BufferedImage image;
  private int x, y, sizeX, sizeY;

  PlayerOne() {
    sizeX = 128;
    sizeY = 220;

    x = 300 - (sizeX / 2);
    y = 750 - sizeY;
  }

  public void draw(Graphics g, JPanel panel) {
/*    image = new BufferedImage(128, 220, java.awt.image.BufferedImage.TYPE_INT_ARGB);

    Graphics2D graphics = image.createGraphics();
    panel.print(graphics);
    graphics.dispose();*/

    try {
      image = ImageIO.read(new File("Images/player1.png"));
    } catch (IOException ex) {
      System.out.println("Player1 avatar not found");
    }

    g.drawImage(image, x, y, null);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }

  public void moveLeft() {
    x -= 5;
  }

  public void moveRight() {
    x += 5;
  }

  public void moveUp() {
    y -= 5;
  }

  public void moveDown() {
    y += 5;
  }
}
