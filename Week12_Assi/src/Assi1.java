import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Assi1 extends JFrame{
	private ImageIcon left = new ImageIcon("images/left.png");
	private ImageIcon right = new ImageIcon("images/right.png");
	private JLabel imageLabel = new JLabel();
	private int currentIdx = 0;
	private ImageIcon[] image = {
			new ImageIcon("images/image0.jpg"),
			new ImageIcon("images/image1.jpg"),
			new ImageIcon("images/image2.jpg"),
			new ImageIcon("images/image3.jpg")
	};
	
	public Assi1() {
		setTitle("과제 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		imageLabel.setIcon(image[0]);
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		c.add(imageLabel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		
		JButton leftButton = new JButton(left);
		JButton rightButton = new JButton(right);
		
		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);
		
		c.add(buttonPanel, BorderLayout.SOUTH);
		
		
		
		// 이벤트 처리
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIdx--;
				if(currentIdx < 0) {
					currentIdx = image.length - 1;
					}
					imageLabel.setIcon(image[currentIdx]);
					} 
			
				});
			
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			currentIdx = (currentIdx + 1) % image.length;
			imageLabel.setIcon(image[currentIdx]);
			}
		});
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Assi1();

	}

}
