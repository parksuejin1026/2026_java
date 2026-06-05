import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphicHero {
    final int MOVE_STEP = 5;
    final int MAX_X = 500;
    final int MAX_Y = 300;
    final int GROUND_Y = 174;
    final int JUMP_POWER = 12;
    final int GRAVITY = 4;

    int x;
    int y;
    int imgWidth = 21;
    int imgHeight = 26;
    int dir; // dir = 1이면 오른쪽, dir = 2면 왼쪽
    int count;
    int jumpSpeed;
    Random r = new Random();
    boolean toggle;
    boolean jump;

    ImageIcon heroImgIcon[] = new ImageIcon[6];
    Image img[] = new Image[6];
    
    public GraphicHero(int x, int y) {
        this.x = x;
        this.y = y;

        for ( int i = 0 ; i < 6 ; i++ ) {
            heroImgIcon[i] = new ImageIcon(String.format("images/hero%02d.png", i + 1));
            img[i] = heroImgIcon[i].getImage();
        }
    } 
    public void moveleft() {
        x = x - MOVE_STEP;
        if ( x < 0) x = 0;
    }

    public void moveRight() {
        x = x + MOVE_STEP;
        if ( x > MAX_X - imgWidth) x = MAX_X - imgWidth;
    }

    public boolean heroMove() {
        count++;

        if (jump == true) {
            y = y - jumpSpeed;
            jumpSpeed = jumpSpeed - GRAVITY;

            if (y >= GROUND_Y) {
                y = GROUND_Y;
                jump = false;
                jumpSpeed = 0;
            }
        }

        if(x >= MAX_X - imgWidth) return true;
        else return false;
        
    }

    public void jump() {
        if (jump == false) {
            jump = true;
            jumpSpeed = JUMP_POWER;
        }
    }

    public void paint(Graphics g) { // 토글이 바뀔 때마다 이미지를 변경하여 움직이는 듯한 느낌
        if (dir == 1) g.drawImage(img[count % 2], x, y, null);
        else if (dir == 2) g.drawImage(img[(count % 2) + 3], x, y, null);
    }

    // public boolean crush() {

    // }
}
