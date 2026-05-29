import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class KartMove extends JFrame implements Runnable {
	ImageIcon imgIcon;
	Image img;
	Thread th;
	Kart kart1;
	Kart kart2;
	
	public KartMove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setUndecorated(true);    

		setVisible(true);
		//이미지 로드
		imgIcon = new ImageIcon("./images/kart.gif");
		img = imgIcon.getImage();

		// 처음 좌표 초기화
		kart1 = new Kart(100, 100, img);
		//kart2 = new Kart(70, 70, img);
	
		new Thread(this).start();

	}

	public void start() {
		  if(th==null){
			  th= new Thread(this);
			  th.start();
	    }
	  }
	
	  public void paint(Graphics g) {
		  
		  //바탕 지우기
		  g.setColor(Color.WHITE);
		  g.fillRect(0, 0, 200, 200);
			
		  // 카트 이미지 그리기
		  kart1.paint(g);
		  //kart2.paint(g);
	  }

	  public void run() {
		  
		  while(true) {
			  
			  // 0.2초간 슬립
			  try {
				  Thread.sleep(200);				  
			  } catch(Exception e) { }
			  
			  // 카트  움직이기
			  kart1.randomMove();
			  // kart2.randomMove();
	
			  // 화면 갱신
			  repaint();
		  }
	  }
	  
	  public static void main(String[] args) {
			// TODO Auto-generated method stub
			new KartMove().setTitle("좀비 게임");
	  }

}
