import javax.swing.*;
import java.awt.*;

public class GraphicHero {
    final int MOVE_STEP = 8;
    final int MAX_X = 500;
    final int FLOOR_Y = 200;

    int x;
    int y;
    int imgWidth = 21;
    int imgHeight = 26;
    int dir; // dir = 1이면 오른쪽, dir = 2면 왼쪽
    int count;

    ImageIcon heroImgIcon[] = new ImageIcon[6];
    Image img[] = new Image[6];

    public GraphicHero(int x) {
        this.x = x;
        this.y = FLOOR_Y - imgHeight;

        // 실제 이미지 파일 이름이 hero01.png ~ hero06.png이므로 01, 02 형식으로 읽는다.
        for (int i = 0; i < 6; i++) {
            String fileName = String.format("images/hero%02d.png", i + 1);
            heroImgIcon[i] = new ImageIcon(fileName);
            img[i] = heroImgIcon[i].getImage();
        }
    }

    public void moveleft() {
        x = x - MOVE_STEP;
        if (x < 0) x = 0;
        dir = 2;
        count++;
    }

    public void moveRight() {
        x = x + MOVE_STEP;
        if (x > MAX_X - imgWidth) x = MAX_X - imgWidth;
        dir = 1;
        count++;
    }

    public void paint(Graphics g) {
        // 오른쪽은 0,1,2번 이미지 / 왼쪽은 3,4,5번 이미지를 번갈아 사용한다.
        if (dir == 1) {
            g.drawImage(img[count % 3], x, y, null);
        } else if (dir == 2) {
            g.drawImage(img[(count % 3) + 3], x, y, null);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, imgWidth, imgHeight);
    }
}
