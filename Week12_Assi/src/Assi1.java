import java.awt.*;
import javax.swing.*;

public class Assi1 extends JFrame{
	private ImageIcon left = new ImageIcon("images/left.png"); // 왼쪽 이미지 아이콘
	private ImageIcon right = new ImageIcon("images/right.png"); // 오른쪽 이미지 아이콘
	private JLabel imageLabel = new JLabel(); // 이미지를 계속 바꾸기 위해 라벨을 생성
	
	private int currentIdx = 0; // 그림을 바꾸기 위해 사용할 인덱스
	
	private ImageIcon[] image = { // 이미지를 변경하기 위해 이미지 아이콘을 배열로 지정
			new ImageIcon("images/image0.jpg"),
			new ImageIcon("images/image1.jpg"),
			new ImageIcon("images/image2.jpg"),
			new ImageIcon("images/image3.jpg")
	};
	
	public Assi1() {
		setTitle("과제 1 - 버튼으로 사진 바꾸는 사진첩");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		imageLabel.setIcon(image[0]); // 처음 이미지는 0번 인덱스 이미지
		imageLabel.setHorizontalAlignment(JLabel.CENTER); // 중앙 정렬
		
		c.add(imageLabel, BorderLayout.CENTER); // 중앙에 그림을 전시하기 위해 컨테이너에 추가
		
		JPanel buttonPanel = new JPanel(); // 버튼을 넣기위한 패널
		
		JButton leftButton = new JButton(left); // 패널에 넣기위한 버튼
		JButton rightButton = new JButton(right); // 패널에 넣기위한 버튼
		
		buttonPanel.add(leftButton); // 패널에 버튼 추가
		buttonPanel.add(rightButton); // 패널에 버튼 추가 
		
		c.add(buttonPanel, BorderLayout.SOUTH); // 패널을 컨테이너에 추가
		
		
		
		// 이벤트 처리
		leftButton.addActionListener(e -> { // 왼쪽 버튼
				currentIdx--;  // 현재 인덱스를 감소 시킴
				if(currentIdx < 0) { // 만약 인덱스가 0보다 작다면
					currentIdx = image.length - 1; // 이미지의 길이 4에 -1을 해서 3이됨 마지막으로 넘어감 
					}
					imageLabel.setIcon(image[currentIdx]); // 그 후 라벨의 이미지를 인덱스 번호로 지정 if문을 수행했다면 4번째 아니라면 왼쪽으로 한번
					});
		
		rightButton.addActionListener(e -> { // 오른쪽 버튼 
			currentIdx = (currentIdx + 1) % image.length; // 인덱스 + 1 % 이미지 길이 : 4 이렇게 하면 어떤 상태든 0,1,2,3 유지 가능
			imageLabel.setIcon(image[currentIdx]); // 
			});
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Assi1();

	}

}
