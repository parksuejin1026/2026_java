import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class KartMove extends JFrame implements Runnable {
	ImageIcon[] imgIcon = new ImageIcon[4];
	Image img[] = new Image[4];
	Thread th;
	Kart kart1;
	Kart kart2;
	
	public KartMove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
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
	
			  // 충돌 체크
			  kart1.checkCrash(kart2.x, kart2.y);
			  kart2.checkCrash(kart1.x, kart1.y);
			  
			  // 화면 갱신
			  repaint();
			  
			  // 충돌 상태 확인 후 반복문 빠져나감
			  if((kart1.status == true)||(kart2.status == true)) break;		
		  }
	  }
	  
	  public static void main(String[] args) {
			// TODO Auto-generated method stub
			new KartMove().setTitle("좀비 게임");
	  }

}
