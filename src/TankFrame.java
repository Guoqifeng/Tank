/**
 * @author GQF
 */
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame{
    Tank myTank;

    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        this.addKeyListener(new TankKeyListener());

        myTank = new Tank(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        myTank.move();

    }

    private class TankKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.changeDirection(e);




        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }


}
