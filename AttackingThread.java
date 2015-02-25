import javax.swing.*;
import java.awt.*;

public class AttackingThread implements Runnable {
  private Thread t;
  private String threadName;
  private AttackerPlane avatar;
  private JPanel panel;

  AttackingThread(JPanel p) {
    threadName = "attackingThread";
    avatar = new AttackerPlane();
    panel = p;
  }

  public void run() {
    System.out.println("Running attacking thread");

    while (avatar.getY() <= 750) {
      avatar.moveDown();
      try {Thread.sleep(10);}
      catch (InterruptedException e) {System.out.println("Interrupted");}
    }
  }

  public void start() {
    System.out.println("Starting attacking thread");
    if (t == null) {
      t = new Thread(this, threadName);
      t.start();
    }
  }
}
