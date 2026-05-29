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
	int map[][];
	
	Image img[];								// 캐릭터 이미지를 담기 위한 배열
	int imgWidth = 20;						// 캐릭터 이미지 크기
	int imgHeight = 20;					// 캐릭터 이미지 크기
	boolean status = false;			// 충돌이 됐는지 알기 위한 상태 변수
	
	Random r = new Random();
	
	public Kart(int x, int y, Image img[], int map[][]) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.map = map;
	}
	
	public void moveLeft() {
		x = x - MOVE_STEP;
		if(x < 0) x = 0;
		if(checkCrashMap() == true) x = x + MOVE_STEP;
	}
	
	public void moveRight() {
		x = x + MOVE_STEP;
		if(x > MAX_X - imgWidth) x = MAX_X - imgWidth;
		if(checkCrashMap() == true) x = x - MOVE_STEP;
		
	}
	
	public void moveUp() {
		y = y - MOVE_STEP;
		if(y < 0) y = 0; 
		if(checkCrashMap() == true) y = y + MOVE_STEP;
	}
	
	public void moveDown() {
		y = y + MOVE_STEP;
		if(y > MAX_Y - imgHeight) y = MAX_X - imgHeight;
		if(checkCrashMap() == true) y = y - MOVE_STEP;
	}
	
	public void checkCrashEnermy(int ex, int ey) {
		
		status = checkCrash(ex, ey);
		
	}
	
	public boolean checkCrashMap() {
		int ex = 0;
		int ey = 0;
		for(int i= 0; i<map.length; i++) {
			for(int j=0; j <map.length; j++) {
				if(map[i][j] == 1) {
					
					if(checkCrash(ex, ey)== true) return true;
					
				}					
				 ex += 20;
			}
			 ex = 0;
			 ey += 20;
		}
		return false;		
	}
	
	public boolean checkCrash(int ex, int ey) {
		
		if ((ex < x) && (x < (ex + imgWidth))) {
			if(ey == y) return true;		// 나의 x 좌표가 적가 겹치고, 나와 적의  y 좌표가 같은 경우 
			else if(((ey < y) && ( y < (ey + imgHeight))) || ((ey < y + imgHeight) && ( y + imgHeight < (ey + imgHeight)))) {
				// 충돌
				return true;
			}
		}		
		else if ((ex < x + imgWidth) && (x + imgWidth < (ex + imgWidth))) {
			if(ey == y) return true;
			else if(((ey < y) && ( y < (ey + imgHeight))) || ((ey < y + imgHeight) && ( y + imgHeight < (ey + imgHeight)))) {
				// 충돌
				return true;
			}
		}		
		else if ((ey < y) && (y < (ey + imgHeight))) {
			if(ex == x) return true;
			else if(((ex < x) && ( x < (ex + imgWidth))) || ((ex < x + imgWidth) && ( x + imgWidth < (ex + imgWidth)))) {
				// 충돌
				return true;
			}
		}
		else if ((ey < y + imgHeight) && (y + imgHeight < (ey + imgHeight))) {
			if(ex == x) return true;
			else if(((ex < x) && ( x < (ex + imgWidth))) || ((ex < x + imgWidth) && ( x + imgWidth < (ex + imgWidth)))) {
				// 충돌
				return true;
			}
		}
		
		return false;
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
