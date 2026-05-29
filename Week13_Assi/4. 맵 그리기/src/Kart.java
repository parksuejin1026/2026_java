import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Kart {
	
	final int MOVE_STEP = 10;		// 캐릭터가 움직이는 간격
	final int MAX_X = 400;				// 맵 크기 x(픽셀)
	final int MAX_Y = 400;				// 맵 크기 y(픽셀)
	int dir;
	
	int x;										// 캐릭터 x 좌표값(픽셀)
	int y;										// 캐릭터 y 좌표값(픽셀)	
	
	Image img[];								// 캐릭터 이미지를 담기 위한 배열
	int imgWidth = 20;						// 캐릭터 이미지 크기
	int imgHeight = 20;					// 캐릭터 이미지 크기
	boolean status = false;			// 충돌이 됐는지 알기 위한 상태 변수
	
	Random r = new Random();
	
	public Kart(int x, int y, Image img[]) {
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	// 상
	public void moveUp() {
		y = y - MOVE_STEP;
		if(y < 0) y = 0; 
	}
	
	// 하
	public void moveDown() {
		y = y + MOVE_STEP;
		if(y > MAX_Y - imgHeight) y = MAX_X - imgHeight;
	}
	
	// 좌
	public void moveLeft() {
		x = x - MOVE_STEP;
		if(x < 0) x = 0;
	}
	
	// 우 
	public void moveRight() {
		x = x + MOVE_STEP;
		if(x > MAX_X - imgWidth) x = MAX_X - imgWidth;
	}	
	
	// 자동으로 움직이기 위한 메소드
	public void randomMove() {
			
			dir = r.nextInt(4);		
			
			if(dir==0) moveDown();
			else if(dir==1) moveUp();
			else if(dir==2) moveLeft();
			else if(dir==3) moveRight();
	}

	// 화면에 그리기
	public void paint(Graphics g) {
		// 캐릭터의 상태에 따라 다른 이미지를 그려줌
		if(dir == 0)
			g.drawImage(img[0], x, y, null);
		else if(dir == 1)
			g.drawImage(img[1], x, y, null);
		else if(dir == 2)
			g.drawImage(img[2], x, y, null);
		else if(dir == 3)
			g.drawImage(img[3], x, y, null);	
	}
}
