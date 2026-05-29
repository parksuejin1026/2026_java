import java.awt.*;
import java.util.*;

public class Kart {
	
	final int MOVE_STEP = 10;		// 캐릭터가 움직이는 간격
	final int MAX_X = 200;				// 맵 크기 x(픽셀)
	final int MAX_Y = 200;				// 맵 크기 y(픽셀)
	
	int x;										// 캐릭터 x 좌표값(픽셀)
	int y;										// 캐릭터 y 좌표값(픽셀)
	int dir;										// 캐릭터 방향
	int mapx;		
	int mapy;
	
	Image img[];							// 캐릭터 이미지를 담기 위한 배열
	int imgWidth = 20;						// 캐릭터 이미지 크기
	int imgHeight = 20;					// 캐릭터 이미지 크기
	boolean status = false;			// 충돌이 됐는지 알기 위한 상태 변수
	
	Random r = new Random();
	
	public Kart(int x, int y, Image img[]) {
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public void moveLeft() {
		x = x - MOVE_STEP;
		if(x < 0) x = 0;
	}
	
	public void moveRight() {
		x = x + MOVE_STEP;
		if(x > MAX_X - imgWidth) x = MAX_X - imgWidth;
	}
	
	public void moveUp() {
		y = y - MOVE_STEP;
		if(y < 0) y = 0; 
	}
	
	public void moveDown() {
		y = y + MOVE_STEP;
		if(y > MAX_Y - imgHeight) y = MAX_X - imgHeight;
	}
	
	// 자동으로 움직이기 위한 메소드
	public void randomMove() {
		
		dir = r.nextInt(4);		
		
		if(dir==0) moveDown();
		else if(dir==1) moveUp();
		else if(dir==2) moveLeft();
		else if(dir==3) moveRight();
	}
	
	// 다른 캐릭터와 충돌했는지 확인하는 메소드 (인수로 다른 캐릭터의 좌표를 넣어줌)
	// 내 캐릭터 좌표 안에 적의 좌표가 들어왔는지 확인
	public void checkCrash(int ex, int ey) {
	
		if ((x <= ex) && (ex <= (x + 20))) {
			if((y <= ey) && ( ey <= (y + imgHeight))) {
				// 충돌
				status = true;
			}
		}		
		else if ((x <= ex + imgWidth) && (ex + imgWidth <= (x + imgWidth))) {
			if((y <= ey) && ( ey <= (y + imgHeight))) {
				// 충돌
				status = true;
			}
		}
		else if ((x <= ex) && (ex <= (x + imgWidth))) {
			if((y <= ey + imgHeight) && ( ey + imgHeight <= (y + imgHeight))) {
				//
				status = true;
			}
		}		
		else if ((x <= ex + imgWidth) && (ex + imgWidth <= (x + imgWidth))) {
			if((y <= ey + imgHeight) && ( ey + imgHeight <= (y + imgHeight))) {
				//
				status = true;
			}
		}	
		
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
		
		// 내 상태가 충돌일 경우에는 충돌 메시지 출력
		if(status == true)
			g.drawString("꽝!!! 부딪쳤습니다.", 50, 100);
	}
}
