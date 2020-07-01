import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private Integer x, y;
    private GearSwitch gearSwitch = GearSwitch.STOP;
    private DirectionEnum directionEnum = DirectionEnum.UP;

    public static final  int SPEED = 5;


    public Tank(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        if (directionEnum == DirectionEnum.UP) {
            g.fillRect(x, y, 30, 50);
            g.fillRect(x+12, y-20, 6, 20);
        }
        else if (directionEnum == DirectionEnum.DOWN) {
            g.fillRect(x, y, 30, 50);
            g.fillRect(x+12, y+50, 6, 20);
        }else if (directionEnum == DirectionEnum.LEFT){
            g.fillRect(x, y, 50 , 30);
            g.fillRect(x-20, y+12, 20, 6);
        }else {
            g.fillRect(x, y, 50 , 30);
            g.fillRect(x+50, y+12, 20, 6);
        }

    }

    public void move(){
        if (this.gearSwitch == GearSwitch.STOP) {
            return;
        }
        int speed;

        if (this.gearSwitch == GearSwitch.DRIVE){
            speed = SPEED;
        }else {
            speed = -SPEED;
        }

        switch (this.directionEnum) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            default:
                break;
        }
    }

    public void changeDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                directionEnum = directionEnum.getLeftDir();
                break;
            case KeyEvent.VK_RIGHT:
                directionEnum = directionEnum.getRightDir();
                break;
            case KeyEvent.VK_UP:
                if ( gearSwitch == GearSwitch.REVERSE) {
                    gearSwitch = GearSwitch.STOP;
                }else {
                    gearSwitch = GearSwitch.DRIVE;
                }

                break;
            case KeyEvent.VK_DOWN:
                if (gearSwitch == GearSwitch.DRIVE) {
                    gearSwitch = GearSwitch.STOP;
                }else {
                    gearSwitch = GearSwitch.REVERSE;
                }
                break;
            default:
                break;

        }
    }
}
