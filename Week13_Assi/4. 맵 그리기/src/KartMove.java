import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class KartMove extends JFrame implements Runnable {
	ImageIcon[] imgIcon = new ImageIcon[5];
	Image img[] = new Image[4];
	Image wood_img;	
	Thread th;
	Kart kart1;
	Kart kart2;
	
	int map[][] = {	{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },					// 10 * 10 크기의 맵 
			{ 1, 0, 0, 0, 0, 1, 0, 0, 1, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{ 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1} };
	
	public KartMove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 230);
		setUndecorated(true);    

		setVisible(true);
		//이미지 로드
		imgIcon[0] = new ImageIcon("./images/char_up.gif");
		img[0] = imgIcon[0].getImage();
		imgIcon[1] = new ImageIcon("./images/char_down.gif");
		img[1] = imgIcon[1].getImage();
		imgIcon[2] = new ImageIcon("./images/char_left.gif");
		img[2] = imgIcon[2].getImage();
		imgIcon[3] = new ImageIcon("./images/char_right.gif");
		img[3] = imgIcon[3].getImage();

		imgIcon[4] = new ImageIcon("./images/map_wood.png");
		wood_img = imgIcon[4].getImage();

		// 처음 좌표 초기화
		kart1 = new Kart(100, 100, img);
		kart2 = new Kart(150, 150, img);
	
		new Thread(this).start();

	}

	public void start() {
		  if(th==null){
			  th= new Thread(this);
			  th.start();
	    }
	  }
	
	  public void paint(Graphics g) {
		  
		  //검은색으로 지우기
		  g.setColor(Color.white);
		  g.fillRect(0, 0, 200, 200);
			
		  drawMap(g);

		  // 카트 이미지 그리기
		  kart1.paint(g);
		  kart2.paint(g);
	  }

	  public void run() {
		  
		  while(true) {
			  
			  // 0.2초간 슬립
			  try {
				  Thread.sleep(200);				  
			  } catch(Exception e) { }
			  
			  // 카트  움직이기
			  kart1.randomMove();
			  kart2.randomMove();
	
			  // 화면 갱신
			  repaint();
		  }
	  }
	  
	  // 맵 배열을 이용하여 맵 그리기
	  public void drawMap(Graphics g) {
		  int xp = 0;	// 맵을 그리기 위한 x 좌표
		  int yp = 30;	// 맵을 그리기 위한 y 좌표
		  
		  for(int i = 0; i < map.length; i++) {
			  for(int j = 0; j < map.length; j++) {
				  // 맵 배열의 값이 1이면 나무를 그림
				  if(map[i][j] == 1) g.drawImage(wood_img, xp, yp, this);
				  // 하나 그리고 다음 좌표로 이동하기 위해 xp 값 증가
				  xp += 20;
			  }
			  // 한줄 다 그리고 나서 한 줄 내려와서 다음 줄 그리기
			  xp = 0;
			  yp += 20;
		  }
	  }
	  
	  public static void main(String[] args) {
			// TODO Auto-generated method stub
			new KartMove().setTitle("좀비 게임");
	  }

}
